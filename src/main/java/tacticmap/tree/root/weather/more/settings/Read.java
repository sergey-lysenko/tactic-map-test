package tacticmap.tree.root.weather.more.settings;

import org.openqa.selenium.WebElement;
import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.WEATHER_SETTINGS_ELEMENTS;
import static interlink.util.lang.W.WEATHER_SETTINGS_VALUE_BY_TITLE;
import static works.lysenko.util.chrs.____.BACK;
import static works.lysenko.util.chrs.____.TEXT;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.data.strs.Swap.s;
import static works.lysenko.util.func.core.Assertions.notImplemented;
import static works.lysenko.util.func.type.Booleans.isTrue;
import static works.lysenko.util.func.ui.Descriptors.fill;
import static works.lysenko.util.func.ui.Scroll.swipeBack;
import static works.lysenko.util.spec.Symbols._COLON_;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Read extends Leaf {

    @Override
    public final void action() throws SafeguardException {

        read();
        if (isTrue()) swipeBack();
        else clickOnDesc(c(BACK));
    }

    private void read() {

        // Logs title‑value pairs for each setting
        for (final String title : WEATHER_SETTINGS_ELEMENTS) {
            final WebElement element = find(fill(WEATHER_SETTINGS_VALUE_BY_TITLE, b(title)));
            final String value = element.getAttribute(TEXT);
            log(b(s(title, _COLON_), value));
        }
    }
}


