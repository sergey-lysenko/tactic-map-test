package interlink.util.lang.word;

import static works.lysenko.util.chrs.__.GO;
import static works.lysenko.util.chrs.__.IN;
import static works.lysenko.util.chrs.__.LO;
import static works.lysenko.util.chrs.___.LOG;
import static works.lysenko.util.data.strs.Swap.s;

@SuppressWarnings({"StaticMethodOnlyUsedInOneClass", "MissingJavadoc"})
public record L() {

    public static final String LOGIN = s(LOG, IN);
    public static final String LOGO = s(LO, GO);
}
