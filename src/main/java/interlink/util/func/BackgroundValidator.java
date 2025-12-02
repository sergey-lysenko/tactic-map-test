package interlink.util.func;

import works.lysenko.util.data.enums.Severity;
import works.lysenko.util.grid.record.gsrc.ColourSearchRequest;

import static works.lysenko.util.data.strs.Swap.s;
import static works.lysenko.util.lang.word.B.BACKGROUND;
import static works.lysenko.util.spec.Layout.s;

/**
 * The BackgroundValidator class provides methods to validate page elements and properties.
 */
@SuppressWarnings({"StaticMethodOnlyUsedInOneClass", "SameParameterValue"})
public record BackgroundValidator() {

    /**
     * Verifies the background properties of a page element based on the provided locator, name, foreground, and failure severity.
     *
     * @param locator         the unique identifier or selector used to locate the page element
     * @param name            the name of the background to be verified
     * @param foreground      a ColourSearchRequest object representing foreground color requirements for validation
     * @param failureSeverity the severity level to use if the background verification fails
     */
    public static void verifyBackground(final String locator, final String name, final ColourSearchRequest foreground,
                                        final Severity failureSeverity) {

        works.lysenko.util.grid.validation.BackgroundValidator.bv(locator, s(BACKGROUND, s, name), foreground, failureSeverity).doVerify();
    }
}