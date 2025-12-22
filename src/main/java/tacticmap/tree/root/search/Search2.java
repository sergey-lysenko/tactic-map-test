package tacticmap.tree.root.search;

import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.lang.S.SEARCH_2;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc", "ClassNamePrefixedWithPackageName"})
public class Search2 extends Leaf {

    @Override
    public final void action() throws SafeguardException {

        clickOn(SEARCH_2);
        notImplemented(false);
    }
}


