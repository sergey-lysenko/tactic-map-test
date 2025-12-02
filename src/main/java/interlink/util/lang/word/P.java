package interlink.util.lang.word;

import static works.lysenko.util.chrs.__.LY;
import static works.lysenko.util.chrs.__.ON;
import static works.lysenko.util.chrs.__.PO;
import static works.lysenko.util.data.strs.Swap.s;
import static works.lysenko.util.spec.Symbols.G;

@SuppressWarnings({"StaticMethodOnlyUsedInOneClass", "MissingJavadoc"})
public record P() {

    public static final String POLYGON = s(PO, LY, G, ON);
}
