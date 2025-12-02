package works.lysenko.util.func.grid;

import org.apache.commons.math3.fraction.Fraction;
import works.lysenko.util.apis.grid.q._Quota;
import works.lysenko.util.apis.grid.q._Quotas;
import works.lysenko.util.apis.grid.r._Ranger;
import works.lysenko.util.data.enums.Severity;
import works.lysenko.util.data.range.IntegerRange;
import works.lysenko.util.data.range.Quota;
import works.lysenko.util.data.type.list.RangeResults;
import works.lysenko.util.data.type.list.RangerResults;
import works.lysenko.util.func.grid.colours.ActualFraction;
import works.lysenko.util.func.grid.ranger.Get;
import works.lysenko.util.func.grid.ranger.Issues;
import works.lysenko.util.func.grid.ranger.Render;
import works.lysenko.util.grid.record.meta.Method;
import works.lysenko.util.grid.record.meta.ValidationMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static works.lysenko.Base.logDebug;
import static works.lysenko.Base.logEvent;
import static works.lysenko.util.chrs.__.IN;
import static works.lysenko.util.chrs.__.IS;
import static works.lysenko.util.data.enums.Severity.S0;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.data.strs.Swap.s1;
import static works.lysenko.util.func.type.Objects.isNotNull;
import static works.lysenko.util.lang.A.ACTUAL_VALUES_ARE_NOT_VALID;
import static works.lysenko.util.lang.T.THERE_ARE;
import static works.lysenko.util.lang.word.D.DUPLICATE;
import static works.lysenko.util.lang.word.E.EXPECTED;
import static works.lysenko.util.lang.word.R.RANGER;
import static works.lysenko.util.lang.word.R.RESULT;
import static works.lysenko.util.lang.word.S.SHARES;

/**
 * Represents an abstract Ranger for a generic type T.
 * Contains methods for adding actual values, validating the expected values, checking if issues are present,
 * and determining if the values are within the specified ranges.
 *
 * @param <T> type of value
 */
public abstract class AbstractRanger<T> implements _Ranger<T> {

    private final ValidationMeta meta;
    private final IntegerRange amount;
    private final Map<T, ActualFraction> actual;
    private final Severity severity;
    private final _Quotas<T> expected;
    private final boolean ignoreOrder;
    private final boolean ignoreOther;
    private final Renderers renderers;

    private final Issues<T> issues;
    private final Render<T> render;

    /**
     * Constructs an AbstractRanger object with the provided parameters.
     *
     * @param meta        the ValidationMeta object containing meta information for the validation request
     * @param actual      a Map of actual values to be validated
     * @param expected    the _Quotas object representing the expected values
     * @param amount      the IntegerRange object defining the valid amount range
     * @param ignoreOrder a boolean indicating whether the order should be ignored during validation
     * @param renderers   the Renderers object for customization during validation
     * @param severity    the Severity level for the validation
     */
    protected AbstractRanger(final ValidationMeta meta, final Map<T, ActualFraction> actual, final _Quotas<T> expected,
                             final IntegerRange amount, final boolean ignoreOrder, final boolean ignoreOther, final Renderers renderers,
                             final Severity severity) {

        this.meta = meta;
        this.actual = actual;
        this.expected = expected;
        this.amount = amount;
        this.severity = severity;
        this.ignoreOrder = ignoreOrder;
        this.ignoreOther = ignoreOther;
        this.renderers = renderers;
        issues = new Issues<>(meta);
        render = new Render<>(meta, expected, actual, renderers);
    }

    /**
     * Validates the expected quotas by inspecting the provided _Quotas object. This method
     * ensures there are no duplicate quota values within the list retrieved from the given
     * _Quotas instance. In the case of duplicate entries, an appropriate log event is triggered.
     *
     * @param expected the _Quotas object containing a list of quota values to be validated
     */
    private static void validateExpected(final _Quotas<?> expected) {

        final List<_Quota<?>> list = expected.get();
        final Set<?> set = list.stream().map(_Quota::value).collect(Collectors.toSet());
        if (set.size() < list.size()) {
            final int diff = list.size() - set.size();
            logEvent(S0, b(THERE_ARE, s1(diff, DUPLICATE), IN, EXPECTED, SHARES));
        }
    }

    /**
     * Adds a sample to the provided range results.
     *
     * @param toResults     the RangeResults object to which the sample should be added.
     * @param expectedShare the expected share of type T.
     * @param actualValue   the actual value of type T.
     * @param actualShare   the actual share fraction.
     */
    public abstract void addSample(RangeResults toResults, Quota<T> expectedShare, T actualValue, ActualFraction actualShare);

    public final ValidationMeta meta() {

        return meta;
    }

    /**
     * Validates the actual data against the expected quotas and generates the validation results.
     * This method follows these steps:
     * 1. Sets the title for the current validation process.
     * 2. Calculates the expected fraction based on the defined quotas.
     * 3. Processes the actual data using the expected fraction.
     * 4. Generates and returns the resulting RangerResults object.
     *
     * @return a RangerResults object containing the outcomes of the validation process.
     */
    public final RangerResults validate() {

        render.title();
        final Fraction edge = expected();
        return results(actual(edge));
    }

