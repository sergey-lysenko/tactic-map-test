package interlink.util.lang.word;

import static works.lysenko.util.chrs.__.TA;
import static works.lysenko.util.chrs.__.TO;
import static works.lysenko.util.data.strs.Swap.s;
import static works.lysenko.util.spec.Symbols.L;

@SuppressWarnings({"MissingJavadoc", "StaticMethodOnlyUsedInOneClass"})
public record T() {

    public static final String TOTAL = s(TO, TA, L);
}
