package tacticmap.tree.root;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Routines.assertImage;
import static interlink.util.lang.F.FIND_MY_LOCATION;
import static works.lysenko.util.chrs.____.ROOT;
import static works.lysenko.util.data.strs.Case.c;

@SuppressWarnings({"unused", "MissingJavadoc", "HardCodedStringLiteral", "HardcodedFileSeparator"})
public class FindMyLocation extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(FIND_MY_LOCATION);
        assertImage(c(ROOT), "location/Marker");
    }
}