package tacticmap.tree.root.totalDistance;

import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.ADD_BUTTON_TEXT;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Add extends Leaf {

    @Override
    public final void action() throws SafeguardException {

        clickOnText(ADD_BUTTON_TEXT);
        notImplemented(true);
    }

    @Override
    public final boolean fits() {

        return false; // TODO: implement
    }
}


