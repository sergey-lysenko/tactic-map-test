package tacticmap.tree.root.compass;

import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Routines.assertImage;
import static interlink.util.lang.word.C.COMPASS;
import static works.lysenko.util.chrs.____.ROOT;
import static works.lysenko.util.data.strs.Case.c;

@SuppressWarnings({"unused", "MissingJavadoc", "HardCodedStringLiteral", "HardcodedFileSeparator"})
public class SwitchOnOff extends Leaf {

    @Override
    public final void action() throws SafeguardException {

        verifyOn();
        verifyOff();
    }

    /**
     * Validates the "off" state of the compass UI element by performing a series of actions
     * and assertions. The method interacts with the compass component and verifies visual
     * representations to ensure that the element's state aligns with the expected "off" condition.
     * <p>
     * Functional steps:
     * - Simulates a user clicks on the compass element.
     * - Verifies the visual state of the compass's outer UI representation in its "off" condition.
     * - Verifies the visual state of the compass's inner UI representation in its "off" condition.
     * - Confirms the visual state of the compass element itself.
     */
    private void verifyOff() {

        clickOn(c(COMPASS));
        assertImage(c(ROOT), "compass/Outer.no");
        assertImage(c(ROOT), "compass/Inner.no");
        assertImage(c(COMPASS));
    }

    /**
     * Validates the "on" state of the compass UI element by performing a series of
     * actions and assertions. The method interacts with the compass component and
     * verifies visual representations to ensure the element's state aligns with
     * the expected "on" condition.
     * <p>
     * Functional steps:
     * - Simulates a user click on the compass element.
     * - Verifies the visual state of the compass's outer UI representation in its "on" condition.
     * - Verifies the visual state of the compass's inner UI representation in its "on" condition.
     * - Confirms the visual state of the compass element itself.
     */
    private void verifyOn() {

        clickOn(c(COMPASS));
        assertImage(c(ROOT), "compass/Outer");
        assertImage(c(ROOT), "compass/Inner");
        assertImage(c(COMPASS), "compass/On");
    }
}


