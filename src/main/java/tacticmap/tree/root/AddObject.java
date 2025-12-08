package tacticmap.tree.root;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.lang.A.ADD_OBJECT;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class AddObject extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(ADD_OBJECT);
        notImplemented();
    }
}


