package tacticmap.tree.root;

import interlink.util.Constants;
import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.DRAG_HANDLE_STEP;
import static interlink.util.lang.D.DRAG_HANDLE;
import static works.lysenko.util.func.core.Assertions.notImplemented;
import static works.lysenko.util.func.ui.Scroll.swipeVertically;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class DragHandle extends Node {

    @Override
    public final void action() throws SafeguardException {

        swipeVertically(DRAG_HANDLE, -DRAG_HANDLE_STEP);
        swipeVertically(DRAG_HANDLE, DRAG_HANDLE_STEP);
        notImplemented(false);
    }
}


