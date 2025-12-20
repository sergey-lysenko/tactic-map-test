package tacticmap.tree.root.search.search0;

import interlink.util.Constants;
import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.SEARCH_TEXT;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Search extends Leaf {

    @Override
    public final void action() throws SafeguardException {

        notImplemented();
        clickOnText(SEARCH_TEXT);
    }

    @Override
    public final boolean fits() {

        return false; //Not implemented yet
    }
}


