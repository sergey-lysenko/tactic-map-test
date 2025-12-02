package tacticmap.util.test;

import works.lysenko.util.apis.core._Status;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static works.lysenko.util.data.strs.Bind.b;

/**
 * The Status class provides an implementation of the _Status interface.
 * This class is responsible for retrieving status information using the get method.
 * The get method ensures that the status data is formatted by binding strings
 * with a predefined separator.
 */
public class Status implements _Status {

    @Override
    public final String get() {

        return b(EMPTY);
    }
}
