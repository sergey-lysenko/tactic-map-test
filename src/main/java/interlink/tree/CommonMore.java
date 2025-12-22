package interlink.tree;

import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.MORE_TEXT;

@SuppressWarnings({"unused", "MissingJavadoc"})
public abstract class CommonMore extends Leaf {

    private final String[] texts;

    protected CommonMore(final String[] texts) {this.texts = texts;}

    @Override
    public final void action() throws SafeguardException {

        menuOn();
        menuOff();
    }

    private void menuOff() {

        back();
        waitForInvisibilityOfTexts(texts);
    }

    private void menuOn() {

        clickOnText(MORE_TEXT);
        waitForTexts(texts);
    }
}


