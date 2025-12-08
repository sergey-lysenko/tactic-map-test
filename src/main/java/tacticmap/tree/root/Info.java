package tacticmap.tree.root;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static works.lysenko.util.chrs.____.INFO;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Info extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(c(INFO));
        notImplemented(true);
    }
}


