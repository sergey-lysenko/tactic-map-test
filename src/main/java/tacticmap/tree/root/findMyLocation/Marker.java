package tacticmap.tree.root.findMyLocation;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Routines.assertImage;
import static works.lysenko.util.chrs.____.ROOT;
import static works.lysenko.util.data.strs.Case.c;

@SuppressWarnings({"unused", "MissingJavadoc", "HardCodedStringLiteral", "HardcodedFileSeparator"})
public class Marker extends Node {

    @Override
    public final void action() throws SafeguardException {

        sleepLong(); // TODO: add some better way to skip\wait scrolling
        assertImage(c(ROOT), "location/Marker");
    }
}