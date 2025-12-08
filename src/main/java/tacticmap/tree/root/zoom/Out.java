package tacticmap.tree.root.zoom;

import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.lang.Z.ZOOM_IN;
import static interlink.util.lang.Z.ZOOM_OUT;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Out extends Leaf {

    @Override
    public final void action() throws SafeguardException {

        clickOn(ZOOM_OUT);
        notImplemented(false); // TODO: add some validation
    }
}


