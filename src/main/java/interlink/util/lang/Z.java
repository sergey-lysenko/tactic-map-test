package interlink.util.lang;

import static interlink.util.lang.word.Z.ZOOM;
import static works.lysenko.util.chrs.__.IN;
import static works.lysenko.util.chrs.___.OUT;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Case.c;

@SuppressWarnings({"StaticMethodOnlyUsedInOneClass", "MissingJavadoc"})
public record Z() {

    public static final String ZOOM_IN = b(c(ZOOM), c(IN));
    public static final String ZOOM_OUT = b(c(ZOOM), c(OUT));
}
