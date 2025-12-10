package tacticmap.tree.root.addObject;

import interlink.util.Constants;
import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.CANCEL_BUTTON_LABEL;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Cancel extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(CANCEL_BUTTON_LABEL);
        notImplemented();
    }
}


