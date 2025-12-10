package tacticmap.tree.root;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.*;
import static interlink.util.lang.A.ADD_OBJECT;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class AddObject extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(ADD_OBJECT);
        waitForText(NO_LAYERS_TEXT);
        waitForText(WARNING_LAYER_REQUIRED);
        waitForText(CANCEL_BUTTON_LABEL);
        waitForText(CREATE_LAYER);
    }
}


