package tacticmap.tree.root;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.*;
import static interlink.util.lang.D.DRAG_HANDLE;
import static works.lysenko.util.chrs.____.INFO;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Info extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(c(INFO));
        waitFor(DRAG_HANDLE);
        waitForText(MAP_CENTER_TEXT);
        waitForDesc(CLOSE_BUTTON_TEXT);
        waitForText(DISTANCE_TEXT);
        waitForDesc(NEW_OBJECT_TEXT);
        waitForText(NEW_OBJECT_TEXT);
        waitForDesc(COPY_BUTTON_TEXT);
        waitForText(COPY_BUTTON_TEXT);
        waitForDesc(MORE_TEXT);
        waitForText(MORE_TEXT);
        waitForText(COORDINATES_TEXT);
        waitForText(HEIGHT_TEXT);
        waitForText(MAP_NOMENCLATURE_TEXT);
        notImplemented(true);
    }
}


