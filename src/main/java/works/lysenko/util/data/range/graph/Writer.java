package works.lysenko.util.data.range.graph;

import org.apache.commons.math3.fraction.Fraction;
import works.lysenko.util.apis.grid.q._Quotas;
import works.lysenko.util.data.range.IntegerRange;
import works.lysenko.util.data.range.graph.values.OfFractions;
import works.lysenko.util.data.range.graph.values.OfIntegers;
import works.lysenko.util.func.grid.Renderers;
import works.lysenko.util.func.grid.colours.ActualFraction;
import works.lysenko.util.grid.record.graph.Options;

import java.util.Map;

import static works.lysenko.Base.logEmptyLine;

/**
 * Represents a class for logging data points and data rows of a graph.
 */
@SuppressWarnings({"StaticMethodOnlyUsedInOneClass", "TypeMayBeWeakened"})
public record Writer() {

    /**
     * Creates a graph using the specified parameters by logging data points and rows, scaling the data, and calculating
     * statistics based on the provided share values, then returns a calculated edge Fraction.
     *
     * @param title     The title of the graph.
     * @param shares    A1 map of Fraction to ActualFraction, representing fractional share values.
     * @param go        An Options object containing parameters for graph configuration, including width and fractions.
     * @param renderers A1 Renderers object containing functions for rendering and data handling.
     * @param fences    An integer value used for quantization during rendering.
     * @return A1 Fraction representing the calculated edge of the graph.
     */
    public static Fraction graphActualFraction(final String title, final Map<Fraction, ActualFraction> shares,
                                               final Options go, final Renderers renderers, final int fences) {

        final Fraction edge = OfFractions.actualValuesFromMapFraction(title, shares, go, renderers, fences);
        Scale.scale(go, edge);
        Stats.stats(shares);
        logEmptyLine();
        return edge;
    }

    /**
     * Generates a graph by calculating actual fractional values from integer shares, scaling the data,
     * and calculating related statistics, ultimately returning the computed edge fraction.
     *
     * @param title     The title of the graph to be generated, used for identification purposes.
     * @param shares    A1 map where each key is an integer that represents a share, and each value is an ActualFraction
     *                  corresponding to that share, used for fractional value calculations in the graph.
     * @param go        An Options object that configures the graph's attributes, such as width and fractional values,
     *                  influencing the graph's representation.
     * @param renderers A1 Renderers object containing functions responsible for handling the data rendering,
     *                  which plays a role in how the graph data is visualized or logged.
     * @return A1 Fraction object representing the computed edge value of the graph, which is derived from the
     * calculations and scaling applied to the provided shares.
     */
    public static Fraction graphActualInteger(final String title, final Map<Integer, ActualFraction> shares,
                                              final Options go, final Renderers renderers) {

        final Fraction edge = OfIntegers.actualValuesFromMapInteger(title, shares, go, renderers);
        Scale.scale(go, edge);
        Stats.stats(shares);
        logEmptyLine();
        return edge;
    }

    /**
     * Creates and logs a graph representation using the specified parameters by computing
     * expected fractional values from shares, scaling the graph, and calculating statistics.
     *
     * @param title     The title of the graph to be generated.
     * @param amount    The integer range that defines the data scope in the graph.
     * @param shares    A1 collection representing fractional share values.
     * @param go        An Options object that configures various graph attributes.
     * @param renderers A1 Renderers object containing rendering functions for the graph.
     * @param fences    An integer that specifies the level of quantization for rendering.
     * @return A1 Fraction object representing the computed edge value of the graph.
     */
    public static Fraction graphExpectedFraction(final String title, final IntegerRange amount, final _Quotas<?
            extends Fraction> shares, final Options go, final Renderers renderers, final int fences) {

        final Fraction edge = OfFractions.expectedValuesFromSharesFraction(title, amount, shares, go, renderers, fences);
        Scale.scale(go, edge);
        Stats.stats(shares);
        logEmptyLine();
        return edge;
    }

    /**
     * Generates a graph representation using the provided parameters, which includes computing the expected
     * fractional values from integer shares, scaling the graph, and calculating statistics.
     *
     * @param title     The title of the graph to be generated.
     * @param amount    The integer range outlining the data scope for the graph.
     * @param shares    A1 collection representing integer share values.
     * @param go        An Options object that configures various graph attributes.
     * @param renderers A1 Renderers object containing rendering functions for the graph.
     * @return A1 Fraction object that represents the computed edge value of the graph.
     */
    public static Fraction graphExpectedInteger(final String title, final IntegerRange amount, final _Quotas<Integer> shares
            , final Options go, final Renderers renderers) {

        final Fraction edge = OfIntegers.expectedValuesFromSharesInteger(title, amount, shares, go, renderers);
        Scale.scale(go, edge);
        Stats.stats(shares);
        logEmptyLine();
        return edge;
    }
}
