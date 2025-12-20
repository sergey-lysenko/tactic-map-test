package tacticmap.tree.root.info;

import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.MORE_TEXT;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class More extends Leaf {

    @Override
    public final void action() throws SafeguardException {

        clickOnText(MORE_TEXT);
        notImplemented(true);
    }
}


