package tacticmap.tree.root;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.*;
import static interlink.util.lang.word.S.SETTINGS;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.func.core.Assertions.notImplemented;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Settings extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(c(SETTINGS));
        waitForText(SECURITY_TEXT);
        waitForText(FEEDBACK_BUTTON_TEXT);
        waitForText(FUNCTION_PROPOSAL_TEXT);
        waitForText(CONTACT_DEVELOPER_TEXT);
        waitForText(MAP_LABEL);
        waitForText(SETTINGS_TITLE);
        waitForText(MEASUREMENT_UNITS_LABEL);
        waitForText(PERSONALIZATION_TEXT);
        waitForText(FRIEND_INVITE_MESSAGE);
        waitForText(TITLE_SHAPES_AND_OBJECTS);
        waitForText(EXPORT_IMPORT_CALLSIGN_DESCRIPTION);
        waitForText(CALL_SIGN_TEXT);
        waitForText(GENERAL_SETTINGS_TITLE);
        waitForText(SUPPORT_TEXT);
        waitForEdit(CLOSE_BUTTON_TEXT);
        waitForDesc(CALL_SIGN_TEXT);
        notImplemented(true);
    }
}


