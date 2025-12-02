package tacticmap.util.test;

import works.lysenko.util.spec.Level;

import static works.lysenko.Base.log;
import static works.lysenko.Base.section;
import static works.lysenko.util.chrs.____.DONE;
import static works.lysenko.util.data.enums.Ansi.bb;
import static works.lysenko.util.data.strs.Bind.b;

/**
 * Represents a Postflight class that implements the ProvidesPostflight interface.
 * The Postflight class is responsible for performing postflight actions.
 */
public class Postflight implements Runnable {

    /**
     * Executes the `run` method for the `Postflight` class.
     * This method performs postflight actions by invoking utility methods
     * to log relevant information about the class and execution status.
     * <p>
     * The `run` method:
     * 1. Adds a section to the execution output using the class's simple name.
     * 2. Logs a message indicating that the postflight action is complete at the `none` log level.
     */
    @Override
    public final void run() {

        section(getClass().getSimpleName());
        log(Level.none, bb(b(getClass().getSimpleName(), DONE)), false);
    }
}
