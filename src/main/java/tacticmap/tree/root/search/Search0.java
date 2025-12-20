package tacticmap.tree.root.search;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.func.core.Assertions.notImplemented;
import static works.lysenko.util.lang.word.S.SEARCH;

@SuppressWarnings({"unused", "MissingJavadoc", "ClassNamePrefixedWithPackageName"})
public class Search0 extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(c(SEARCH));
    }
}


