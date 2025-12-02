package interlink.util.lang;

import static interlink.util.chrs.__.MY;
import static works.lysenko.util.chrs.____.FIND;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.lang.word.L.LOCATION;

@SuppressWarnings({"StaticMethodOnlyUsedInOneClass", "MissingJavadoc"})
public record F() {

    public static final String FIND_MY_LOCATION = b(c(FIND), c(MY), c(LOCATION));
}
