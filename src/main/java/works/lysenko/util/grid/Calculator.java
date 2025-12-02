package works.lysenko.util.grid;

import org.apache.commons.math3.fraction.Fraction;
import works.lysenko.util.apis.grid.g._GridCalculator;
import works.lysenko.util.data.records.Element;
import works.lysenko.util.data.type.Grid;
import works.lysenko.util.grid.record.rgbc.HSB;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.Objects.isNull;
import static works.lysenko.util.data.records.RGB24.rgb24;

/**
 * Represents a Calculator object that performs various calculations on a grid.
 */
@SuppressWarnings("MethodWithMultipleLoops")
public class Calculator implements _GridCalculator {

    private final Grid grid;

    /**
     * Constructs a Calculator object with the provided Grid.
     *
     * @param grid the grid to perform calculations on
     */
    public Calculator(final Grid grid) {

        this.grid = grid;
    }

    @Override
    public final HSB[][] countHSBgrid() {

        final int height = grid.getGrid().length;
        final int width = grid.getGrid()[0].length;
        final HSB[][] hsb = new HSB[height][width];

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                hsb[i][j] = HSB.convertRGBtoHSB(rgb24(isNull(grid.getGrid()[i][j]) ? null : grid.getGrid()[i][j].colour()));
        return hsb;
    }

    public final Map<Integer, Integer> countPixelsByBrightness(final int fences) {

        return countPixels(HSB::brightness, fences);
    }

    public final Map<Integer, Integer> countPixelsByColor() {

        final Map<Integer, Integer> colorCounts = new HashMap<>(0);
        for (final Element[] row : grid.getGrid())
            for (final Element pixel : row)
                if (null != pixel)
                    colorCounts.put(pixel.colour(), colorCounts.getOrDefault(pixel.colour(), 0) + 1);
        return colorCounts;
    }

    public final Map<Integer, Integer> countPixelsByHue(final int fences) {

        return countPixels(HSB::hue, fences);
    }

    public final Map<Integer, Integer> countPixelsBySaturation(final int fences) {

        return countPixels(HSB::saturation, fences);
    }

    /**
     * Counts the number of pixels based on a given property extracted from the HSB color representation.
     *
     * @param propertyExtractor a function that extracts a property from the HSB color representation
     * @param fences            the number of fences levels
     * @return a map containing the count of pixels for each quantized property value
     */
    @SuppressWarnings("MethodWithMultipleReturnPoints")
    private Map<Integer, Integer> countPixels(final Function<? super HSB, ? extends Fraction> propertyExtractor,
                                              final int fences) {

        if (isNull(propertyExtractor)) return null;
        final HSB[][] hsbGrid = countHSBgrid();
        final Map<Integer, Integer> counts = new HashMap<>(0);

        for (final HSB[] row : hsbGrid) {
            for (final HSB hsb : row) {
                if (null != hsb) {
                    final Fraction property = propertyExtractor.apply(hsb);
                    final int value = Math.round(property.floatValue() * fences);
                    counts.put(value, counts.getOrDefault(value, 0) + 1);
                }
            }
        }
        return counts;
    }
}
