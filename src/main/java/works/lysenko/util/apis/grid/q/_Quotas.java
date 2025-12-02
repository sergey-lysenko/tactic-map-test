package works.lysenko.util.apis.grid.q;

import org.apache.commons.math3.fraction.Fraction;
import works.lysenko.util.data.records.Slack;
import works.lysenko.util.func.grid.Renderers;

import java.util.List;

/**
 * Represents a generic interface for managing shares of a certain datatype.
 * Primary operations include retrieving, setting, and organizing 'Quota' objects.
 *
 * @param <T> The type of object associated with the shares.
 */
@SuppressWarnings("InterfaceWithOnlyOneDirectInheritor")
public interface _Quotas<T> {

    /**
     * Retrieves a list of Quota objects.
     *
     * @return A1 list of Quota objects.
     */
    List<_Quota<?>> get();

    /**
     * Retrieves a Quota object by the specified key.
     *
     * @param key The key used to retrieve the Quota object.
     * @return A1 Quota object corresponding to the given key.
     */
    _Quota<T> getByKey(Integer key);

    /**
     * Retrieves the property value.
     *
     * @return A1 string representing the property value.
     */
    String getPropertyValue();

    /**
     * Retrieves the property value associated with the specified number of fences.
     *
     * @param fences An integer representing the number of fences to be used in the operation.
     * @return A1 string representing the property value associated with the given number of fences.
     */
    String getPropertyValue(int fences);

    /**
     * Retrieves a list of sorted Quota objects.
     * The sorting criteria and behavior depend on the implementation.
     *
     * @param silent A boolean flag indicating whether sorting should be performed silently
     *               without additional operations or whether certain side-effects might occur.
     * @return A list of sorted Quota objects of the specified generic type T.
     */
    List<_Quota<T>> getSorted(boolean silent);

    /**
     * Logs information about a rendering process based on the provided parameters.
     *
     * @param width     The width parameter that might influence the rendering output.
     * @param renderers An instance of Renderers providing various rendering functions.
     * @return A1 Fraction object representing a calculated value related to the logging process.
     */
    Fraction logExpected(int width, Renderers renderers);

    /**
     * Sets the list of Share objects representing share values.
     *
     * @param quotas A1 list of Share objects representing share values to be set.
     */
    void setQuotas(List<_Quota<T>> quotas);

    /**
     * Retrieves the Slack object associated with the implementation.
     *
     * @return An instance of Slack representing a value with an allowed deviation and a border.
     */
    Slack slack();
}
