package works.lysenko.util.data.range.graph.values.integers;

import works.lysenko.util.apis.grid.q._Quotas;
import works.lysenko.util.apis.grid.t._Range;
import works.lysenko.util.data.range.graph.values.FromMap;
import works.lysenko.util.data.range.graph.values.FromShares;
import works.lysenko.util.func.grid.colours.ValuedRangeResult;
import works.lysenko.util.grid.record.graph.Options;
import works.lysenko.util.grid.record.graph.Parameters;

import java.util.Map;

import static works.lysenko.util.data.range.graph.values.integers.Limit.limit;
import static works.lysenko.util.data.range.graph.values.integers.Text.text;
import static works.lysenko.util.func.type.fractions.Factory.fr;

/**
 * The DataStorage record encapsulates the graph parameters, value, and max value retrieved from given inputs.
 *
 * @param graphParameters The graph parameters.
 * @param value           A1 string representing the value.
 * @param max             A1 string representing the maximum value.
 */
public record Data(Parameters graphParameters, String value, String max) {

    /**
     * Creates a DataStorage object based on the given amount range, shares, and graph options.
     *
     * @param amount the range of integer values representing the amount
     * @param shares the shares information required to generate graph parameters and text elements
     * @param go     the options used for configuring the graph
     * @return a new DataStorage object containing the generated graph parameters and text elements
     */
    public static Data data(final _Range<Integer> amount, final _Quotas<?> shares, final Options go) {

        final Limit li = limit(go);
        final Parameters gp = new FromShares(amount, shares, fr(li.max())).getGraphParameters(go.slack());
        final Text text = text(shares, li.overflow(), li.max());
        return new Data(gp, text.value(), text.max());
    }

    /**
     * Creates a DataStorage object based on the provided shares and graph options.
     *
     * @param shares a map where the key is an integer representing the share amount, and the value is a Fraction
     *               representing the share percentage
     * @param go     the options used for configuring the graph
     * @return a new DataStorage object containing the generated graph parameters and text elements
     */
    public static Data data(final Map<Integer, ValuedRangeResult> shares, final Options go) {

        final Limit li = limit(go);
        final Parameters gp = new FromMap(shares, fr(li.max())).getGraphParameters(go.slack());
        final Text text = text(shares, li.overflow(), li.max());
        return new Data(gp, text.value(), text.max());
    }
}
