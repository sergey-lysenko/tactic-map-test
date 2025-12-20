package tacticmap.tree.root.addObject;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.*;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Create extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOnText(CREATE_LAYER);
        clickOnText(LAYER_CREATION_TEXT);
        clickOnText(SAVE_BUTTON_TEXT);
        clickOnText(DESCRIPTION_TEXT);
        clickOnText(LAYER_NAME_TEXT);
        clickOnText(LAYER_NAME_EXAMPLE_TEXT);
        clickOnText(NOTE_TEXT);
        clickOnText(INFO_DESCRIPTION_TEXT);
    }
}


