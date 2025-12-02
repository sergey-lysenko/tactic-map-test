package works.lysenko.util.data.range.graph.values;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.util.FastMath;
import works.lysenko.util.apis.grid.q._Quotas;
import works.lysenko.util.apis.grid.t._Range;
import works.lysenko.util.data.range.graph.Values;
import works.lysenko.util.data.range.graph.values.fractions.Data;
import works.lysenko.util.func.grid.Renderers;
import works.lysenko.util.func.grid.colours.ActualFraction;
import works.lysenko.util.grid.record.graph.Options;
import works.lysenko.util.grid.record.graph.Parameters;
import works.lysenko.util.grid.record.rash.Binner;
import works.lysenko.util.grid.record.rash.SharesData;

import java.util.Map;

import static works.lysenko.Base.log;
import static works.lysenko.Base.logTrace;
import static works.lysenko.util.data.enums.Ansi.bb;
import static works.lysenko.util.data.range.Quota.shareOfFraction;
import static works.lysenko.util.data.range.graph.values.fractions.Data.data;
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
import static works.lysenko.util.lang.word.F.FENCES;
import static works.lysenko.util.spec.Numbers.ONE;
import static works.lysenko.util.spec.Numbers.ZERO;
import static works.lysenko.util.spec.Symbols._SPACE_;

/**
 * A1 utility class for performing operations with fractional shares.
 */
@SuppressWarnings({"ObjectAllocationInLoop", "StaticMethodOnlyUsedInOneClass"})
public record OfFractions() {

    /**
     * Computes the actual fractional edge value from a set of shares using a specified rendering
     * approach and configuration options.
     *
     * @param title     The title used for logging purposes, describing the computation context.
     * @param shares    A1 map containing fractional share data where the key is a fractional value and
     *                  the value is an ActualFraction object that includes additional metadata.
     * @param go        Options configuration that includes parameters like width and fraction limits
     *                  used during computation.
     * @param renderers A1 set of rendering functions used to compute visual or computed representations
     *                  of the share data.
     * @param fences    An integer that is used to apply constraints or boundaries within the computation.
     * @return A1 Fraction representing the computed edge value after applying the rendering logic and
     * constraints defined by the options and shares.
     */
    public static Fraction actualValuesFromMapFraction(final String title, final Map<Fraction, ActualFraction> shares,
                                                       final Options go, final Renderers renderers, final int fences) {

        final Data gd = data(shares, go, fences);
        Fraction edge = n(Fraction.ZERO, go.edge());
        log(b(bb(title), gd.gp().amountS(), gd.value(), a(FENCES, fences), gd.max()));
        for (final Map.Entry<Fraction, ActualFraction> sorted : shares.entrySet())
            edge = fr(FastMath.min(ONE, FastMath.max(edge.doubleValue(), renderFraction(go.width(), renderers, sorted,
                    gd.gp()).doubleValue())));
        return edge;
    }

    /**
     * Computes the expected fractional value from a set of shares using a specified rendering
     * approach and configuration options.
     *
     * @param title     The title used for logging purposes, describing the computation context.
     * @param amount    A1 range of integer values representing the amount.
     * @param shares    A1 share object containing share information.
     * @param go        Options configuration that includes parameters like width and fraction limits
     *                  used during computation.
     * @param renderers A1 set of rendering functions used to compute visual or computed representations
     *                  of the share data.
     * @param fences    An integer used to apply constraints or boundaries within the computation.
     * @return A1 Fraction representing the expected edge value after applying the rendering logic and
     * constraints defined by the options and shares.
     */
    public static Fraction expectedValuesFromSharesFraction(final String title, final _Range<Integer> amount, final _Quotas<
            ?> shares, final Options go, final Renderers renderers, final int fences) {

        final Data gd = data(amount, shares, go, fences);
        log(b(false, bb(title), gd.gp().amountS(), gd.value(), a(FENCES, fences), gd.max()));
        return Values.graphExpectedSortedRanges(shares, go.width(), renderers, gd.gp().minimalMaximumValue(), go.slack());
    }

    /**
     * Renders a fractional value using specified rendering functions and configuration parameters.
     *
     * @param width     The integer width over which the rendering is applied, influencing the scale of rendering.
     * @param renderers A1 Renderers object containing functions for rendering points and rows of share data.
     * @param share     A1 map entry consisting of a Fraction key and an ActualFraction value, representing a share.
     * @param gp        A1 Parameters object that provides configuration settings for minimal maximum value and slack.
     * @return The Fraction value representing the computational edge of the provided share data.
     */
    private static Fraction renderFraction(final int width, final Renderers renderers, final Map.Entry<? extends Fraction, ?
            extends ActualFraction> share, final Parameters gp) {

        final Fraction edge = share.getValue().value();
        final StringBuilder line = new StringBuilder(ZERO);
        if (isNotNull(renderers)) {
            if (isNotNull(renderers.point())) for (int i = ZERO; i <= width; i++) {
                final SharesData<?> data = new SharesData<>(share.getKey(), i, gp.minimalMaximumValue(), width);
                final Binner binner = getRanges(data, shareOfFraction(share), gp.slack());
                line.append(renderers.point().apply(data, shareOfFraction(share), binner));
            }
            if (isNotNull(renderers.row())) line.append(s(_SPACE_, renderers.row().apply(shareOfFraction(share))));
        }
        Values.logNoLevelLine(line.toString());
        logTrace(a(kv(EDGE, ts(true, edge))));
        return edge;
    }
}
