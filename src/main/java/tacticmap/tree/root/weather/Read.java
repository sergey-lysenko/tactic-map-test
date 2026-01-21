package tacticmap.tree.root.weather;

import interlink.tree.CommonClose;
import org.openqa.selenium.WebElement;
import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.WEATHER_SCREEN_ELEMENTS_I;
import static interlink.util.Constants.WEATHER_SCREEN_ELEMENTS_II;
import static interlink.util.lang.W.*;
import static works.lysenko.util.chrs.____.TEXT;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Swap.s;
import static works.lysenko.util.func.ui.Descriptors.fill;
import static works.lysenko.util.func.ui.Scroll.swipe;
import static works.lysenko.util.func.ui.Scroll.swipeBack;
import static works.lysenko.util.spec.Symbols._COLON_;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Read extends Leaf {

    /**
     * Executes a sequence of actions to read and process weather-related data, perform swipe interactions,
     * and finalise the operation within the context of a weather-related screen.
     * <p>
     * The method performs the following:
     * 1. Reads and processes initial weather-related values.
     * 2. Reads specific weather screen elements (group I).
     * 3. Performs a swipe interaction.
     * 4. Reads additional weather screen elements (group II).
     * 5. Performs a swipe-back interaction to return to the original state.
     * 6. Validates the successful execution of the operation using a common close mechanism.
     * <p>
     * Any exceptions during this process, such as safeguard validation failures, will result in the
     * throwing of a {@code SafeguardException}.
     *
     * @throws SafeguardException if an error occurs during the execution of the defined actions
     */
    public final void action() throws SafeguardException {

        readValues();
        readValues(WEATHER_SCREEN_ELEMENTS_I);
        swipe();
        readValues(WEATHER_SCREEN_ELEMENTS_II);
        swipeBack();
    }

    /**
     * Reads and processes values associated with specific weather-related constants.
     * This method sequentially retrieves, logs, and handles the values for the following constants:
     * WEATHER_PLACE, WEATHER_COORDINATES, WEATHER_UPDATE, WEATHER_RECOMMENDATION, and WEATHER_EXPLANATION.
     * It uses the {@code readValue} method for each constant to achieve this.
     */
    private void readValues() {

        readValue(WEATHER_PLACE);
        readValue(WEATHER_COORDINATES);
        readValue(WEATHER_UPDATE);
        readValue(WEATHER_RECOMMENDATION);
        readValue(WEATHER_EXPLANATION);
    }

    /**
     * Reads the value associated with the specified title, processes it,
     * and logs the title-value pair.
     * <p>
     * This method retrieves the value of an attribute defined by {@code TEXT}
     * for the provided title, combines it with the title into a formatted string,
     * and logs the resulting string for further analysis or debugging.
     *
     * @param title the title whose associated value is to be found and processed
     */
    private void readValue(final String title) {

        final String value = find(title).getAttribute(TEXT);
        log(b(title, value));
    }

    /**
     * Reads and logs the values associated with the provided array of titles.
     * For each title in the given array, this method finds a web element
     * using a locator derived from the title, retrieves the element's value
     * using the specified attribute, and logs a formatted title-value pair.
     *
     * @param strings an array of titles whose associated values are to be retrieved and logged
     */
    private void readValues(final String[] strings) {

        // Iterates titles; logs title‑value pairs for each
        for (final String title : strings) {
            final WebElement element = find(fill(WEATHER_VALUE_BY_TITLE, b(title)));
            final String value = element.getAttribute(TEXT);
            log(b(s(title, _COLON_), value));
        }
    }
}


