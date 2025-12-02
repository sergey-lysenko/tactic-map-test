package interlink.util.lang;

import static interlink.util.lang.word.O.OBJECT;
import static works.lysenko.util.chrs.___.ADD;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Case.c;

@SuppressWarnings({"StaticMethodOnlyUsedInOneClass", "MissingJavadoc"})
public record A() {

    public static final String ADD_OBJECT = b(c(ADD), c(OBJECT));
}
