package works.lysenko.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.fraction.Fraction;
import org.openqa.selenium.Point;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import works.lysenko.base.core.Routines;
import works.lysenko.base.exec.DataStorage;
import works.lysenko.base.exec.Scaler;
import works.lysenko.base.util.WebDrivers;
import works.lysenko.tree.Root;
import works.lysenko.util.apis._PropEnum;
import works.lysenko.util.apis.data._DataStorage;
import works.lysenko.util.apis.exception.checked.SafeguardException;
import works.lysenko.util.apis.execution._Executes;
import works.lysenko.util.apis.execution._NewIssues;
import works.lysenko.util.apis.execution._Scaler;
import works.lysenko.util.apis.execution._TestData;
import works.lysenko.util.apis.log._LogRecord;
import works.lysenko.util.apis.scenario._Scenario;
import works.lysenko.util.apis.test._Test;
import works.lysenko.util.data.enums.Platform;
import works.lysenko.util.prop.core.Waits;
import works.lysenko.util.prop.logs.Debug;
import works.lysenko.util.prop.tree.Scenario;
import works.lysenko.util.spec.Layout;
import works.lysenko.util.spec.Level;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.time.Duration;
import java.util.*;
import java.util.function.BiConsumer;

import static java.util.Objects.isNull;
import static works.lysenko.Base.core;
import static works.lysenko.base.util.Platforms.__BASE_PATH;
import static works.lysenko.util.chrs.__.NO;
import static works.lysenko.util.chrs.__.UI;
import static works.lysenko.util.chrs.___.*;
import static works.lysenko.util.chrs.____.*;
import static works.lysenko.util.data.enums.Ansi.MAGENTA_BOLD_BRIGHT;
import static works.lysenko.util.data.enums.Ansi.ansi;
import static works.lysenko.util.data.enums.Severity.S0;
import static works.lysenko.util.data.strs.Bind.b;
import static works.lysenko.util.data.strs.Bind.d;
import static works.lysenko.util.data.strs.Case.c;
import static works.lysenko.util.data.strs.Null.n;
import static works.lysenko.util.data.strs.Swap.s;
import static works.lysenko.util.data.strs.Wrap.q;
import static works.lysenko.util.func.core.Assertions.assertEqualsSilent;
import static works.lysenko.util.func.core.Assertions.fail;
import static works.lysenko.util.func.core.Assertions.еггог;
import static works.lysenko.util.func.type.Objects.isNotNull;
import static works.lysenko.util.grid.validation.BackgroundValidator.bv;
import static works.lysenko.util.lang.A.*;
import static works.lysenko.util.lang.D.DUE_TO;
import static works.lysenko.util.lang.M.MAIN_ACTIVITY;
import static works.lysenko.util.lang.S.SCENARIOS_STACK;
import static works.lysenko.util.lang.U.*;
import static works.lysenko.util.lang.W.WD_HUB;
import static works.lysenko.util.lang.W.WEB_DRIVER;
import static works.lysenko.util.lang.word.A.ADDITIONAL;
import static works.lysenko.util.lang.word.A.ANDROID;
import static works.lysenko.util.lang.word.A.APPIUM;
import static works.lysenko.util.lang.word.B.BROWSER;
import static works.lysenko.util.lang.word.C.COMPONENTS;
import static works.lysenko.util.lang.word.C.CONFIGURING;
import static works.lysenko.util.lang.word.C.CREATING;
import static works.lysenko.util.lang.word.D.DRIVER;
import static works.lysenko.util.lang.word.E.EMPTY;
import static works.lysenko.util.lang.word.E.EXECUTION;
import static works.lysenko.util.lang.word.F.FAILURES;
import static works.lysenko.util.lang.word.I.*;
import static works.lysenko.util.lang.word.K.KNOWN;
import static works.lysenko.util.lang.word.L.LEVEL;
import static works.lysenko.util.lang.word.R.READING;
import static works.lysenko.util.lang.word.R.REARRANGING;
import static works.lysenko.util.lang.word.R.RUNNING;
import static works.lysenko.util.lang.word.S.*;
import static works.lysenko.util.lang.word.U.UNEXPECTED;
import static works.lysenko.util.lang.word.W.WINDOW;
import static works.lysenko.util.spec.PropEnum._APP;
import static works.lysenko.util.spec.PropEnum._BUNDLE_ID;
import static works.lysenko.util.spec.PropEnum._UD_ID;
import static works.lysenko.util.spec.Symbols._DASH_;
import static works.lysenko.util.spec.Symbols._DOT_;

