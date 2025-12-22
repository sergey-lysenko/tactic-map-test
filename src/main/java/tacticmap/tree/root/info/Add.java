package tacticmap.tree.root.info;

import works.lysenko.tree.base.Leaf;
import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.ADD_BUTTON_TEXT;
import static interlink.util.Constants.NEW_OBJECT_TEXT;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Add extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOnDesc(NEW_OBJECT_TEXT);
    }
}


