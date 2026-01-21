package tacticmap.tree.root.weather.more;

import interlink.util.Constants;
import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.*;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Settings extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOnText(SETTINGS_TITLE_TEXT);
        waitForTexts(SAFETY_LIMITS_TITLE, SETTINGS_TITLE_TEXT);
        waitForTexts(WEATHER_SETTINGS_ELEMENTS);
    }
}


