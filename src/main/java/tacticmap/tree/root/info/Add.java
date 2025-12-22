package tacticmap.tree.root.info;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.NEW_OBJECT_TEXT;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Add extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOnDesc(NEW_OBJECT_TEXT);
    }
}


