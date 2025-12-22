package tacticmap.tree.root.totalDistance;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.CLEAR_BUTTON_TEXT;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Clear extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOnText(CLEAR_BUTTON_TEXT); // TODO: verify that this button is not working properly
        notImplemented(false);
    }
}


