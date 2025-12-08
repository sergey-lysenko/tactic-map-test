package tacticmap.tree.root;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.lang.word.S.SETTINGS;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Settings extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(SETTINGS);
        notImplemented(true);
    }
}


