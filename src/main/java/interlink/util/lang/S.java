package interlink.util.lang;

import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.data.strs.Swap.s;
import static works.lysenko.util.lang.word.S.SEARCH;
import static works.lysenko.util.spec.Symbols._1_;
import static works.lysenko.util.spec.Symbols._2_;

@SuppressWarnings({"MissingJavadoc", "StaticMethodOnlyUsedInOneClass"})
public record S() {

    public static final String SEARCH_1 = b(c(SEARCH), s(_1_));
    public static final String SEARCH_2 = b(c(SEARCH), s(_2_));
}
