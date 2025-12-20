package tacticmap.tree.root.addObject.create;

import interlink.util.Constants;
import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.SAVE_BUTTON_TEXT;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Save extends Leaf {

    @Override
    public final void action() throws SafeguardException {

        notImplemented();
        clickOnDesc(SAVE_BUTTON_TEXT);
    }

    @Override
    public final boolean fits() {

        return false; //Not implemented yet
    }
}


