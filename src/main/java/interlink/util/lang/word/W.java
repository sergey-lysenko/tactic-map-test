package interlink.util.lang.word;

import static works.lysenko.util.chrs.__.AT;
import static works.lysenko.util.chrs.__.HE;
import static works.lysenko.util.chrs.__.WE;
import static works.lysenko.util.data.strs.Swap.s;
import static works.lysenko.util.spec.Symbols.R;

@SuppressWarnings({"StaticMethodOnlyUsedInOneClass", "MissingJavadoc"})
public record W() {

    public static final String WEATHER = s(WE, AT, HE, R);
}
