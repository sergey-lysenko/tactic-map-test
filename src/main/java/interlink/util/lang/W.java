package interlink.util.lang;

import static interlink.util.lang.word.E.EXPLANATION;
import static interlink.util.lang.word.P.PLACE;
import static interlink.util.lang.word.R.RECOMMENDATION;
import static interlink.util.lang.word.S.SETTINGS;
import static interlink.util.lang.word.W.WEATHER;
import static works.lysenko.util.chrs.__.BY;
import static works.lysenko.util.chrs._____.VALUE;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.lang.word.C.COORDINATES;
import static works.lysenko.util.lang.word.T.TITLE;
import static works.lysenko.util.lang.word.U.UPDATE;

@SuppressWarnings({"StaticMethodOnlyUsedInOneClass", "MissingJavadoc"})
public record W() {

    public static final String WEATHER_VALUE_BY_TITLE = b(c(WEATHER), c(VALUE), BY, c(TITLE));
    public static final String WEATHER_SETTINGS_VALUE_BY_TITLE = b(c(WEATHER), c(SETTINGS), c(VALUE), BY, c(TITLE));
    public static final String WEATHER_PLACE = b(c(WEATHER), c(PLACE));
    public static final String WEATHER_COORDINATES = b(c(WEATHER), c(COORDINATES));
    public static final String WEATHER_UPDATE = b(c(WEATHER), c(UPDATE));
    public static final String WEATHER_RECOMMENDATION = b(c(WEATHER), c(c(RECOMMENDATION)));
    public static final String WEATHER_EXPLANATION = b(c(WEATHER), c(c(EXPLANATION)));
}
