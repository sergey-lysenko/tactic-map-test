package tacticmap.tree.root.info;

import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.CLOSE_BUTTON_TEXT;
import static interlink.util.Constants.COPY_BUTTON_TEXT;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Copy extends Leaf {

    @Override
    public final void action() throws SafeguardException {

        clickOnDesc(COPY_BUTTON_TEXT);

        notImplemented(true);
    }
}


