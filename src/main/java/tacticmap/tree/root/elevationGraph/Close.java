package tacticmap.tree.root.elevationGraph;

import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.CLOSE_BUTTON_TEXT;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Close extends Leaf {

    @Override
    public final void action() throws SafeguardException {

        clickOnDesc(CLOSE_BUTTON_TEXT);
    }
}


