package tacticmap.tree.root;

import interlink.tree.OptionalClose;
import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.WEATHER;
import static interlink.util.Constants.WEATHER_SCREEN_ELEMENTS_I;
import static interlink.util.Constants.WEATHER_SCREEN_ELEMENTS_II;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Weather extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(WEATHER);
        waitForTexts(WEATHER_SCREEN_ELEMENTS_I);
        waitForTexts(WEATHER_SCREEN_ELEMENTS_II);
    }

    @Override
    public final void finals() throws SafeguardException {

        new OptionalClose().isOk();
    }
}


