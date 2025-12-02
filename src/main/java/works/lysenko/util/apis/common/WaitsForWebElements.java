package works.lysenko.util.apis.common;

import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * The WaitsForWebElements interface defines methods for waiting for the appearance, visibility, and behavior of web elements.
 * It provides methods to wait for elements to become visible, clickable, or not visible.
 * It also provides methods to wait for specific texts to appear or disappear.
 * The interface also includes methods to wait for elements to be selected and to wait for the value of an element to change.
 */
@SuppressWarnings({"ClassWithTooManyMethods", "InterfaceWithOnlyOneDirectInheritor", "unused"})
public interface WaitsForWebElements {

    /**
     * Wait for appearance of the defined element
     *
     * @param locator string locator of an element to be waited for
     */
    void wait(String locator);

    /**
     * Wait for appearance of the defined element
     *
     * @param locator string locator of an element to be waited for
     */
    void wait(String[] locator);

    /**
     * Wait for an element to be clickable
     *
     * @param locator string locator of an element expected to be clickable
     */
    @SuppressWarnings("unused")
    void waitClickable(String locator);

    /**
     * Wait for appearance of the defined element
     *
     * @param locator string locator of an element to be waited for
     */
    void waitFor(String locator);

    /**
     * Wait for an element to be not visible
     *
     * @param locator string locator of an element expected to be invisible
     */
    void waitForInvisibilityOf(String locator);

    /**
     * Waits for the invisibility of an optional element specified by its locator.
     *
     * @param locator the string locator of the element to wait for its invisibility
     * @return true if the element becomes invisible, false otherwise
     */
    @SuppressWarnings("BooleanMethodNameMustStartWithQuestion")
    boolean waitForInvisibilityOfOptional(String locator);

    /**
     * Wait for an element to be not visible
     *
     * @param element string locator of an element expected to be invisible
     */
    void waitForInvisibilityOf(WebElement element);

    /**
     * Wait for an element to be not visible, with specific implicit wait
     *
     * @param locator string locator of an element expected to be invisible
     * @param iwait   implicit wait for this call
     */
    @SuppressWarnings("unused")
    void waitForInvisibilityOf(String locator, Duration iwait);

    /**
     * Wait for an element to be not visible, with specific implicit wait
     *
     * @param element element expected to be invisible
     * @param iwait   implicit wait for this call
     */
    @SuppressWarnings("unused")
    void waitForInvisibilityOf(WebElement element, Duration iwait);

    /**
     * Wait for a text to be not visible
     *
     * @param text expected to be invisible
     */
    void waitForInvisibilityOfText(String text);

    /**
     * Wait for a text to be not visible, with specific implicit wait
     *
     * @param text  to be invisible
     * @param iwait implicit wait for this call
     */
    void waitForInvisibilityOfText(String text, Duration iwait);

    /**
     * Wait for the appearance of the defined text
     *
     * @param text to be waited for
     */
    void waitForText(String text);

    /**
     * Waits until all the specified texts become present or visible.
     *
     * @param texts an iterable collection of strings representing the texts to be waited for
     */
    void waitForTexts(Iterable<String> texts);

    /**
     * Wait for appearance of the defined element
     *
     * @param locator string locator of an element to wait for
     */
    void waitForVisibilityOf(String locator);

    /**
     * Wait for appearance of the element defined by one of locators
     *
     * @param locators several string locators to randomly select from
     */
    @SuppressWarnings({"unused", "OverloadedVarargsMethod"})
    void waitForVisibilityOf(String... locators);

    /**
     * Wait for appearance of the defined text
     *
     * @param text to wait for
     */
    void waitForVisibilityOfText(String text);

    /**
     * Wait for an element to be selected
     *
     * @param locator string locator of an element expected to be selected
     */
    void waitSelected(String locator);

    /**
     * Wait for appearance of the defined element and the click on it
     *
     * @param locator string locator of an element to be waited for
     * @param x1      coordinate offset
     * @param y1      coordinate offset
     */
    void waitThenClickOn(double x1, double y1, String locator);

    /**
     * Wait for appearance of the defined element and the click on it
     *
     * @param locator string locator of an element to be waited for
     */
    void waitThenClickOn(String locator);

    /**
     * Wait for appearance of the defined element, click on it, wait for it to be got
     *
     * @param thenWaitForInvisibilityOf if true
     * @param locator                   string locator of an element to be waited for
     */
    void waitThenClickOn(boolean thenWaitForInvisibilityOf, String locator);

    /**
     * Wait for appearance of the defined text and the click on it
     *
     * @param text string locator of an element to be waited for //TODO: make this not Android-only
     */
    void waitThenClickOnText(String text);

    /**
     * Wait for appearance of the defined element and return reference to it
     *
     * @param locator string locator of an element to be waited for
     * @return element
     */
    WebElement waitThenFind(String locator);

    /**
     * Wait for a text value to differ from defined.
     *
     * @param locator string locator of an element
     * @param value   expected value
     */
    void waitValue(String locator, String value);

    /**
     * Wait for a text value of an element to change from defined one.
     *
     * @param locator string locator of an element
     * @param value   the value to change from
     * @return value after the detected change
     */
    String waitValueNot(String locator, String value);

    /**
     * Wait for a non-empty text value
     *
     * @param locator string locator of an element
     * @return value after the detected change
     */
    String waitValueNotEmpty(String locator);
}
