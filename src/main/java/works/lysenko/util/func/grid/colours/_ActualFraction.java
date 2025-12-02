package works.lysenko.util.func.grid.colours;

import org.apache.commons.math3.fraction.Fraction;
import works.lysenko.util.data.enums.RangeResult;

/**
 * The _ActualFraction interface defines the structure for classes that encapsulate a Fraction value along with a RangeResult.
 * This interface represents a fractional value that can be validated within a specific range.
 */
@SuppressWarnings("InterfaceWithOnlyOneDirectInheritor")
public interface _ActualFraction {

    /**
     * Retrieves the fractional value in double precision.
     *
     * @return the fractional value as a double.
     */
    double doubleValue();

    /**
     * Returns the result of the range validation.
     *
     * @return the RangeResult representing the outcome of the validation.
     */
    RangeResult result();

    /**
     * Sets the result of the range validation.
     *
     * @param result the RangeResult representing the outcome of the validation.
     */
    void result(RangeResult result);

    /**
     * Retrieves the fractional value encapsulated within the implementing class.
     *
     * @return the Fraction instance representing the fractional value.
     */
    Fraction value();
}