/**
 * This class represents single bot execution information
 *
 * @author Sergii Lysenko
 */
@SuppressWarnings({"ClassWithTooManyFields", "AssignmentToStaticFieldFromInstanceMethod", "MethodWithMultipleReturnPoints",
        "CallToPrintStackTrace", "SuspiciousGetterSetter"})
public final class Exec extends Root implements _TestData, _Executes, _NewIssues {

    private final Collection<String> knownIssues = new HashSet<>(0);
    private final List<_LogRecord> newIssues = new ArrayList<>(0);
    private final ArrayDeque<_Scenario> currentScenariosStack = new ArrayDeque<>(0);
    private Integer minDepth = null;
    private Set<String> notReproduced = null;
    private WebDriverWait wdw = null;
    private WebDriver wd = null;
    private Boolean isDebug = null;
    private _DataStorage dataStorage = null;
    private _Scaler scaler = null;
    private AppiumDriverLocalService service = null;

    /**
     * Constructs a new instance of the Exec class.
     * Initializes the core object with the specified tests, additional parameters,
     * and parameters list. Logs the start of the execution process and initializes a bot.
     *
     * @param test           The _Test object used for execution.
     * @param additional     A1 collection of additional property enums extending _PropEnum.
     * @param parametersList A1 string containing the list of parameters for execution.
     */
    @SuppressWarnings("WeakerAccess")
    public Exec(final _Test test, final Collection<Class<? extends _PropEnum>> additional, final String parametersList) {

        core = createCore(test, additional, parametersList);
        logEmptyLine(true, true);
        createBot();
        log(Level.none, (b(c(TEST), c(EXECUTION), STARTED)), true);
    }

    /**
     * Creates a new instance of the Core class with the specified Test and parameters list.
     *
     * @param test           The Test object.
     * @param parametersList The additional parameters list.
     * @return A1 new instance of the Core class.
     */
    private static Core createCore(final _Test test, final Collection<Class<? extends _PropEnum>> additional,
                                   final String parametersList) {

        return new Core(test, additional, parametersList);
    }

    public void addNewIssue(final _LogRecord logRecord) {

        newIssues.add(logRecord);
    }

    /**
     * Creates the driver for executing the automation.
     * <p>
     * This method initialises the web driver components.
     * It first checks the platform using the Core.getPlatform() method.
     * If the platform is Android, it calls the startAndroid() method to start the Android driver. Otherwise, it calls
     * the startBrowser() method to start the browser driver.
     * After initialising the driver, it creates additional components using the createAdditional() method.
     */
    public boolean createDriver() {
        // Web driver components
        log(Level.none, b(c(INITIALIZING), c(DRIVER), DOTS), true);
        final String platform = Routines.get_Platform();
        if (Platform.ANDROID == Platform.get(platform)) startAndroid();
        else startBrowser();
        log(Level.none, b(c(CREATING), ADDITIONAL, COMPONENTS, DOTS), true);
        createAdditional();
        return isNotNull(wd);
    }

    /**
     * Creates a Scaler instance and performs the necessary initialisations.
     * This method logs the process of creating the Scaler, initialises a Scaler object,
     * and verifies the background with the created Scaler.
     */
    public boolean createScaler() {

        log(Level.none, b(c(CREATING), c(UI), c(SCALER), DOTS), true);
        scaler = new Scaler();
        if (scaler.isOk()) {
            final String name = d(s(scaler.getCurrent().getNumerator()), s(scaler.getCurrent().getDenominator()));
            bv("ROOT", name, null, scaler.getImage(), S0);
        }
        return scaler.isOk();
    }

    public int currentDepth() {

        return currentScenariosStack.size();
    }

