package interlink.util;

import tacticmap.util.spec.PropEnum;
import tacticmap.util.test.Postflight;
import tacticmap.util.test.Preflight;
import tacticmap.util.test.Specifics;
import tacticmap.util.test.Status;
import works.lysenko.util.data.records.test.Workflow;

import java.util.List;

/**
 * The Agenda record holds static references to various classes that implement specific actions
 * defined in the application workflow, including preflight, status reporting, exceptional handling,
 * and postflight actions.
 */
@SuppressWarnings("StaticMethodOnlyUsedInOneClass")
public record Agenda() {

    /**
     * Static final reference to the Workflow records, holding classes for the different phases
     * of the application workflow: Preflight, Status, Specifics, and Postflight.
     */
    public static final Workflow workflow
            = new Workflow(
            Preflight.class,
            Status.class,
            Specifics.class,
            Postflight.class,
            List.of(PropEnum.class));
}
