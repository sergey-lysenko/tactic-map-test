package interlink.util.lang;

import static interlink.util.lang.word.T.TOTAL;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.lang.word.D.DISTANCE;

@SuppressWarnings({"StaticMethodOnlyUsedInOneClass", "MissingJavadoc"})
public record T() {

    public static final String TOTAL_DISTANCE = b(c(TOTAL), c(DISTANCE));
}