    public _Scenario currentScenario() {

        return currentScenariosStack.isEmpty() ? null : currentScenariosStack.peek();
    }

    public boolean dataContainsKey(final Object field) {

        return dataStorage.containsKey(field);
    }

    public Object dataGet(final Object field) {

        return dataStorage.get(field);
    }

    public Object dataGetOrDefault(final Object field, final Object def) {

        return dataStorage.getOrDefault(field, def);
    }

    public Object dataPut(final Object field, final Object value) {

        return dataStorage.put(field, value);
    }

    public boolean dataRemove(final Object field) {

        final Object before = dataStorage.remove(field);
        return (isNotNull(before) && null == dataStorage.get(field));
    }

    public boolean dataRemoveValue(final Object value) {

        final Object keyToDelete;
        for (final Map.Entry<Object, Object> entry : dataStorage.entrySet())
            if (entry.getValue().equals(value)) {
                keyToDelete = entry.getKey();
                dataStorage.remove(keyToDelete);
                return true;
            }
        return false;
    }

    public Fraction getCurrentScale() {

        return null != scaler.getCurrent() ? scaler.getCurrent() : Fraction.ZERO;
    }

    public String getCurrentScenario(final boolean clearStack) {

        if (currentScenariosStack.isEmpty()) {
            logDebug(b(SCENARIOS_STACK, s(EMPTY, _DOT_), c(NO), FAILURES), true);
            return null;
        } else {
            logDebug(b(SCENARIOS_STACK, (currentScenariosStack.toString()).replace(Scenario.root, StringUtils.EMPTY)), true);
            String s = null;
            if (isNotNull(currentScenariosStack.peek())) {
                s = currentScenariosStack.peek().getShortName();
            }
            if (clearStack) currentScenariosStack.clear();
            return s;
        }
    }

