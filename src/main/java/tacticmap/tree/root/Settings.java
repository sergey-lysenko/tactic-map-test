package tacticmap.tree.root;

import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.*;
import static interlink.util.lang.word.S.SETTINGS;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.func.core.Assertions.notImplemented;
import static works.lysenko.util.func.ui.Locators.text;
import static works.lysenko.util.func.ui.Scroll.swipeVertically;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class Settings extends Leaf {

    @Override
    public final void action() throws SafeguardException {

        clickOn(c(SETTINGS));
        waitForDesc(CLOSE_BUTTON_TEXT);
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
        waitForDesc(CALL_SIGN_TEXT);
        swipeVertically(text(SUPPORT_TEXT), -DRAG_HANDLE_STEP);
        waitForText(FRIEND_INVITE_TEXT);
        waitForText(CONTACT_DEVELOPER_TEXT);
        waitForText(FUNCTION_PROPOSAL_TEXT);
        waitForText(FEEDBACK_BUTTON_TEXT);
        waitForText(LEGAL_NOTICE_TEXT);
        waitForText(ACCEPTABLE_USE_TEXT);
        waitForText(PRIVACY_POLICY_TEXT);
        waitForText(MISCELLANEOUS_TEXT);
        waitForText(FEATURES_INTRODUCTION_TEXT);
        waitForText(ADDITIONAL_APPS_TEXT);
        waitForText(FULL_VERSION_TEXT);
        waitForText(FUNCTIONS_DISPLAY_TEXT);
        notImplemented(false); // TODO: implement
        clickOnDesc(CLOSE_BUTTON_TEXT);

    }
}


