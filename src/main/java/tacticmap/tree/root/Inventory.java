package tacticmap.tree.root;

import works.lysenko.tree.base.Mono;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.MAIN_SCREEN_ELEMENTS;
import static interlink.util.Routines.assertImage;

public class Inventory extends Mono {

    @Override
    public final void action() throws SafeguardException {

        for (final String element : MAIN_SCREEN_ELEMENTS) assertImage(element);
    }
}



