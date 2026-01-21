package tacticmap.util.test;

import works.lysenko.util.spec.Level;

import static works.lysenko.Base.*;
import static works.lysenko.util.chrs.____.DONE;
import static works.lysenko.util.data.enums.Ansi.bb;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.lang.word.C.CLOSE;

/**
 * The Preflight class implements the Runnable interface to perform preflight actions.
 * This class is responsible for handling initialisation tasks before executing other operations.
 * <p>
 * The `run` method:
 * 1. Adds a section to the execution output using the class's simple name.
 * 2. Checks for the presence of a specific element identified by a locator and, if present, interacts with it.
 * 3. Logs a message indicating the completion of the preflight action at the `none` log level.
 */
public class Preflight implements Runnable {

    @Override
    public final void run() {

        section(getClass().getSimpleName());
        if (isPresent(c(CLOSE))) clickOn(c(CLOSE));
        log(Level.none, bb(b(getClass().getSimpleName(), DONE)), false);
    }
}
