package interlink.util;

import interlink.util.lang.I;
import org.openqa.selenium.WebElement;
import works.lysenko.util.func.core.Assertions;
import works.lysenko.util.func.type.RandomListElement;

import java.util.List;

import static interlink.util.lang.I.IMAGE_VERIFICATION_FAILED;
import static interlink.util.lang.word.I.ITEMS;
import static java.lang.Math.abs;
import static works.lysenko.Base.exec;
import static works.lysenko.util.chrs.____.ITEM;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.data.strs.Swap.s;
import static works.lysenko.util.func.imgs.Grid.test;
import static works.lysenko.util.func.imgs.Screenshot.makeScreenshot;
import static works.lysenko.util.func.type.Lists.getRandomListElement;
import static works.lysenko.util.func.type.Numbers.random;
import static works.lysenko.util.func.ui.Scroll.swipeVertically;
import static works.lysenko.util.grid.validation.Check.image;
import static works.lysenko.util.prop.core.Swipe.bigReduction;

/**
 * Provides a set of utility methods for interaction with web elements, such as clicking on elements,
 * performing swipe gestures, and verifying images, primarily intended for testing or automation tasks.
 */
public record Routines() {

    /**
     * Clicks on a randomly selected element from a list of web elements.
     * <p>
     * This method performs the following actions:
     * 1. Retrieves all elements matching a specific locator.
     * 2. Logs the total count of elements found.
     * 3. Selects a random element from the list of retrieved elements.
     * 4. Captures a screenshot of the selected element, including its index in the list.
     * 5. Clicks on the randomly selected element.
     */
    public static void clickOnRandomElement() {

        final List<WebElement> items = exec.findAll(c(ITEM));
        exec.log(b(s(items.size()), ITEMS));
        final RandomListElement<WebElement> element = getRandomListElement(items);
        makeScreenshot(element.value(), String.valueOf(element.index()));
        exec.clickOn(element.value());
    }


    /**
     * Performs a randomized vertical swipe action with default parameters for testing purposes.
     *
     * @param locator the locator of the element to swipe vertically
     */
    public static void swipeRandomly(final String locator) {

        swipeRandomly(locator, false);
    }

    /**
     * Performs a vertical swipe action with a randomized reduction factor to simulate
     * unpredictable user interaction for testing purposes.
     *
     * @param locator the locator of the element to swipe vertically
     * @param up      a boolean indicating the swipe direction; true for upward, false for downward
     */
    public static void swipeRandomly(final String locator, final boolean up) {

        final int coefficent = up ? 1 : -1;
        final float randomReduction = coefficent * random(1.0F, abs(bigReduction));
        swipeVertically(locator, randomReduction);
    }

    /**
     * Asserts that the image matching the provided name meets the expected verification criteria.
     * This method captures a screenshot of the UI element identified by the given name
     * and verifies the image using a specified test logic. If the test fails, an assertion
     * error will be thrown with a predefined failure message.
     *
     * @param name the name of the UI element to locate and verify through image comparison.
     */
    @SuppressWarnings("StaticMethodOnlyUsedInOneClass")
    public static void assertImage(final String name) {

        Assertions.assertTrue(test(image(makeScreenshot(exec.find(name), name), name)).isPassed(),
                IMAGE_VERIFICATION_FAILED);
    }

}
