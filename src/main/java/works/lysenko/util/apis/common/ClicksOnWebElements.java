package works.lysenko.util.apis.common;

import org.openqa.selenium.WebElement;

/**
 * Interface for clicking on web elements.
 */
@SuppressWarnings({"MethodParameterNamingConvention", "InterfaceWithOnlyOneDirectInheritor", "BooleanParameter"})
public interface ClicksOnWebElements {

    /**
     * @param element to click on
     */
    void clickOn(WebElement element);

    /**
     * Click on an Element defined by locator and then wait for certain milliseconds
     *
     * @param element   to click on
     * @param waitAfter amount of milliseconds to wait after clicking
     */
    void clickOn(WebElement element, long waitAfter);

    /**
     * @param element  to be clicked on
     * @param geometry whether to output information about geometry or not
     */
    void clickOn(WebElement element, boolean geometry);

    /**
     * Perform a non-centered click on an element. Exact location of click defined
     * by two double typed relative x and y coordinates, where value 0.0 corresponds
     * to leftmost or upmost part of the element, as 1.0 is for rightmost of the lowest
     * part of an object.
     * <p>
     * Consequently, coordinates (0.5, 0.5) defining a center of the object
     *
     * @param x1      requested x coordinate offset
     * @param y1      requested y coordinate offset
     * @param locator string locator(s) of element to be clicked on
     */
    void clickOn(double x1, double y1, String... locator);

    /**
     * Click on an Element defined by locator and then wait for certain milliseconds
     *
     * @param locator   string locator of element to click on
     * @param waitAfter amount of milliseconds to wait after clicking
     */
    void clickOn(String locator, long waitAfter);

    /**
     * Click on an Element defined by locator
     *
     * @param locator string locator of element to click on
     */
    void clickOn(String locator);

    /**
     * Click on an Element defined by locator and wait for it's disappearance
     *
     * @param thenWaitForInvisibilityOf optionally wait for disappearance of same element
     * @param locator                   string locator of element to click on
     */
    void clickOn(boolean thenWaitForInvisibilityOf, String locator);

    /**
     * Click on an Element defined by locator
     *
     * @param thenWaitForInvisibilityOf optionally wait for disappearance of same element
     * @param element                   handle of element to click on
     */
    void clickOn(boolean thenWaitForInvisibilityOf, WebElement element);

    /**
     * Click on a Text and then wait for certain milliseconds
     *
     * @param text      to click on
     * @param waitAfter amount of milliseconds to wait after clicking
     */
    void clickOnText(String text, long waitAfter);

    /**
     * Click on a Text
     *
     * @param text to click on
     */
    void clickOnText(String text);

    /**
     * Click on a Text and wait for it to disappear
     *
     * @param text                      to click on
     * @param thenWaitForInvisibilityOf optionally wait for disappearance of same element
     */
    void clickOnText(boolean thenWaitForInvisibilityOf, String text);

    /**
     * Hide/Close Android Sensor Keyboard
     */
    void hideKeyboard();

    /**
     * @param text to click on if it exists
     */
    void ifExistsClickOnText(String text);
}
