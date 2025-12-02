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
 * Represents a quota object with a value, precision, and a range defined by minimum and maximum fractions.
 * The Quota class allows for validation, calculation, and conversion related to quota values.
 *
 * @param <T> The type of the value held by the quota object.
 */
@SuppressWarnings("CallToSuspiciousStringMethod")
public record Quota<T>(T value, T precision, Fraction min, Fraction max) implements _Quota<T> {

    /**
     * Represents the maximum share value.
     */
    public static final double MAX = 1.0;
    /**
     * Represents the minimum share value.
     */
    private static final double MIN = 0.0;

    /**
     * Initialises a Quota object with specified minimum and maximum fractions.
     * Validates that the provided minimum and maximum values are within the allowable range.
     *
     * @param min The minimum fraction value. It must be within the range specified by MIN and MAX.
     * @param max The maximum fraction value. It must be within the range specified by MIN and MAX.
     * @throws IllegalArgumentException If the minimum or maximum value is outside the allowable range.
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
     * Creates a Quota object of type Fraction using the provided map entry and precision.
     *
     * @param value     A map entry consisting of a key of type Fraction and a value of type ActualFraction.
     *                  The key represents the quota's identifier, and the value contains the associated fractional value.
     * @param precision The precision fraction to be used in the Quota object, determining the level of accuracy for
     *                  calculations.
     * @return A Quota object of type Fraction initialized with the specified key, precision, and fraction values derived
     * from the input map entry.
     */
    public static Quota<Fraction> shareOfFraction(final Map.Entry<? extends Fraction, ? extends ActualFraction> value,
                                                  final Fraction precision) {

        final Fraction exactShare = value.getValue().value();
        return new Quota<>(value.getKey(), precision, exactShare, exactShare);
    }

    /**
     * Creates a Quota object of type Integer using the specified value, precision, and exact share.
     *
     * @param value      The integer value for the Quota object.
     * @param precision  The precision level represented as an integer, which determines the level of granularity for the Quota.
     * @param exactShare The exact fractional share represented by a Fraction object.
     * @return A Quota object of type Integer initialised with the specified value, precision, and exact share.
     */
    public static Quota<Integer> shareOfInteger(final int value, final Integer precision, final Fraction exactShare) {

        return new Quota<>(value, precision, exactShare, exactShare);
    }

    /**
     * Creates a Quota object of type Integer using the given value, precision, and share.
     *
     * @param value     The integer value for the Quota object.
     * @param precision The precision level represented as an integer, determining the level of granularity for the Quota.
     * @param share     An instance of _ActualFraction that represents the share as a Fraction encapsulated within it.
     * @return A Quota object of type Integer initialised with the specified value, precision, and share.
     */
    public static Quota<Integer> shareOfInteger(final int value, final Integer precision, final _ActualFraction share) {

        final Fraction exactShare = share.value();
        return new Quota<>(value, precision, exactShare, exactShare);
    }

    /**
     * Creates a Quota object of type Integer using a map entry and precision.
     * The map entry consists of an integer key and a value of type ActualFraction.
     * The precision determines the level of granularity for the Quota.
     *
     * @param value     A map entry where the key is an integer representing the identifier for the quota,
     *                  and the value is an ActualFraction that contains the fractional share.
     * @param precision An integer specifying the precision level for calculations, which dictates the
     *                  granularity of the resulting Quota.
     * @return A Quota object of type Integer initialised with the specified key, precision, and fractional share.
     */
    public static Quota<Integer> shareOfInteger(final Map.Entry<Integer, ? extends ActualFraction> value, final int precision) {

        final Fraction exactShare = value.getValue().value();
        return new Quota<>(value.getKey(), precision, exactShare,exactShare);
    }

    /**
     * Creates a Quota object of type Integer using the specified value, precision, minimum fraction, and maximum fraction.
     *
     * @param value     The integer value for the Quota object.
     * @param precision The precision level represented as an integer, determining the level of granularity for the Quota.
     * @param min       The minimum fractional value for the quota, represented as a Fraction object.
     * @param max       The maximum fractional value for the quota, represented as a Fraction object.
     * @return A Quota object of type Integer initialized with the specified value, precision, minimum, and maximum fractions.
     */
    public static Quota<Integer> shareOfInteger(final int value, final Integer precision, final Fraction min, final Fraction max) {

        return new Quota<>(value, precision, min, max);
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