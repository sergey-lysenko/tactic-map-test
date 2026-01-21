package interlink.util.lang.word;

import static works.lysenko.util.chrs.__.*;
import static works.lysenko.util.chrs.___.LER;
import static works.lysenko.util.chrs.____.TION;
import static works.lysenko.util.data.strs.Swap.s;

@SuppressWarnings({"StaticMethodOnlyUsedInOneClass", "MissingJavadoc"})
public record R() {

    public static final String RULER = s(RU, LER);
    public static final String RECOMMENDATION = s(RE, CO, MM, EN, DA, TION);
}
