package works.lysenko.util.prop.grid;

import static works.lysenko.util.spec.PropEnum.*;

@SuppressWarnings({"StaticMethodOnlyUsedInOneClass", "MissingJavadoc"})
public record Verify() {

    public static final boolean colours = _VERIFY_COLOURS.get();
    public static final boolean stamps = _STAMPS_PROCESS.get();
}
