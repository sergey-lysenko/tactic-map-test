package tacticmap.tree.root.weather;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.lang.word.S.SETTINGS;
import static works.lysenko.util.data.strs.Case.c;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class More extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOnDesc(c(SETTINGS));
    }
}


