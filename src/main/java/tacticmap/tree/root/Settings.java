package tacticmap.tree.root;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.*;
import static interlink.util.lang.word.S.SETTINGS;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.func.core.Assertions.notImplemented;
import static works.lysenko.util.func.ui.Locators.text;
import static works.lysenko.util.func.ui.Scroll.swipeVertically;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Settings extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(c(SETTINGS));
        waitForText(SECURITY_TEXT);
        waitForText(FEEDBACK_BUTTON_TEXT);
        waitForText(FUNCTION_PROPOSAL_TEXT);
        waitForText(CONTACT_DEVELOPER_TEXT);
        waitForText(MAP_LABEL_TEXT);
        waitForText(SETTINGS_TITLE_TEXT);
        waitForText(MEASUREMENT_UNITS_TEXT);
        waitForText(PERSONALIZATION_TEXT);
        waitForText(FRIEND_INVITE_TEXT);
        waitForText(SHAPES_AND_OBJECTS_TEXT);
        waitForText(EXPORT_IMPORT_CALLSIGN_TEXT);
        waitForText(CALL_SIGN_TEXT);
        waitForText(GENERAL_SETTINGS_TEXT);
        waitForText(SUPPORT_TEXT);
        waitForDesc(CLOSE_BUTTON_TEXT);
        waitForDesc(CALL_SIGN_TEXT);
        swipeVertically(text(SUPPORT_TEXT), -DRAG_HANDLE_STEP);
        notImplemented(true);
    }
}


