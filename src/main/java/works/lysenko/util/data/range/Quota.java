package works.lysenko.util.data.range;

import org.apache.commons.math3.fraction.Fraction;
import works.lysenko.util.apis.grid.q._Quota;
import works.lysenko.util.apis.grid.t._Value;
import works.lysenko.util.func.grid.colours.ActualFraction;
import works.lysenko.util.func.grid.colours._ActualFraction;

import java.util.Map;

import static org.apache.commons.math3.util.FastMath.abs;
import static works.lysenko.util.chrs.__.IN;
import static works.lysenko.util.chrs.__.IS;
import static works.lysenko.util.chrs.___.DOTS;
import static works.lysenko.util.chrs.___.NOT;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.data.strs.Swap.s;
import static works.lysenko.util.data.strs.Swap.v;
import static works.lysenko.util.func.data.Percents.percentString;
import static works.lysenko.util.func.type.fractions.Factory.fr;
import static works.lysenko.util.func.type.fractions.Render.ts;
import static works.lysenko.util.lang.word.F.FRACTION;
import static works.lysenko.util.lang.word.M.MAXIMUM;
import static works.lysenko.util.lang.word.M.MINIMUM;
import static works.lysenko.util.lang.word.R.RANGE;
import static works.lysenko.util.prop.data.Delimeters.L0;
import static works.lysenko.util.spec.Numbers.ZERO;

/**
 * Represents a share of a value within a range defined by minimum and maximum fractions.
 *
 * @param <T> The type of the value being shared.
 */
@SuppressWarnings("CallToSuspiciousStringMethod")
public record Quota<T>(T value, Fraction min, Fraction max) implements _Quota<T> {

    /**
     * Represents the maximum share value.
     */
    public static final double MAX = 1.0;
    /**
     * Represents the minimum share value.
     */
    private static final double MIN = 0.0;

    /**
     * Checks if the given minimum and maximum fractions are within the valid range.
     * If either of the fractions is outside the range, an IllegalArgumentException is thrown.
     *
     * @param min   The minimum fraction.
     * @param max   The maximum fraction.
     * @param value to store
     * @throws IllegalArgumentException If either the minimum or maximum fraction is outside the valid range.
     */
    public Quota {

        if (MIN > min.doubleValue() || MAX < min.doubleValue()) {
            throw new IllegalArgumentException(b(c(MINIMUM), FRACTION, ts(min), IS, NOT, IN, s(MIN), DOTS, s(MAX), RANGE));
        }
        if (MIN > max.doubleValue() || MAX < max.doubleValue()) {
            throw new IllegalArgumentException(b(c(MAXIMUM), FRACTION, ts(min), IS, NOT, IN, s(MIN), DOTS, s(MAX), RANGE));
        }
    }

    /**
     * Calculates the median value of the given Quota object by averaging the minimum and maximum fractions.
     *
     * @param value The Quota object to calculate the median value for.
     * @return The median value as a double.
     */
    @SuppressWarnings("StaticMethodOnlyUsedInOneClass")
    static double median(final Quota<?> value) {

        return (value.min().doubleValue() + value.max().doubleValue()) / 2;
    }

    /**
     * Calculates the share of a fraction based on the provided entry of fractions.
     *
     * @param value The Map entry containing two fractions representing the numerator and denominator.
     * @return A1 Quota object with the specified fractions as numerator and denominator.
     */
    public static Quota<Fraction> shareOfFraction(final Map.Entry<? extends Fraction, ? extends ActualFraction> value) {

        return new Quota<>(value.getKey(), value.getValue().value(), value.getValue().value());
    }

    /**
     * Creates and returns a ShareOfIntValue object with the specified value and share.
     *
     * @param value The color value.
     * @param share The fraction representing the share.
     * @return A1 ShareOfIntValue object.
     */
    public static Quota<Integer> shareOfInteger(final int value, final Fraction share) {

        return new Quota<>(value, share, share);
    }

    /**
     * Creates a Quota object of type Integer initialized with the specified value and fraction.
     *
     * @param value The integer value.
     * @param share The _ActualFraction object representing the share.
     * @return A1 Quota object with the specified value and share.
     */
    public static Quota<Integer> shareOfInteger(final int value, final _ActualFraction share) {

        return new Quota<>(value, share.value(), share.value());
    }

    /**
     * Calculates and returns a Quota object of type Integer based on the provided key and value.
     *
     * @param value The entry representing the key and value pair to create the Quota object.
     * @return A1 Quota object of type Integer with the specified key and value.
     */
    public static Quota<Integer> shareOfInteger(final Map.Entry<Integer, ? extends ActualFraction> value) {

        return new Quota<>(value.getKey(), value.getValue().value(), value.getValue().value());
    }

    /**
     * Creates and returns ranged ShareOfIntValue.
     *
     * @param value The color value.
     * @param min   The minimum fraction.
     * @param max   The maximum fraction.
     * @return An instance of ExpectedIntShareRange.
     */
    public static Quota<Integer> shareOfInteger(final int value, final Fraction min, final Fraction max) {

        return new Quota<>(value, min, max);
    }

    @SuppressWarnings({"IfStatementWithTooManyBranches", "MethodWithMultipleReturnPoints"})
    public Fraction actualAbsoluteMargin(final Fraction actualValue) {

        if ((actualValue.doubleValue() >= min.doubleValue()) && (actualValue.doubleValue() <= max.doubleValue()))
            return fr(ZERO);
        else if (actualValue.doubleValue() > max.doubleValue()) return fr(abs(actualValue.doubleValue() - max.doubleValue()));
        else if (actualValue.doubleValue() < min.doubleValue()) return fr(abs(actualValue.doubleValue() - min.doubleValue()));
        else return null;
    }

    public double median() {

        return (min().doubleValue() + max().doubleValue()) / 2;
    }

    @Override
    public String percentage() {

        return percentString(width(), MAX - MIN);
    }

    public String render() {

        return toString();
    }

    @SuppressWarnings("unchecked")
    @Override
    public _Value<T> share() {

        return (_Value<T>) v(new FractionRange(min, max));
    }

    @Override
    public String toString() {

        final String range = (ts(min).equals(ts(max))) ? ts(min) : b(L0, ts(min), ts(max));
        return b(L0, s(value), range);
    }

    @Override
    public double width() {

        return max.doubleValue() - min.doubleValue();
    }
}