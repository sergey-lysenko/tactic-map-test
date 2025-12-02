package interlink.util.lang;

import static interlink.util.lang.word.H.HOLDER;
import static works.lysenko.util.chrs.____.VIEW;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Case.c;

@SuppressWarnings({"StaticMethodOnlyUsedInOneClass", "MissingJavadoc"})
public record V() {

    public static final String VIEW_HOLDER = b(c(VIEW), c(HOLDER));
}
