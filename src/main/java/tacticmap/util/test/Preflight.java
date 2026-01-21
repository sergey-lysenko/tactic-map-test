package tacticmap.util.test;

import works.lysenko.util.spec.Level;

import static works.lysenko.Base.*;
import static works.lysenko.util.chrs.____.DONE;
import static works.lysenko.util.data.enums.Ansi.bb;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.lang.word.C.CLOSE;

public class Preflight implements Runnable {

    @Override
    public final void run() {

        section(getClass().getSimpleName());
        if (isPresent(c(CLOSE))) clickOn(c(CLOSE));
        log(Level.none, bb(b(getClass().getSimpleName(), DONE)), false);
    }
}
