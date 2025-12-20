package interlink.tree;

import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.*;
import static org.apache.commons.math3.fraction.Fraction.ONE_HALF;
import static org.apache.commons.math3.fraction.Fraction.ONE_QUARTER;

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

        clickOn(ONE_HALF, ONE_QUARTER, MORE_TEXT);
        waitForText(SAVE_BUTTON_TEXT);
        waitForText(COPY_BUTTON_TEXT);
        waitForText(AREA_FORMAT_TEXT);
        waitForText(DISTANCE_FORMAT_TEXT);
        waitForText(SYSTEM_COORDINATES_TEXT);
    }
}


