package tacticmap.tree.root;

import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.DRAG_HANDLE_STEP;
import static interlink.util.lang.D.DRAG_HANDLE;
import static works.lysenko.util.func.core.Assertions.notImplemented;
import static works.lysenko.util.func.ui.Scroll.swipeVertically;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class DragHandle extends Leaf {

    @Override
    public final void action() throws SafeguardException {

        swipeVertically(DRAG_HANDLE, -DRAG_HANDLE_STEP);
        swipeVertically(DRAG_HANDLE, DRAG_HANDLE_STEP);
        notImplemented(false);
    }
}


