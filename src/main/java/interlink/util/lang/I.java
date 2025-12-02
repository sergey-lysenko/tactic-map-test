package interlink.util.lang;

import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.lang.word.F.FAILED;
import static works.lysenko.util.lang.word.I.IMAGE;
import static works.lysenko.util.lang.word.V.VERIFICATION;

@SuppressWarnings("MissingJavadoc")
public record I() {

    public static final String IMAGE_VERIFICATION_FAILED = b(c(IMAGE), VERIFICATION, FAILED);
}
