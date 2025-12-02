package tacticmap.util.test;

import works.lysenko.tree.base.Exceptional;
import works.lysenko.util.apis.exception.checked.SafeguardException;

/**
 * The `Specifics` class extends the `Exceptional` class to provide specific
 * behavior for handling unresolved states during exceptional scenarios.
 * <p>
 * This class overrides the `action()` method to conditionally invoke the
 * parent implementation of the method based on the unresolved state.
 * The `unresolved()` method determines if the current state requires
 * additional resolution.
 * <p>
 * The `Specifics` class is designed to work within a framework for managing
 * exceptions and test run conditions, leveraging functionality provided by
 * the `Exceptional` superclass.
 */
public class Specifics extends Exceptional {

    @Override
    public final void action() throws SafeguardException {

        if (unresolved()) super.action();
    }
}