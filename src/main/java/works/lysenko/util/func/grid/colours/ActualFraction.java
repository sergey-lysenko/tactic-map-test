package works.lysenko.util.func.grid.colours;

import org.apache.commons.math3.fraction.Fraction;
import works.lysenko.util.data.enums.RangeResult;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static works.lysenko.util.data.enums.Ansi.gb;
import static works.lysenko.util.data.enums.Ansi.rb;
import static works.lysenko.util.data.strs.Swap.s;
import static works.lysenko.util.func.type.fractions.Render.ts;
import static works.lysenko.util.prop.data.Delimeters.L0;

/**
 * The ActualFraction class encapsulates a Fraction value along with a RangeResult.
 * This class is an implementation of the _ActualFraction interface, representing a fractional value that can be validated
 * within a range.
 */
public class ActualFraction implements _ActualFraction {

    private final Fraction value;
    private RangeResult result = null;

    /**
     * Constructs an ActualFraction instance with the specified Fraction value.
     *
     * @param value the Fraction value to be assigned to this ActualFraction instance
     */
    public ActualFraction(final Fraction value) {

        this.value = value;
    }

    @Override
    public final double doubleValue() {

        return value.doubleValue();
    }

    @Override
    public final RangeResult result() {

        return result;
    }

    @Override
    public final void result(final RangeResult result) {

        this.result = result;
    }

    @SuppressWarnings("NestedConditionalExpression")
    @Override
    public final String toString() {

        return s(ts(true, value), isNull(result) ?
                EMPTY : result.isPassed() ? s(L0, gb(result.render())) : s(L0, rb(result.render())));
    }

    @Override
    public final Fraction value() {

        return value;
    }
}
