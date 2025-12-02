package interlink.util;

import static interlink.util.lang.A.ADD_OBJECT;
import static interlink.util.lang.D.DRAG_HANDLE;
import static interlink.util.lang.E.ELEVATION_GRAPH;
import static interlink.util.lang.F.FIND_MY_LOCATION;
import static interlink.util.lang.S.SEARCH_1;
import static interlink.util.lang.S.SEARCH_2;
import static interlink.util.lang.T.TOTAL_DISTANCE;
import static interlink.util.lang.V.VIEW_HOLDER;
import static interlink.util.lang.Z.ZOOM_IN;
import static interlink.util.lang.Z.ZOOM_OUT;
import static interlink.util.lang.word.C.COMPASS;
import static interlink.util.lang.word.L.LOGIN;
import static interlink.util.lang.word.P.POLYGON;
import static interlink.util.lang.word.R.RULER;
import static interlink.util.lang.word.S.SETTINGS;
import static works.lysenko.util.chrs.____.INFO;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.lang.word.S.SEARCH;

@SuppressWarnings({"HardCodedStringLiteral", "MissingJavadoc", "StaticMethodOnlyUsedInOneClass", "WeakerAccess",
        "PublicStaticArrayField"})
public record Constants() {

    public final static String[] MAIN_SCREEN_ELEMENTS = {c(INFO), c(SEARCH), ZOOM_IN, ZOOM_OUT, VIEW_HOLDER, ADD_OBJECT,
            c(RULER), TOTAL_DISTANCE, c(POLYGON), ELEVATION_GRAPH, FIND_MY_LOCATION, c(COMPASS), DRAG_HANDLE, c(LOGIN),
            c(SETTINGS), SEARCH_1, SEARCH_2};
}