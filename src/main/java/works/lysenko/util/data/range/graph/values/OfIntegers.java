package works.lysenko.util.data.range.graph.values;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.util.FastMath;
import works.lysenko.util.apis.grid.q._Quotas;
import works.lysenko.util.apis.grid.t._Range;
import works.lysenko.util.data.range.graph.Values;
import works.lysenko.util.data.range.graph.values.integers.Data;
import works.lysenko.util.func.grid.Renderers;
import works.lysenko.util.func.grid.colours.ValuedRangeResult;
import works.lysenko.util.grid.record.graph.Options;
import works.lysenko.util.grid.record.graph.Parameters;
import works.lysenko.util.grid.record.rash.Binner;
import works.lysenko.util.grid.record.rash.SharesData;

import java.util.Map;

import static works.lysenko.Base.log;
import static works.lysenko.Base.logTrace;
import static works.lysenko.util.data.enums.Ansi.bb;
import static works.lysenko.util.data.range.Quota.shareOfInteger;
import static works.lysenko.util.data.range.graph.values.integers.Data.data;
import static works.lysenko.util.data.records.KeyValue.kv;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Null.n;
import static works.lysenko.util.data.strs.Swap.s;
import static works.lysenko.util.data.strs.Vars.a;
import static works.lysenko.util.func.type.Objects.isNotNull;
import static works.lysenko.util.func.type.fractions.Factory.fr;
import static works.lysenko.util.func.type.fractions.Render.ts;
import static works.lysenko.util.grid.record.rash.Binner.getRanges;
import static works.lysenko.util.lang.word.E.EDGE;
import static works.lysenko.util.spec.Numbers.ONE;
import static works.lysenko.util.spec.Numbers.ZERO;
import static works.lysenko.util.spec.Symbols._SPACE_;

/**
 * Represents a collection of static methods for processing and rendering integer-based share data.
 */
@SuppressWarnings({"ObjectAllocationInLoop", "StaticMethodOnlyUsedInOneClass"})
public record OfIntegers() {

    /**
     * Computes the actual values from a map of integer keys and corresponding ValuedRangeResult values,
     * logs the relevant computation details, and returns the result as a Fraction object. The result represents
     * a computed edge value based on the shares and rendering options provided.
     *
     * @param title     The title used for logging the process of computing actual values from the shares.
     * @param shares    A1 map where keys are integers representing share amounts, and values are ValuedRangeResult objects
     *                  representing the corresponding shares.
     * @param go        An Options object providing configuration related to graph dimensions and other settings.
     * @param renderers A1 Renderers instance used to apply rendering functions to the shares data.
     * @return A1 Fraction object representing the computed actual value, constrained by the provided rendering options and
     * shares.
     */
    public static Fraction actualValuesFromMapInteger(final String title, final Map<Integer, ValuedRangeResult> shares,
                                                      final Options go, final Renderers renderers) {

        final Data gd = data(shares, go);
        Fraction edge = n(Fraction.ZERO, go.edge());
        log(b(bb(title), gd.graphParameters().amountS(), gd.value(), gd.max()));
        for (final Map.Entry<Integer, ValuedRangeResult> share : shares.entrySet())
            edge = fr(FastMath.min(ONE, FastMath.max(edge.doubleValue(), renderInteger(go.width(), renderers, share,
                    gd.graphParameters()).doubleValue())));
        return edge;
    }

    /**
     * Computes the expected values from integer-based shares data, logs the processing details, and
     * returns the result as a Fraction object, which represents some aspect of the processed data.
     *
     * @param title     The title used for logging the process of computing expected values from shares.
     * @param amount    An instance of _Range<Integer> representing the range of amounts to consider in the computation.
     * @param shares    An instance of _Quotas<?> representing the shares data to be evaluated.
     * @param go        An instance of Options providing configuration related to graph dimensions and computation settings.
     * @param renderers An instance of Renderers used to apply rendering functions to the shares data.
     * @return A1 Fraction object representing the computed expected values from the provided shares data.
     */
    public static Fraction expectedValuesFromSharesInteger(final String title, final _Range<Integer> amount,
                                                           final _Quotas<?> shares, final Options go,
                                                           final Renderers renderers) {

        final Data gd = data(amount, shares, go);
        log(b(false, bb(title), gd.graphParameters().amountS(), gd.value(), s(go.slack()), gd.max()));
        return Values.graphExpectedSortedRanges(shares, go.width(), renderers, gd.graphParameters().minimalMaximumValue(), go.slack());
    }

    /**
     * Renders an integer value based on the provided width, renderers, share entry, and parameters.
     * This method constructs a string representation of the share data using the rendering functions
     * from the provided renderers and logs the output. Additionally, it computes and returns a Fraction
     * value representing the edge of the share value.
     *
     * @param width     The width parameter used in rendering the integer share data.
     * @param renderers An instance of Renderers containing functions for rendering point and row data.
     * @param share     A1 Map.Entry where the key is an integer and the value is an ValuedRangeResult, representing
     *                  a share and its corresponding fractional value.
     * @param gp        A1 Parameters instance providing configuration such as minimal maximum value and slack,
     *                  used during share data evaluation and rendering.
     * @return A1 Fraction representing the computed edge value derived from the shared integer value.
     */
    private static Fraction renderInteger(final int width, final Renderers renderers, final Map.Entry<Integer, ?
            extends ValuedRangeResult> share, final Parameters gp) {

        final Fraction edge = share.getValue().value();
        final StringBuilder line = new StringBuilder(ZERO);
        if (isNotNull(renderers)) {
            if (isNotNull(renderers.point())) for (int i = ZERO; i <= width; i++) {
                final SharesData<?> data = new SharesData<>(share.getKey(), i, gp.minimalMaximumValue(), width);
                final Binner binner = getRanges(data, shareOfInteger(share, 0), gp.slack()); // TODO: precision
                line.append(renderers.point().apply(new SharesData<>(share.getKey(), i, gp.minimalMaximumValue(), width),
                        shareOfInteger(share, 0), binner));
            }
            if (isNotNull(renderers.row())) line.append(s(_SPACE_, renderers.row().apply(shareOfInteger(share, 0))));
        }
        Values.logNoLevelLine(line.toString());
        logTrace(a(kv(EDGE, ts(true, edge))));
        return edge;
    }
}
