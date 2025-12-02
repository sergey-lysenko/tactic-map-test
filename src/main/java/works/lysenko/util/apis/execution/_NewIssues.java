package works.lysenko.util.apis.execution;

import works.lysenko.base.Logs;
import works.lysenko.util.apis.log._LogRecord;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Encapsulates new issues list
 */
@SuppressWarnings({"InterfaceWithOnlyOneDirectInheritor", "BooleanMethodNameMustStartWithQuestion"})
public interface _NewIssues {

    /**
     * @param logRecord log record to add
     */
    void addNewIssue(_LogRecord logRecord);

    /**
     * Used by {@link Logs}
     *
     * @param p string to search Known Issues
     * @return Set of KnownIssues for given query
     */
    Set<String> getKnownIssue(String p);

    /**
     * Retrieves the collection of known issues.
     *
     * @return The collection of known issues as a {@code Collection} of {@code String}.
     */
    Collection<String> getKnownIssues();

    /**
     * @return new issues list (copy)
     */
    List<_LogRecord> getNewIssuesCopy();

    /**
     * @return true if empty
     */
    boolean noNewIssues();
}
