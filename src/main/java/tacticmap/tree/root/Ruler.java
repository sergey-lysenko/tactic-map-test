package tacticmap.tree.root;

import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.*;
import static interlink.util.lang.word.R.RULER;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Ruler extends Leaf {

    @Override
    public final void action() throws SafeguardException {

        clickOn(c(RULER));
        waitForDesc(CLOSE_BUTTON_TEXT);
        waitForText(MAP_RELOCATION_TEXT);
        waitForText(DEVIATION_TEXT);
        waitForText(HEIGHT_GRAPH_TEXT);
        waitForText(ORIGIN_TEXT);
        waitForText(TERMINAL_TEXT);
        clickOnDesc(CLOSE_BUTTON_TEXT);
        notImplemented(false); // TODO: implement
    }
}