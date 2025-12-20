package interlink.tree;

import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.*;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class CommonMore extends Leaf {


    @Override
    public final void action() throws SafeguardException {

        menuOn();
        menuOff();
    }

    private void menuOff() {

        clickOnText(MORE_TEXT);
        waitForInvisibilityOfText(SAVE_BUTTON_TEXT);
        waitForInvisibilityOfText(COPY_BUTTON_TEXT);
        waitForInvisibilityOfText(AREA_FORMAT_TEXT);
        waitForInvisibilityOfText(DISTANCE_FORMAT_TEXT);
        waitForInvisibilityOfText(SYSTEM_COORDINATES_TEXT);
    }

    private void menuOn() {

        clickOnText(MORE_TEXT);
        clickOnText(SAVE_BUTTON_TEXT);
        clickOnText(COPY_BUTTON_TEXT);
        clickOnText(AREA_FORMAT_TEXT);
        clickOnText(DISTANCE_FORMAT_TEXT);
        clickOnText(SYSTEM_COORDINATES_TEXT);
    }
}


