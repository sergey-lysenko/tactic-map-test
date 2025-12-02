package interlink.util.lang;

import static interlink.util.lang.word.D.DRAG;
import static interlink.util.lang.word.H.HANDLE;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Case.c;

@SuppressWarnings({"StaticMethodOnlyUsedInOneClass", "MissingJavadoc"})
public record D() {

    public static final String DRAG_HANDLE = b(c(DRAG), c(HANDLE));
}
