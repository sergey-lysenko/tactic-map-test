package works.lysenko.util.prop.grid;

import static works.lysenko.util.spec.PropEnum._GRID_LOG_LINE_MAX_LENGTH;

/**
 * Represents a logging entity with a maximum line length limit.
 * <p>
 * This record contains a single static final integer, `limit`, which defines the maximum length of a log line.
 * The value of `limit` is retrieved from the application properties, where it is defined as `_GRID_LOG_LINE_MAX_LENGTH`.
 */
public record Logs() {

    /**
     *
     */
    public static final int limit = _GRID_LOG_LINE_MAX_LENGTH.get();
}
