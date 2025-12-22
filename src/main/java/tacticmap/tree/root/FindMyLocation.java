package tacticmap.tree.root;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.lang.F.FIND_MY_LOCATION;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class FindMyLocation extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(FIND_MY_LOCATION);
    }
}