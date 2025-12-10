package tacticmap.tree.root;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.*;
import static interlink.util.Constants.CLEAR_BUTTON_TEXT;
import static interlink.util.Constants.COORDINATE_TEXT;
import static interlink.util.Constants.MORE_TEXT;
import static interlink.util.lang.D.DRAG_HANDLE;
import static interlink.util.lang.T.TOTAL_DISTANCE;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class TotalDistance extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(TOTAL_DISTANCE);
        waitFor(DRAG_HANDLE);
        waitForText(TOTAL_DISTANCE_TEXT);
        waitForDesc(CLOSE_BUTTON_TEXT);
        waitForDesc(ADD_BUTTON_TEXT);
        waitForText(ADD_BUTTON_TEXT);
        waitForDesc(CLEAR_BUTTON_TEXT);
        waitForText(CLEAR_BUTTON_TEXT);
        waitForDesc(MORE_TEXT);
        waitForText(MORE_TEXT);
        waitForText(COORDINATE_TEXT);
        notImplemented(true);
    }
}


