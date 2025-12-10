package tacticmap.tree.root.addObject;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.CREATE_LAYER;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Create extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(CREATE_LAYER);
        notImplemented();
    }
}


