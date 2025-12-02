package works.lysenko.util.apis.execution;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.math3.fraction.Fraction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import works.lysenko.base.Exec;
import works.lysenko.base.Logs;
import works.lysenko.base.Results;
import works.lysenko.tree.Core;
import works.lysenko.util.apis.exception.checked.SafeguardException;
import works.lysenko.util.apis.scenario._Scenario;

import java.util.Set;

/**
 * Interface of Scenario executors
 */
@SuppressWarnings({"InterfaceWithOnlyOneDirectInheritor", "BooleanParameter", "SameReturnValue", "BooleanMethodNameMustStartWithQuestion"})
public interface _Executes {

    /**
     * Creates and initialises a driver for the execution environment.
     * This method is commonly used to set up the necessary configurations
     * to start and manage the execution process.
     *
     * @return {@code true} if the driver was successfully created, otherwise {@code false}.
     */
    boolean createDriver();

    /**
     * Creates and initialises a scaler for execution scenarios.
     * This method is used in conjunction with other initialisation processes to ensure proper scaling
     * and resolution adjustments in the execution environment.
     *
     * @return {@code true} if the scaler was successfully created, otherwise {@code false}.
     */
    boolean createScaler();

    /**
     * Used by {@link Logs}
     *
     * @return logical depth of the current scenario
     */
    int currentDepth();

    /**
     * Used by {@link Exec} and {@link Results}
     *
     * @return link to currently executed Scenario
     */
    _Scenario currentScenario();

    /**
     * String name of current {@link _Scenario}
     *
     * @param clearStack or not
     * @return name of Scenario
     */
    String getCurrentScenario(boolean clearStack);

    /**
     * Retrieves the current scaling factor.
     *
     * @return The Fraction object representing the current scale.
     */
    @SuppressWarnings("unused")
    Fraction getCurrentScale();

    /**
     * @return The minimal depth of the current scenario.
     */
    Integer getMinDepth();

    /**
     * Sets the minimal depth of the current scenario.
     *
     * @param minDepth the minimal depth of the current scenario
     */
    void setMinDepth(Integer minDepth);

    /**
     * @return the set of strings representing issues that have not been reproduced
     */
    @SuppressWarnings("unused")
    Set<String> getNotReproduced();

    /**
     * @return The status of the execution.
     */
    String getStatus();

    /**
     * @return The WebDriver instance.
     */
    WebDriver getWebDriver();

    /**
     * @return The instance of WebDriverWait.
     */
    WebDriverWait getWebDriverWait();

    /**
     * @return {@code true} if the application is in debug mode, {@code false} otherwise.
     */
    boolean isDebug();

    /**
     * @return {@code true} if the application is in trace mode, {@code false} otherwise.
     */
    boolean isTrace();

    /**
     * Removes the given scenario from the execution stack.
     *
     * @param scenario the scenario to be removed
     * @throws SafeguardException if an exception occurs during the removal of the scenario
     */
    void popScenario(_Scenario scenario) throws SafeguardException;

    /**
     * Add {@link _Scenario} to execution stack
     * Used by {@link Core}
     *
     * @param scenario to push into stack
     */
    void pushScenario(_Scenario scenario);

    /**
     * Provides an instance of the AppiumDriverLocalService.
     * The service is used to start, stop, or manage the local Appium server
     * for mobile application testing.
     *
     * @return An instance of AppiumDriverLocalService to manage the local Appium server.
     */
    AppiumDriverLocalService service();
}
