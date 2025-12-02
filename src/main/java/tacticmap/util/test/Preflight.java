package tacticmap.util.test;

import works.lysenko.util.spec.Level;

import static works.lysenko.Base.log;
import static works.lysenko.Base.section;
import static works.lysenko.util.chrs.____.DONE;
import static works.lysenko.util.data.enums.Ansi.bb;
import static works.lysenko.util.data.strs.Bind.b;

public class Preflight implements Runnable {

    @Override
    public final void run() {

        section(getClass().getSimpleName());
        log(Level.none, bb(b(getClass().getSimpleName(), DONE)), false);

    }
}
