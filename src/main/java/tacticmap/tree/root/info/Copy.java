package tacticmap.tree.root.info;

import interlink.tree.CommonClose;
import works.lysenko.tree.base.Leaf;
import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.COPY_BUTTON_TEXT;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Copy extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOnDesc(COPY_BUTTON_TEXT);
        notImplemented(false);
    }
}


