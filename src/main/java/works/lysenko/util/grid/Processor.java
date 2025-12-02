package works.lysenko.util.grid;

import org.apache.commons.math3.fraction.Fraction;
import works.lysenko.util.apis.grid.g._GridCalculator;
import works.lysenko.util.apis.grid.g._GridProcessor;
import works.lysenko.util.apis.grid.q._FractionQuotas;
import works.lysenko.util.func.grid.colours.ValuedRangeResult;
import works.lysenko.util.grid.record.misc.IgnoreHSB;
import works.lysenko.util.grid.record.rgbc.HSB;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static works.lysenko.util.data.range.AbstractQuotas.LOWER_LIMIT;
import static works.lysenko.util.data.records.RGB24.rgb24;
import static works.lysenko.util.data.strs.Swap.i;
import static works.lysenko.util.func.type.Objects.isNotNull;
import static works.lysenko.util.func.type.fractions.Factory.fr;
import static works.lysenko.util.prop.grid.Validation.fences;

/**
 * The Processor class implements the _GridProcessor interface and provides methods for calculating rates of pixel values.
 */
@SuppressWarnings({"MissingJavadoc", "DataFlowIssue", "StandardVariableNames"})
public class Processor implements _GridProcessor {

    private final _GridCalculator calculator;

    public Processor(final _GridCalculator calculator) {

        this.calculator = calculator;
    }

    /**
     * Calculates the rates based on the given values and total number of pixels.
     *
     * @param values      a map containing the values as keys and their corresponding counts as values
     * @param totalPixels an integer representing the total number of pixels
     * @return a map containing the values as keys and their corresponding rates as values
     */
    private static Map<Integer, Double> calculateRates(final Map<Integer, Integer> values, final int totalPixels) {

        return values.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> (double) e.getValue() / totalPixels));
    }

    /**
     * Retrieves a map of Fraction keys and Fraction values from a given map of Integer keys and Fraction values.
     *
     * @param q   an integer representing a fences value
     * @param raw a map containing Integer keys and Fraction values
     * @return a map containing Fraction keys and corresponding Fraction values based on the fences value
     */
    private static Map<Fraction, ValuedRangeResult> getFractionActualFractionMap(final int q, final Map<Integer, ?
            extends ValuedRangeResult> raw) {

        final Map<Fraction, ValuedRangeResult> map = new LinkedHashMap<>(raw.size());
        raw.forEach((key, value) -> {
            final Fraction hueFraction = fr(key, q);
            map.put(hueFraction, value);
        });
        return map;
    }

    /**
     * Retrieves the rates based on the given values.
     *
     * @param values a map containing the values as keys and their corresponding counts as values
     * @return a map containing the values as keys and their corresponding rates as Fraction values
     */
    @SuppressWarnings("unused")
    private static Map<Integer, ValuedRangeResult> getRates(final Map<Integer, Integer> values) {

        return getRatesWithThreshold(values, Fraction.ZERO);
    }

    /**
     * Retrieves the rates with values greater than or equal to a specified threshold fraction.
     *
     * @param values    a map containing the values as keys and their corresponding counts as values
     * @param threshold a fraction representing the minimum threshold for rate values to be included
     * @return a map containing the values as keys and their corresponding rates as Fraction values,
     * where the rates are greater than or equal to the threshold
     */
    private static Map<Integer, ValuedRangeResult> getRatesWithThreshold(final Map<Integer, Integer> values,
                                                                         final Fraction threshold) {

        final int totalPixels = values.values().stream().mapToInt(Integer::intValue).sum();
        final Map<Integer, Double> rates = calculateRates(values, totalPixels);
        final Map<Integer, Double> sorted = sortAndFilterRates(rates, threshold);
        final Map<Integer, ValuedRangeResult> fractions = new LinkedHashMap<>(sorted.size());
        sorted.forEach((key, value) -> fractions.put(key, new ValuedRangeResult(fr(value))));
        return fractions;
    }

    /**
     * Sorts and filters a map of rates based on a provided threshold fraction.
     *
     * @param rates     a map containing the rates with integer keys and double values
     * @param threshold a fraction representing the minimum threshold for rate values to be included
     * @return a new LinkedHashMap with sorted and filtered rates where values are greater than or equal to the threshold
     */
    private static Map<Integer, Double> sortAndFilterRates(final Map<Integer, Double> rates, final Fraction threshold) {

        final Fraction t = (isNull(threshold)) ? fr(1.0) : threshold;
        return rates.entrySet().stream()
                .filter(e -> e.getValue() >= t.doubleValue())
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    @Override
    public final Map<Fraction, ValuedRangeResult> getBrightnessesByRates(final _FractionQuotas brightnesses) {

        final int q = isNull(brightnesses) ? i(fences) : brightnesses.fences();
        final Fraction f = isNull(brightnesses) ? LOWER_LIMIT : brightnesses.threshold();
        final Map<Integer, ValuedRangeResult> raw = getRatesWithThreshold(calculator.countPixelsByBrightness(q), f);
        return getFractionActualFractionMap(q, raw);
    }

    public final Map<Integer, ValuedRangeResult> getColoursByRates() {

        return getRatesWithThreshold(calculator.countPixelsByColor(), Fraction.ZERO);
    }

    public final Map<Integer, ValuedRangeResult> getColoursByRates(final Fraction threshold) {

        return getRatesWithThreshold(calculator.countPixelsByColor(), threshold);
    }

    @SuppressWarnings("ContinueStatement")
    public final Map<Integer, ValuedRangeResult> getColoursByRates(final Fraction threshold, final IgnoreHSB ignoreHSB) {

        final Map<Integer, ValuedRangeResult> in = getRatesWithThreshold(calculator.countPixelsByColor(), threshold);
        final Map<Integer, ValuedRangeResult> out = new LinkedHashMap<>(0);
        for (final Map.Entry<Integer, ValuedRangeResult> entry : in.entrySet()) {
            final HSB colourHSB = HSB.convertRGBtoHSB(rgb24(entry.getKey()));
            if (!isNull(colourHSB)) {
                if (isNotNull(ignoreHSB.hue()) && ignoreHSB.hue().includes(colourHSB.hue())) continue;
                if (isNotNull(ignoreHSB.brightness()) && ignoreHSB.brightness().includes(colourHSB.brightness())) continue;
                if (isNotNull(ignoreHSB.saturation()) && ignoreHSB.saturation().includes(colourHSB.saturation())) continue;
            }
            out.put(entry.getKey(), entry.getValue());
        }
        return out;
    }

    @Override
    public final Map<Fraction, ValuedRangeResult> getHuesByRates(final _FractionQuotas hues) {

        final int q = isNull(hues) ? i(fences) : hues.fences();
        final Fraction f = isNull(hues) ? LOWER_LIMIT : hues.threshold();
        final Map<Integer, ValuedRangeResult> raw = getRatesWithThreshold(calculator.countPixelsByHue(q), f);
        return getFractionActualFractionMap(q, raw);
    }

    @Override
    public final Map<Fraction, ValuedRangeResult> getSaturationsByRates(final _FractionQuotas saturations) {

        final int q = isNull(saturations) ? i(fences) : saturations.fences();
        final Fraction f = isNull(saturations) ? LOWER_LIMIT : saturations.threshold();
        final Map<Integer, ValuedRangeResult> raw = getRatesWithThreshold(calculator.countPixelsBySaturation(q), f);
        return getFractionActualFractionMap(q, raw);
    }
}
