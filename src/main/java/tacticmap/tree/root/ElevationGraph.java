package tacticmap.tree.root;

import works.lysenko.tree.base.Node;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static interlink.util.Constants.*;
import static interlink.util.lang.E.ELEVATION_GRAPH;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class ElevationGraph extends Node {

    @Override
    public final void action() throws SafeguardException {

        clickOn(ELEVATION_GRAPH);
        waitForDesc(CLOSE_BUTTON_TEXT);
        waitForText(TACTIC_MAP_PRO_TEXT);
        waitForText(LEGAL_NOTICES_TEXT);
        waitForText(OFFLINE_MAPS_TEXT);
        waitForText(DOWNLOAD_MAP_PROMPT_TEXT);
        waitForText(ELEVATION_GRAPH_TEXT);
        waitForText(TOPOGRAPHY_HELP_TEXT);
        waitForText(UNLIMITED_LAYERS_TEXT);
        waitForText(MISSION_PLANNING_TEXT);
        waitForText(DATA_EXCHANGE_TEXT);
        waitForText(INTEGRATION_TIP_TEXT);
        waitForText(SUBSCRIBE_ACTION_TEXT);
        waitForText(AUTO_RENEWAL_NOTICE_TEXT);
    }
}


