package tacticmap.tree.root;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.lang.word.R.RULER;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Ruler extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(c(RULER));
        notImplemented(true);
    }
}