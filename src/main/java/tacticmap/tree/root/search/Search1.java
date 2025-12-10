package tacticmap.tree.root.search;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.lang.S.SEARCH_3;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Search1 extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(SEARCH_3);
        notImplemented(true);
    }
}


