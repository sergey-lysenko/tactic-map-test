package tacticmap.tree.root.login;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.*;
import static interlink.util.lang.word.L.LOGO;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.func.ui.Scroll.swipe;
import static works.lysenko.util.lang.word.C.CLOSE;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Verify extends Node {

    @Override
    public final void action() throws SafeguardException {

        waitForText(CONNECT_TEXT);
        waitFor(c(CLOSE));
        waitFor(c(LOGO));
        waitForText(UKROP_SYNC_BETA);
        waitForText(USER_CREDENTIAL_PROMPT);
        waitForText(EMAIL);
        waitForText(PASSWORD);
        waitForText(LOGIN_BUTTON_TEXT);
        waitFor(URL_SETTINGS_LOCATOR);
        waitForText(API_INTEGRATION_MESSAGE);
        swipe(-1);
        waitForText(OPEN_WHATSAPP_TEXT);
        swipe(1);
    }
}