    public String getDataSnapshot(final String comments) {

        String s = null;
        try (final StringWriter stringWriter = new StringWriter()) {
            dataStorage.store(stringWriter, comments);
            s = stringWriter.toString();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public _DataStorage getDataStorage() {

        return dataStorage;
    }

    public Set<String> getKnownIssue(final String p) {

        final Set<String> ki = new HashSet<>(0);
        Layout.Files.knownIssues.forEach(new Ki(p, ki));
        return ki;
    }

    /**
     * List of Known Issues
     *
     * @return New Issues collection
     */
    public Collection<String> getKnownIssues() {

        return knownIssues;
    }

    /**
     * This information is shared between Scenarios
     *
     * @return minimal depth
     */
    public Integer getMinDepth() {

        return minDepth;
    }

    /**
     * @param minDepth minimal depth (?)
     */
    public void setMinDepth(final Integer minDepth) {

        this.minDepth = minDepth;
    }

    @Override
    public List<_LogRecord> getNewIssuesCopy() {

        return new ArrayList<>(newIssues);
    }

    /**
     * @return A1 Set of strings representing the not reproduced issues.
     */
    public Set<String> getNotReproduced() {

        return notReproduced;
    }

    /**
     * Retrieves the Scaler instance.
     *
     * @return The Scaler object.
     */
    @SuppressWarnings("PublicMethodNotExposedInInterface")
    public _Scaler getScaler() {

        return scaler;
    }

    public String getStatus() {

        return core.getStatus();
    }

    /**
     * @return The WebDriver instance.
     */
    public WebDriver getWebDriver() {

        try {
            if (isNotNull(wd)) wd.manage().logs().getAvailableLogTypes();
        } catch (final WebDriverException e) {
            еггог(b(WEB_DRIVER, INACCESSIBLE, DUE_TO, q(e.getMessage())));
        }
        return wd;

    }

    /**
     * Instance of {@link WebDriverWait}
     *
     * @return wdw instance
     */
    public WebDriverWait getWebDriverWait() {

        return wdw;
    }

    /**
     * @return debug state
     */
    public boolean isDebug() {

        if (isNotNull(core.getDashboard())) isDebug = core.getDashboard().isDebug();
        if (isNull(isDebug)) isDebug = Debug.debug;
        return n(false, isDebug);
    }

    /**
     * @return trace state
     */
    public boolean isTrace() {

        return Debug.trace;
    }

    public boolean noNewIssues() {

        return newIssues.isEmpty();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public void popScenario(final _Scenario scenario) throws SafeguardException {

        final _Scenario[] currentArray = currentScenariosStack.toArray(new _Scenario[1]);
        if (isNotNull(scenario)) {
            if (isNotNull(currentArray[0])) {
                assertEqualsSilent(currentArray[0].getName(), scenario.getName(), b(c(UNEXPECTED), SCENARIO));
                core.getTest().repeater().addToHistory(scenario);
                currentScenariosStack.pop();
            } else {
                // exec.logEvent(S2, b(c(NO), SCENARIOS, IN, STACK));
            }
        }
    }

    public void pushScenario(final _Scenario scenario) {

        currentScenariosStack.push(scenario);
        core.getTest().repeater().addToScenarios(scenario);
    }

    /**
     * Retrieves the instance of the AppiumDriverLocalService.
     *
     * @return The AppiumDriverLocalService instance.
     */
    public AppiumDriverLocalService service() {

        return service;
    }

    /**
     * Configures the driver for executing the automation.
     *
     * @return The desired capabilities for the driver.
     * @throws IllegalArgumentException if unable to load the app from the specified file path.
     */
    @SuppressWarnings({"DataFlowIssue", "AccessOfSystemProperties", "ThrowInsideCatchBlockWhichIgnoresCaughtException"})
    private DesiredCapabilities configureAndroidDriver() {

        log(Level.none, b(c(CONFIGURING), c(DRIVER), DOTS), true);

        File app = null;
        final String apk = _APP.get();

        if (!apk.isEmpty()) {
            final File appDir = new File(System.getProperty(USER_DIR));
            try {
                app = new File(appDir.getCanonicalPath(), _APP.get());
            } catch (final IOException e) {
                throw new IllegalArgumentException(b(UNABLE_TO_LOAD, APP, FROM, q(app.toString())));
            }
        }
        return getDesiredCapabilities(app);
    }

    /**
     * Retrieves and configures the desired capabilities for the Appium driver.
     * This method sets the automation name and invokes additional configuration
     * methods to define the application and device settings.
     *
     * @param app The File object representing the mobile application file (.apk or .ipa).
     *            If null, the application is configured using the bundle ID.
     * @return M DesiredCapabilities instance containing the configured capabilities
     * for the Appium driver.
     */
    private static DesiredCapabilities getDesiredCapabilities(final File app) {

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(APPIUM_AUTOMATION_NAME, UI_AUTOMATOR_2);
        defineApplication(app, capabilities);
        defineDevice(capabilities);
        return capabilities;
    }

    /**
     * Configures the device-related capability for Appium by setting the UDID.
     * If a UDID is available, it sets the corresponding Appium capability.
     *
     * @param capabilities The DesiredCapabilities instance to configure device settings.
     */
    private static void defineDevice(final DesiredCapabilities capabilities) {

        final String udid = _UD_ID.get();
        if (!udid.isEmpty()) capabilities.setCapability(APPIUM_UDID, udid);
    }

    /**
     * Configures the application capability for automation.
     * If the `app` parameter is null, it uses the bundle ID to set the Appium package and activity capabilities.
     * If the `app` parameter is not null, it sets the capability using the absolute path of the provided app file.
     *
     * @param app          The File object representing the mobile application file (.apk or .ipa).
     *                     If null, the application is configured using the bundle ID.
     * @param capabilities The DesiredCapabilities object to which the application configuration will be set.
     * @throws IllegalArgumentException if the `app` parameter is null and no valid bundle ID is present.
     */
    private static void defineApplication(final File app, final DesiredCapabilities capabilities) {

        if (isNull(app)) {
            final String bid = _BUNDLE_ID.get();
            if (bid.isEmpty()) throw new IllegalArgumentException(b(UNABLE_TO_START_TEST___));
            capabilities.setCapability(APPIUM_APP_PACKAGE, bid);
            capabilities.setCapability(APPIUM_APP_ACTIVITY, s(bid, _DOT_, MAIN_ACTIVITY));
            capabilities.setCapability(APPIUM_NO_RESET, true);
        } else capabilities.setCapability(APP, app.getAbsolutePath());
    }

    /**
     * Creates additional components for the execution.
     * These components include web driver parameters, web driver wait, and a set of not reproduced issues.
     */
    @SuppressWarnings("unchecked")
    private void createAdditional() {

        if (isNotNull(wd)) {
            // Web driver parameters
            wd.manage().timeouts().implicitlyWait(Duration.ofMillis(Waits.implicit));
            wdw = new WebDriverWait(wd, Duration.ofSeconds(Waits.explicit));
            // That's one dirty trick :)
            notReproduced = new HashSet<>((Collection<String>) (Set<?>) Layout.Files.knownIssues.keySet());
        }
    }

    /**
     * Creates a bot.
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void createBot() {

        if (core.isInJar()) log(Level.none, ansi(b(c(RUNNING), FROM, JAR, FILE), MAGENTA_BOLD_BRIGHT), false);
        log(Level.none, b(c(READING), c(KNOWN), c(ISSUES), DOTS), true);
        knownIssues.isEmpty();
        log(Level.none, b(c(CREATING), c(TEST), c(DATA), c(STORAGE), DOTS), true);
        dataStorage = new DataStorage();
    }

    /**
     * Creates a service for executing automation.
     * This method initialises the AppiumDriverLocalService with necessary configurations.
     */
    private void createService() {

        log(Level.none, b(c(CREATING), c(APPIUM), c(SERVICE), DOTS), true);
        if (Debug.adebug)
            service =
                    new AppiumServiceBuilder().withArgument(() -> __BASE_PATH, WD_HUB).withLogFile(new File(APPIUM_LOG)).build();
        else
            service = new AppiumServiceBuilder().withArgument(() -> __BASE_PATH, WD_HUB).withArgument(() -> s(_DASH_, _DASH_
                    , LOG, _DASH_, LEVEL), WARN).withLogFile(new File(APPIUM_LOG)).build();

    }

    /**
     * Starts the Android driver and configures the desired capabilities.
     */
    private void startAndroid() {

        createService();
        startService();
        startAndroidDriver(configureAndroidDriver());
    }

    /**
     * Starts the Android driver and configures the desired capabilities.
     *
     * @param capabilities The desired capabilities for the Android driver.
     */
    @SuppressWarnings("resource")
    private void startAndroidDriver(final DesiredCapabilities capabilities) {

        log(Level.none, b(c(CREATING), c(ANDROID), c(DRIVER), DOTS), true);
        try {
            wd = new AndroidDriver(service().getUrl(), capabilities);
        } catch (final SessionNotCreatedException e) {
            e.printStackTrace();
            fail(b(UNABLE_TO, INSTANTIATE, c(APPIUM), c(DRIVER)));
        }
    }

    /**
     * Starts the browser and maximises the window.
     */
    private void startBrowser() {

        log(Level.none, b(c(CREATING), s(c(WEB), c(DRIVER)), DOTS), true);
        wd = WebDrivers.get(Platform.get(Routines.get_Platform()), false);

        log(Level.none, b(c(REARRANGING), BROWSER, WINDOW, DOTS), false);
        wd.manage().window().setPosition(new Point(0, 0));
        wd.manage().window().maximize();
    }

    /**
     * Starts the service for executing automation.
     * This method initialises the AppiumDriverLocalService with necessary configurations.
     */
    @SuppressWarnings("resource")
    private void startService() {

        log(Level.none, b(c(STARTING), c(APPIUM), c(SERVICE), DOTS), true);
        service().start();
    }

    @SuppressWarnings("StandardVariableNames")
    private class Ki implements BiConsumer<Object, Object> {

        private final String p;
        private final Set<? super String> ki;

        Ki(final String p, final Set<? super String> ki) {

            this.p = p;
            this.ki = ki;
        }

        @Override
        public final void accept(final Object k, final Object v) {

            if (p.contains((CharSequence) v)) {
                ki.add((String) k);
                if (notReproduced.contains(k)) {
                    notReproduced.remove(k);
                    knownIssues.add((String) k);
                }
            }
        }
    }
}
