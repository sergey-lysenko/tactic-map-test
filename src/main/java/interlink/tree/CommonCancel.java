package interlink.tree;

import works.lysenko.tree.base.Leaf;
import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.CANCEL_BUTTON_LABEL;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class CommonCancel extends Leaf {

    @Override
    public final void action() throws SafeguardException {

        clickOnText(CANCEL_BUTTON_LABEL);
    }
}


