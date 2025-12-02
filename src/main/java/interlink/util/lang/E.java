package interlink.util.lang;

import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.lang.word.E.ELEVATION;
import static works.lysenko.util.lang.word.G.GRAPH;

@SuppressWarnings({"MissingJavadoc", "StaticMethodOnlyUsedInOneClass"})
public record E() {

    public static final String ELEVATION_GRAPH = b(c(ELEVATION), c(GRAPH));
}