    /**
     * Processes the actual list of values against the provided edge fraction and prepares for rendering.
     * If the list of actual values is empty, an issue is logged indicating that the border is too high.
     * Renders the graph using the given edge fraction.
     *
     * @param edge the Fraction object representing the edge parameter used during rendering
     * @return a list of actual values of type T
     */
    private List<T> actual(final Fraction edge) {

        final List<T> actualValues = getActualValuesList();
        if (actualValues.isEmpty()) issues.addBorderTooHigh();
        render.actual(edge);
        return actualValues;
    }

    /**
     * Validates the expected quotas and renders the calculated expected value,
     * returning the resulting Fraction object.
     *
     * @return a Fraction object representing the calculated expected value
     * after validation and rendering.
     */
    private Fraction expected() {

        validateExpected(expected);
        return render.expected();
    }

    /**
     * Retrieves a list of actual values by extracting keys from the actual dataset.
     * If any issues are present during the validation process, it logs an event with the specified severity.
     *
     * @return a list of extracted actual values of type T
     */
    private List<T> getActualValuesList() {

        final List<T> actualValues = new ArrayList<>(actual.keySet());
        if (issues.areIssuesPresent(meta, actual, expected, amount, renderers))
            logEvent(severity, ACTUAL_VALUES_ARE_NOT_VALID);
        return actualValues;
    }

    /**
     * Retrieves a sample by correlating the actual value with its corresponding expected share
     * and actual share derived from the provided list of actual values.
     *
     * @param of   the actual value of type T for which the sample is to be obtained
     * @param from the list of actual values from which the sample is to be derived
     * @return a Sample object containing the corresponding expected share and actual share
     */
    @SuppressWarnings("unchecked")
    private Sample getSample(final T of, final List<T> from) {

        Quota<T> expectedShare = null;
        Quota<T> correspondingShare = null;

        final int indexOfActual = from.indexOf(of);
        final boolean compulsive = Method.COMPULSIVE == meta().subject().method();

        if (indexOfActual >= expected.get().size()) {
            optionalError(indexOfActual, from, compulsive);
        } else {
            expectedShare = (Quota<T>) expected.get().get(indexOfActual);
            correspondingShare = expectedShare;
        }

        if (isNotNull(expectedShare) && !expectedShare.value().equals(of)) {
            if (ignoreOrder) correspondingShare = Get.correspondingShareOf(meta, expected, of, expectedShare, indexOfActual, ignoreOther);
            else issues.addUnexpectedActual(of, indexOfActual);
        }

        final ActualFraction share = actual.get(of);

        if (compulsive && isNull(correspondingShare)) issues.addNoCorrespondingShare(ignoreOther);
        return new Sample(correspondingShare, share);
    }

    @SuppressWarnings("DataFlowIssue")
    private void optionalError(final int indexOfActual, final List<T> from, final boolean compulsive) {

        if (compulsive) {
            if (isNotNull(amount)) {
                if (indexOfActual >= amount.max()) issues.addTooFewExpectations(amount.max(), from);
            } else {
                issues.addTooFewExpectations(expected.get().size(), from);
            }
        }
    }

    /**
     * Processes an actual value to generate its corresponding sample and add it to the specified range results.
     *
     * @param results      the RangeResults object where the processed sample will be added
     * @param actualValue  the actual value of type T to be processed
     * @param actualValues the list of actual values from which the sample is derived
     */
    @SuppressWarnings("unchecked")
    private void processValue(final RangeResults results, final T actualValue, final List<T> actualValues) {

        final Sample sample = getSample(actualValue, actualValues);
        addSample(results, (Quota<T>) sample.correspondingShare(), actualValue, sample.actualShare());
    }

    /**
     * Processes a list of actual values to generate validation results and determine their severity.
     *
     * @param actualValues the list of actual values to be validated
     * @return a RangerResults object representing the validation results,
     * either based on the range results or the issues encountered
     */
    private RangerResults results(final List<T> actualValues) {

        final RangeResults results = new RangeResults();
        for (final T actualValue : actualValues) processValue(results, actualValue, actualValues);
        final RangerResults result = issues.isEmpty() ? results.basedOn() : issues.get();
        logDebug(b(c(RANGER), RESULT, IS, result.render()));
        return result;
    }

    /**
     * Represents a sample consisting of a corresponding expected share (Quota) and an actual share (ActualFraction).
     * <p>
     * This record is a lightweight, immutable data structure that associates an expected quota
     * with its corresponding actual share, facilitating validation and comparison operations.
     * <p>
     * Note: Both fields are mandatory and should be properly initialized to ensure consistency.
     *
     * @param correspondingShare The expected share of type Quota<?> representing the defined range or quota.
     * @param actualShare        The actual share of type ActualFraction representing the observed or actual fraction.
     */
    private record Sample(Quota<?> correspondingShare, ActualFraction actualShare) {

    }
}