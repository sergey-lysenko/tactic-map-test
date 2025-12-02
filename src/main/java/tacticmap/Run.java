package tacticmap;

import static interlink.util.Agenda.workflow;
import static works.lysenko.base.test.Routines.run;

/**
 * The Run class is responsible for executing the test tests of the application.
 */
public record Run() {

    /**
     * The main method is the entry point of the application.
     *
     * @param args The command line arguments ignored by the application.
     */
    public static void main(final String[] args) {

        run(workflow);
    }
}
