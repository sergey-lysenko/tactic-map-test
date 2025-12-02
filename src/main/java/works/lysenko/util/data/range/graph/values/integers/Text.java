package works.lysenko.util.data.range.graph.values.integers;

import org.apache.commons.lang3.StringUtils;
import works.lysenko.util.apis.grid.q._Quotas;
import works.lysenko.util.data.enums.Brackets;
import works.lysenko.util.func.grid.colours.ValuedRangeResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static works.lysenko.util.chrs.___.MAX;
import static works.lysenko.util.data.enums.Ansi.rb;
import static works.lysenko.util.data.records.KeyValue.kv;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Swap.s;
import static works.lysenko.util.data.strs.Vars.a;
import static works.lysenko.util.data.strs.Wrap.e;
import static works.lysenko.util.func.type.fractions.Factory.fr;
import static works.lysenko.util.func.type.fractions.Render.ts;
import static works.lysenko.util.lang.C.COMMA_SPACE;
import static works.lysenko.util.prop.data.Delimeters.L0;
import static works.lysenko.util.spec.Numbers.ZERO;

/**
 * The Text record holds two string values: value and max.
 */
public record Text(String value, String max) {

    private static String getPropertyValueInteger(final Map<Integer, ValuedRangeResult> shares) {

        final Collection<String> result = new ArrayList<>(ZERO);
        for (final Map.Entry<Integer, ValuedRangeResult> value : shares.entrySet())
            result.add(b(L0, s(value.getKey()), ts(value.getValue().value())));
        return (StringUtils.join(result, COMMA_SPACE));
    }

    static Text text(final _Quotas<?> shares, final boolean overflow, final double max) {

        final String value = e(Brackets.CURLY, shares.getPropertyValue());
        final String maxS = rb(overflow, a(kv(s(MAX), s(ts(fr(max)), L0, max))));
        return new Text(value, maxS);
    }

    static Text text(final Map<Integer, ValuedRangeResult> shares, final boolean overflow, final double max) {

        final String value = e(Brackets.CURLY, getPropertyValueInteger(shares));
        final String maxS = rb(overflow, a(kv(s(MAX), s(ts(fr(max)), L0, max))));
        return new Text(value, maxS);
    }

}
