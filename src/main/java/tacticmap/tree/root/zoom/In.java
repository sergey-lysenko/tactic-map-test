package tacticmap.tree.root.zoom;

import works.lysenko.tree.base.Leaf;
import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.lang.T.TOTAL_DISTANCE;
import static interlink.util.lang.Z.ZOOM_IN;
import static works.lysenko.util.data.enums.Severity.S2;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class In extends Leaf {

    @Override
    public final void action() throws SafeguardException {

        clickOn(ZOOM_IN);
        notImplemented(S2,"Add some validation");
    }
}


