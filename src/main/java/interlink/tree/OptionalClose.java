package interlink.tree;

import works.lysenko.tree.base.Leaf;
import works.lysenko.util.apis.exception.checked.SafeguardException;

import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.lang.word.C.CLOSE;

@SuppressWarnings({"unused", "MissingJavadoc"})
public class OptionalClose extends Leaf {

    @Override
    public final void action() throws SafeguardException {

        if (isPresent(c(CLOSE))) clickOn(c(CLOSE));
    }
}


