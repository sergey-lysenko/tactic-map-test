package tacticmap.tree.root.polygon;

import interlink.tree.CommonClose;
import works.lysenko.tree.base.Leaf;
import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.CLEAR_BUTTON_TEXT;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Clear extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOnText(CLEAR_BUTTON_TEXT);
        notImplemented(false);
    }
}


