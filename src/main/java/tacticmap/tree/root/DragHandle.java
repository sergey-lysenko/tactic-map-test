package tacticmap.tree.root;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.lang.D.DRAG_HANDLE;
import static works.lysenko.util.func.core.Assertions.notImplemented;
import static works.lysenko.util.func.ui.Scroll.swipeVertically;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class DragHandle extends Node {

    @Override
    public final void action() throws SafeguardException {

        swipeVertically(DRAG_HANDLE, -1);
        notImplemented(true);
    }
}


