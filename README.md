# WebDriver Bot PoC repository

Universal Bot for Exploratory testing based on Appium Driver

## Software prerequisites

To develop and execute the Bot, the following additional software is required:

| Software                            | for Development | For Execution   | Comments                                                  |
|-------------------------------------|-----------------|-----------------|-----------------------------------------------------------|
| Java JDK 17+                        | JDK required    | JDK is optional | possible to used JRE only                                 |
| Maven                               | required        | optional        | possible to use prebuilt jar                              |       
| Any IDE                             | required        | optional        | some text files modification required for tests execution |
| Android SDK                         | required        | optional        |                                                           |
| Android Studio                      | optional        | optional        | managing of virtual devices could be done through CLI     |
| Node.js                             | required        | required        | non-optional components for interaction with Android OS   |
| Node.js, Appium, Uiautomator driver | required        | required        | non-optional components for interaction with Android OS   |

## What is Bot and how it works

### Overview ###

The Bot is a native Java application with several logical layers which allow Android application to be tested:

1. **Java application** performs all business logic of the Bot
2. **Webdriver API** is used for sending requests and receiving responses from tested application
3. **Appium Driver** implements Webdriver API for Android application testing
4. **Appium Service** performs actual interactions with provided Android OS, either virtual of physical
5. **Node.js** is a software prerequisite for Appium

Bot works by performing randomly generated **Tests**:

1. **Scenarios** are implemented as independent minimalistic java classes.
2. Each random **Test** is a dynamically created sequence of one or many **Scenarios**.
3. **Tests** are executed consequently one after another in the scope of **Session**.

Each **Test Session** can stop in either a success or failure mode.  
There are several possible scenarios for both types of closure:

### **Possible Causes of Successful Completion:**

1. The configured **Number of Tests** is performed successfully.
2. Test execution is **stopped programmatically** by one of the **Scenarios**.
3. It is impossible to generate a new **Test** (i.e., no sequential **Scenario** can be selected among those available).

### **Causes of Failed Test Execution:**

1. An **unhandled exception** occurs in the underlying code.
2. An **Event** created programmatically with a Severity level high enough to indicate failure.
3. An external **technical issue** arises with either the Appium Service or the tested Application.

The project's `Specifics.java` class extends `works.lysenko.tree.base.Exceptional.java` class and used for the handling of exceptional
situations.  
It allows implementing workarounds to address known issues of the tested application.
However, the use of such measures should be limited during the later stages of application development, as the presence of workarounds indicates
unresolved issues.
The base `Exceptional.java` class provides functionality to handle basic universal exceptional situations.

## Main Bot Components

| Name                           | Description                 | Spawned by | Goal                                                 |
|--------------------------------|-----------------------------|------------|------------------------------------------------------|
| {app}.Run.java                 | Startup Java class          | -          | Configure and Launch the test                        |
| .base.Test.java                | **Test Cycles** manager     | Run        | Perform one or more **Test Cycles**                  |
| .base.Exec.java                | Test Execution manager      | Test       | Control over test execution scope                    |
| .base.Core.java                | Bot Core                    | Exec       | Initial and low-level operations                     |
| .base.DataStorage.java         | Shared Test Data Storage    | Exec       | Provide shared data for whole Test Session           |
| .base.Scaler.java              | Resolution handler          | Exec       | Support different screen proportions and resolutions |
| .base.core.Logs.java           | Log manager                 | Core       | Write test logs to files and terminal                |
| .base.core.Parameters.java     | **Test Parameters** manager | Core       | Handle **Test Parameters**                           |
| .base.core.Results.java        | **Test Results** manager    | Core       | Handle **Test Results**                              |
| .base.core.Stopwatch.java      | Time manager                | Core       | Test-scope local time measurements                   |
| .base.core.TestProperties.java | **Test Properties** manager | Core       | Handle **Test Properties**                           |
| .base.ui.Directory.java        | File-based user interface   | Core       | Control of Test Session of file operations           |
| .base.ui.UserInterface.java    | GUI user interface          | Core       | Provide Dialogue box for test session control        |

### Detailed Descriptions

- **Run.java** The entry point of the Bot, responsible for starting and managing the Bot's execution.

- **Core.java** Encapsulates all low-level Bot components. This logic was extracted from the `Execution` class to reduce complexity and improve
  maintainability.

- **Test.java** Acts as the "heart" of the Bot, responsible for the cyclic generation and execution of **Test Cases** — essentially managing the
  core
  functionality of the testing process.

- **Exec.java** Represents the "muscles" of the Bot, responsible for all runtime operations at the test execution level.

- **Logs.java** A specialised lightweight logging tool with functions designed to facilitate processing, analysis, and debugging of test
  executions.

- **Parameters.java** Manages the pre-startup Bot configuration by handling **Test Parameters**.

- **TestProperties.java** Processes `test.properties` files, which serve as **Test Suites** (in common testing terminology).

### Configurable customization classes

The following classes are configurable by `works.lysenko.util.data.records.test.Workflow` record and intended to be implemented together with
test Scenarios

| Name        | Description                   | Spawned by | Goal                                           |
|-------------|-------------------------------|------------|------------------------------------------------|
| exceptional | Handler of Exceptional states | Cycles     | Process avoidable Bot terminations             |
| preflight   | Operations before test run    | Cycles     | Handle test execution prerequisites            |
| status      | Current text status info      | Cycles     | Generate short text status about current state |
| postflight  | Operations after test run     | Cycles     | Perform after-test operations                  |

- **Exceptional.java**
  The `exceptional` class is responsible for handling exceptional states during the Bot's execution.
  This includes processing avoidable Bot terminations caused by unexpected issues.
  It provides mechanisms to resolve specific known problems (e.g. misclicks or sudden logouts) by logging events and executing recovery actions
  without terminating the Bot.

- **Preflight.java**
  The `preflight` class ensures that all necessary prerequisites are met before the execution of a test run.
  It performs actions like validating expectations, preparing configurations, calculating metrics (e.g. maximum polychromies),
  verifying undefined elements, and managing user selection.

- **Status.java**
  The `status` class generates concise textual information about the current state of the Bot.
  It provides status details like test progress, user-specific completions, or unresolved configurations.
  This class avoids excessive log output to prevent stack overflow issues and ensures clear, actionable updates throughout test execution.

- **Postflight.java**
  The `postflight` class performs operations needed after a test run completes. This includes:
  Logging test progression and results.
  Consolidating status data from executed tests (summaries, for example).
  Writing results to files and visualising outputs for users via the console.
  It ensures that any post-test clean-up actions and reporting requirements are completed.

### Dashboard Overview

The **Dashboard** serves as a central control hub for managing test execution, providing users with two interface options:

1. **Directory.java**
   A directory- and file-based interface primarily used during headless Bot operations. The project’s `/target/dash` directory serves as the UI
   substitute. For instance:
    - To activate debug mode, create a file named `debug` in this directory.
    - To deactivate debug mode, simply delete the file.

2. **UserInterface.java**
   A dialog box-based interface designed for local Bot executions, providing a more interactive and intuitive experience. Each of the four
   dashboard functions (Debug, Pause, Halt, Stop) is represented as a dedicated toggle button in the interface.

### Operations

The **Dashboard** offers real-time insights into test execution status and includes four essential operations:

1. **Debug** enables verbose debug logging, providing detailed output for troubleshooting and analysis.
2. **Pause** temporarily suspends test execution, allowing users to resume from the same point at a later time.
3. **Halt** puts the current **Test Case** into a halt state, allowing the **Test Scenario** to finish execution. However, the selection of the
   next
   Scenario will be skipped until this feature is toggled off. The next cycle will only begin once the halt mode is deactivated.
4. **Stop** ensures that the current **Test Case** finishes its execution as usual, but prevents the initiation of the next **Test Cycle**. This
   provides
   a clean exit from the current testing phase.

### Summary

The **Dashboard** provides versatile control over test execution in both headless and interactive modes, ensuring flexibility and adaptability
for different testing environments. Its core functionalities—debugging, pausing, halting, and stopping—offer developers fine-grained control
over test scenarios and cycles.

---

## Required and Optional Configurations

The Bot offers multiple ways to configure and control its behavior, categorized as either **required** or **optional**:

| **Name**                | **Type** | **Form**                                               | **Used for**           | **Goal**                              |
|-------------------------|----------|--------------------------------------------------------|------------------------|---------------------------------------|
| **Configuration**       | Required | Files in the `./etc` directory                         | One-time configuration | Provide test environment information  |
| **Test Parameters**     | Required | Environment variables or user input                    | Per-run configuration  | Specify test run options              |
| **Test Properties**     | Required | `.properties` files in `./src/main/resources`          | Common configuration   | Define shared test property values    |
|                         | Required | `.test` files in `./src/main/resources/tests`          | Test run configuration | Specify exact test actions to perform |
| **Validation Matrices** | Optional | `.properties` files in `./src/main/resources/matrices` | Image validation       | Enable feature for image analysis     |

- **Required Configurations**: These include files or parameters necessary to define the environment and test behavior (e.g., specifying
  environment details, shared properties, and test actions).
- **Optional Configurations**: Validation matrices provide additional capabilities, like analyzing images in test runs, but are not mandatory
  for Bot execution.

### Test Environments Configuration

From an organisational perspective:

1. Each **Test Environment** must have at least one dedicated **Pool of User Accounts**.
2. **Pools of User Accounts** must not be shared between test environments.
3. Multiple Pools can be defined for a single test environment, if necessary.

---

### Test Parameters ##

There are the following **Test Parameters**:

| Name     | Meaning                         | Default value |
|----------|---------------------------------|---------------|
| CI       | CI environment?                 | true          |
| TEST     | Name of **Test Configuration**  | empty         |
| DEVICE   | not used in this implementation |               |
| DOMAIN   | not used in this implementation |               |
| PLATFORM | Only "Android" is applicable    | Android       |
| POOL     | Pool of User Accounts to use    | Android       |

**Test Parameters** can be defined in different ways:

1. As value of Environment Variable
2. As answer from User in **Test Parameters** dialogue (except for CI Test Parameter)
3. As stored current value in /var/parameters file

### Special nature of CI Test Parameter ###

Setting of **CI** environment variable should be defined (to any non-empty value) to switch the Bot to remote/headless execution mode.

If the Bot is started in **CI mode**, **Test Parameters** dialogue box is not displayed and **Test Parameters** values are taken from either
Environment Variables or from /var/properties file.

If the Bot is not in **CI mode**, **Test Parameters** can be redefined interactively before each test run.

Name of **Test Configuration** corresponds to the **Test Data Storage** property file name in the *./src/test/resources/tests* directory. For
local executions, these parameters can be omitted and defined interactively.

---

### Test Configurations and Properties ##

Collection of **Test Properties** is **Test Configuration** which in turn can be treated as analogue of **Test Suite**.

By default, a single **Test Configuration** is selected for each Test run, but there is also a possibility to have special cases like **
Regression
**.

**Test Configurations** are defined as in *./src/main/resources/tests* directory. These are standard Java property files with two types of
records:

* **.parameter = value** are several **Test Parameters** explained below
* **scenario.name = x.x** where a weight coefficient value defines the chance of a particular scenario to be executed.

All omitted scenarios considered having zero chances of being selected for execution initially.
However, it is not required to tove every scenario mentioned in this configuration file in order for them to be executed.
It is possible to configure weight coefficients propagation in one of two directions or in both.

A Scenario can be marked as the one to skip by putting the Minus (dash) symbol as its weight.
Also, weight coefficients can be defined as Integer, Float or a Fraction number (fraction), for example:

    a.A=0
    a.B=1
    a.b.C=1/3
    a.b.D=2/3
    a.b.E=-

A common configuration is stored in *src/main/resources/common.configuration.properties* file, along with additional information on each test
configuration property.

Additionally, there is a possibility to "import" sets of properties using _include property.:

    .include=parts/common,parts/project,parts/{project.name}

This helps to better organise settings as well as reduce clutter.

To control which configuration parameters are used, each execution starts with output of config summary. It consists of two parts:

### Applied Test Configuration

This section displays all applied configuration parameters along with their respective values. The following rules apply to parameter
visualization:

1. If a configuration parameter is **unrecognized**, it is marked in **red**.
    - This likely indicates a typo or an invalid parameter name.

2. If a configuration parameter has `null` as its **default value**, its assignment is highlighted with a **green equals sign (`=`)** to draw
   attention.
3. If a configuration parameter is redefined with its **default value**, it is shown as **"default white"**, and test execution is automatically
   blocked.

### Unchanged Test Properties with Default Values

This section lists all configuration parameters that retain their **default values** and have not been modified.

### Configuration validation ###

All in all, **Test Properties** define what exactly the Bot will do.
To minimize possible confusion and incorrect test results, in case any discrepancy test execution is halted.

### Important parameters ###

There are some details about several important test properties:

#### .root ####

Name of package which contains the root of test nodes' hierarchy.
Test Scenarios are referenced in **Test Properties** file relatively to this package.

#### .include ####

Read properties from an external file

    .include=parts/common,parts/project,parts/{application.name}

Comma separated values are names of property files with ".part" extension.

#### .include.upstream and .include.downstream ####

For example, to execute a single scenario, use this **Test Properties**:

    .include.upstream = true
    {some.scenario}=1.0

That gives 1.0 weight coefficient to a particular scenario and activates upstream weight propagation,
which sets the same weight to parents of this particular scenario.
That allows skipping the exact definition of weights for each of parent scenarios.

To execute a subset (subtree) of scenarios, use the following:

    .include_downstream = true
    {some.scenario}=1.0

Setting of *_include_downstream = true* allows all child Scenarios to be executed with the same weight coefficient.

#### .tests ####

The `.tests` property defines the number of **Test Executions** to be performed and can be adjusted to support different testing scenarios:

- **Low Number of Tests**: Suitable for minimal acceptance testing, ensuring core functionality is working as expected.
- **Medium Number of Tests**: Ideal for regression testing to verify that recent changes haven't affected existing functionality.
- **High Number of Tests**: Used for stability testing under extended conditions, ensuring the system can handle prolonged operations without
  failures.
  This flexibility allows **multiple types of testing** to be performed using the same code base. As a result, it minimizes the need for
  additional maintenance and reduces tooling variations, streamlining the testing process.

#### .stop ####

This is the example of custom test parameter used by **de.medice.abstracts.willkommen.anmelden.auth.wiss.Plan**
class to define whether to stop test execution after reaching 100% of Trainingsplan reading or not.

#### .persist ####

This boolean parameter defines whether to persist **Test Data Storage** information between test executions. Should be kept "true"

#### .debug ####

Activating this feature results in more detailed logs, facilitating test development and analysis of outcomes. Alternatively, deactivating debug
output streamlines the test log by reducing excess information and size.

For complete list of available test configuration parameters, refer to two enums: interlink.util.spec.PropEnum for application-specific and
works.lysenko.util.spec.PropEnum for common technical parameters
Additionally,

### Regression test configuration ###

The *Regression.test* denotes a specialised testing setup that triggers extra functionalities within Preflight.java.
Rather than adding another layer of abstraction, this setup is used for dynamically determining the **Test Configuration**
selection based on the currently available test data.

This specific **Test Configuration** introduces several additional parameters within the *common.configuration.properties* file:

- **_regression.test.before.completion.primary=ReadThrough:** Specifies the **Test Configuration** to be used at the beginning of testing (with
  fresh test accounts after reset).
- **_regression.test.before.completion.secondary.chance=0.25:** Determines the probability (in this case 25%) of alternative Test Configuration
  selection before reaching of 100% of Trainingsplan reading progress.
- **_regression.test.before.completion.secondary=AllButSearch:** Defines the name of that alternative **Test Configuration**.
- **_regression.test.after.completion=AllButSearch:** Configures **Test Configuration** to be used for consequent tests after reaching the end
  of
  Trainingsplan.

---

## Testing environment ##

### Running Android OS instance ###

The Last step to perform before actual test execution is to provide accessible running Android OS. There are two possible ways for that:

1. Connect a physical device in debug mode to a workstation
2. Start emulator on the same host

*./emulator.bash* script contains all required simulation parameters.
Before using it, update *./etc/device* file with the actual name of an
emulated device to use.

### Test Data Storage ###

Is case of **_persist** set to **true**, The Bot uses file-based storage for saving information about the expected system state.
These are plain Java property files, with name reflecting associated users pools, for example *./var/hetzner-remote.properties*

### Preparing/maintaining Users Pool ###

For effective testing, there should be a way to reset user accounts to their initial "empty" state.
See *./reset-environment-local.bash* for examples.
After resetting a pool, its correspondent **Test Data Storage** properties file must also be deleted from *./var* directory (
*./var/development-local.data.properties*, for example).

So, the very first execution must be done with clean user accounts and empty/absent **Test Data Storage** file.

---

## Execution of the test ##

There are three modes of Test Bot execution:

1. Starting of **./src/main/{app}/Run.java** by IDE
2. Starting **./run.maven.bash** which will build Bot from sources and then start through Maven as a regular application
3. Starting **./run.shade.bash** will build Bot, create shade jar with all dependencies, and then start the Bot

### Testing process overview ###

Each Test Run "physically" is an execution of **./src/main/{app}/Run.java** as a regular Java application.
The Sole task of Run.java is configuring and starting of **Exec** framework component:
Additionally, to Test Scenarios, there are four optional classes (defined as parameters of Cycles) with specific tasks and functions:

1. preflightClass,
2. statusClass,
3. exceptionalClass,
4. postflightClass.

#### Test Cycle(s) Overview ####

In simple terms, each test cycle consists of several stages:

* defining the root set of scenarios for execution (done by *Cycles.execute()*)
* performing the selection (based on the weight coefficients defined in the **Test Properties** file or during runtime) of one of the scenarios
  from
  this group

In turn, the selection of a scenario from a set (done by Ctrl.execute()) is a sequence of:

1. Creating the list of execution candidates
2. Algorithmic selection of a candidate (based on weight coefficients)
3. Verification of prerequisites (by execution of fits() method) for a preselected candidate. If prerequisites are not met, a preselected
   candidate is rejected, removed from a list of candidates, and mathematical selection (step 2) performed again. If fits() method returns *
   *true** (prerequisites are satisfied), then a selected scenario is executed.
4. Step 2 and step 3 kept being repeated until one of three happens: (1) Mathematically selected scenario meets
   prerequisites, or (2) maximum number of retries exhausted (defined by **_default.scenario.fitting.retries** Test Property),
   or (3) list of candidates become empty. By default, all mentioned states are not exceptional, but it can be changed
   through **Test Properties** modification

After selecting a Scenario, there are three main possibilities:

1. The selected scenario is **Node** Scenario (Node has nested scenarios, one of which will be selected for further execution)
2. The selected scenario is **Leaf** Scenario (Leaf has no nested ones, and the execution of a cycle is complete after its selection and
   execution)
3. The selected scenario is **Mono** Scenario (Special case of a Leaf scenario, which is only allowed to be executed once)

Execution of a Node Scenario (see works.lysenko.tree.base.Node.java) is:

1. super.execute(): execution of common Base.execute() (technical stuff like writing title in log, renewing current scenario references, etc.)
2. action(): performing Scenario Actions (for example - selection of 'Solutions' from navigation bar)
3. scenarios.execute(): selecting a nested scenario from a set, same as described above
4. finals(): final actions for a scenario
5. done(): technical finalization of scenario

Execution of a Leaf scenario (see works.lysenko.tree.base.Leaf.java) is:

1. super.execute(): execution AbstractScenario.execute() (see above)
2. action(): performing Scenario Actions (for example - deletion of a Solution)
3. finals(): final actions for a scenario
4. done(): technical finalization of scenario

Execution of a Mono scenario (see works.lysenko.tree.base.Leaf.java) is generally similar to Leaf one, but it could be executed
only once per test scenario.
This type of test node is intended to be used for testing simple actions like pressing Cancel button in forms.

#### Test Cycle(s) Repetition ####

Normally, each test run will contain a particular amount of **Test Cycles** defined by .cycles Test Property.

Programmatically, it is also possible to stop Cycles from repeating further by calling stopCycles() method.
This is used for stopping tests right after reaching some condition, like - reading odf 100% of the Trainingsplan.

Finally, by using Stop function of **Dashboard**, it is possible to forbid starting of a new Test Cycle and stop the Bot after completion of the
current one.

---

## Scenarios tree/graph ##

Scenarios are structured as a tree with the ability to induce some graph-type relations.
At the root of this tree is a set of level-1 Elements which used by Cycles class for initiation of each consequent test execution.
All elements could be of any type, but only **Node** scenarios are used for linking with next-level scenarios.

There are several ways of further scenarios definition for a Node:

1. Putting later scenarios into a package with a name similar to the classname of a Node (lowercase one)
2. Defining the following scenarios in the constructor
3. Using setScenarios() method

In the current implementation, test examples, and result visualisation, most scenarios are organised as tree structure.
There is also an example of dynamic selection in **willkommen.anmelden.auth.home.ReadNext** scenario (and other uses of Node::setScenarios).

Each test cycle comprises the execution of multiple Node scenarios, built randomly, and a single Leaf Scenario that concludes the test. This
execution is determined by weighted selection and prerequisite analysis.

Node 'Login' >> Node 'Elements' >> Node 'Edit' >> Leaf 'Delete'

Each scenario, either of Node, Leaf, or Mono type, can have or not have any Actions associated with it. (However, while it is possible to imagine
a Node scenario which was created only for taxonomy reasons and therefore there are no actions in it, it is rather illogical to have a Leaf
scenario without any Actions.)

---

## Scenario Prerequisites ##

Due to the random nature of Bot activities, there is nothing which embodies "Prerequisites" exactly.
Prerequisite for each Test Cycle is a whole set of actions performed on a particular User Account by previously executed tests.

Consequently, there is no sense/way to define prerequisites for any Test Scenario. Instead, each scenario should redefine Boolean fits() method.
Withing this method, a test scenario must analyse the contents of UI and/or **Test Data Storage** data to indicate whether a node is capable
of execution or not. All scenarios are not fit by default.

---

## Images Validation ##

Any UI part can be additionally verified by applying parametric validation.
It means that there is no need to collect, store, and update a huge set of binary images.
Instead, requirements are formulated as key/value pairs.
Based on these values, sampling and validation of image is performed.

| Property                  | Type           | Sample values     | Description                                                                            |
|---------------------------|----------------|-------------------|----------------------------------------------------------------------------------------|
| horizontal                | Fraction       | 1/2, 3/5          | Relative horizontal positioning of the sampling grid with respect to the entire screen |
| vertical                  | Fraction       | 1/3, 6/7          | Relative vertical positioning of the sampling grid with respect to the entire screen   |
| scale                     | Fraction       | 1, 1/10, 19/10    | Sampling grid size relative to the smaller screen dimension                            |
| resolution                | W*H or Integer | 10*10, 99*199, 25 | Properties defining width and height of grid elements (sampling points)                |
| palette                   |                |                   |                                                                                        |
| colours                   | List of Ranges | see below         | Specifications of the expected color ranges                                            |
| colours.border            | Fraction       | 1/99, 1/437       | Frequency threshold for colours to be considered in analysis                           |
| colours.ignore.hue        | Fraction range | 5/9:¹¹⁄₁₈         | Range of hues to be excluded from analysis                                             |
| colours.ignore.saturation | Fraction range | 5/9:¹¹⁄₁₈         | Range of saturation to be excluded from analysis                                       |
| colours.ignore.brightness | Fraction range | 5/9:¹¹⁄₁₈         | Range of brightness to be excluded from analysis                                       |
| colours.ignore            | String         | order             | No strict order required between expected and actual color ranges                      |
| colours.amount            | Integer range  | 3-, 6+, 5, 1:4    | Predefined range or direct count of expected colors                                    |
| polychromy                | Fraction       | ³⁄₇₁              | Measure of picture's color richness                                                    |
| polychromy.method         | Code           | 1                 | Code identifier for the method used to calculate polychromy                            |
| hue                       | List of Ranges |                   | Equally binned sections of hue 0.0 .. 1.0 values                                       |
| hue.fences                | Integer        |                   | Amount of dividers of hue range                                                        | 
| saturation                | List of Ranges |                   | Equally binned sections of saturation 0.0 .. 1.0 values                                |
| saturation.fences         | Integer        |                   | Amount of dividers of saturation range                                                 | 
| brightness                | List of Ranges |                   | Equally binned sections of brightness 0.0 .. 1.0 values                                |
| brightness.fences         | Integer        |                   | Amount of dividers of brightness range                                                 | 

The **scale** and **resolution** define the size of the area defined for probing.
In order get higher-then-wide area, particularly to ge fullscreen probe on vertically aligned screen,
scale should be set to correspondent higher-then-1 value, and resolution should reflect verticality as well, fo example:

    scale=19/10
    resolutiion=99*199

The **colours** property defines expected colour distribution by *list of ranges*.
Each comma separated range in a list can be defined by one of the following ways:

    {value}:{min}:{max}, ...
    {value}:{max}:{min}, ...
    {value}:{min}+, ... (more then, short for {value}:{min}:1.0)
    {value}:{max}-, ... (less then, short for {value}:{max}:0.0)
    {value}:{exact}, ...  (very strict requirement)

**colours.border** is the minimal share of total samples for a colour to be considered in analysis.
Effectively, this is a noise / signal level configuration.

**colours.ignore.hue** **colours.ignore.saturation** and **colours.ignore.brightness** are additional ways to exclude subsets of colours from
assertion.

**colours.ignore=order** should only be used together with **colours.amount** to configure "loose" validation for cases where different colours
may and may not be present

**polychromy** parameter is for validation of colourful images. Tracking of hundreds of colours is impractical, therefore other approach is
used.
Polychromy is a fractional number which reflects how different are samples between themselves.
To calculate this, colours of samples are treated as 3d coordinates in space, and total distance between all elements is calculated.
Then, it is comparedd to maximum theoretically possible value, which in turn gives that Polychromy coefficient.

### Support of different resolutions ###

There is one screen resolution which is considered "native", and all values considered relevant to it.
Native resolution configured in _native.x.resolution and _native.y.resolution configuration parameters.
To verify other resolutions, which effectively means other screen proportions, grid parameters are to be suffixed with the proportion.
At the beginning of each run, there's that log line

    • Current UI resolution is 1200x2000, scale is ³⁄₅, native is ⁹⁄₁₉, compensation is ¹⁵⁄₁₉

It indicates current screen proportion, native one, and relation between them.
This is an example of defining specific value for non-native screen proportion:

    scale=8/9
    3/5.scale=294/390

It is also possible to add scale behind mail key, like:

    5-5-2-2.3/5=44,1,1,130,1,339,186,7

This allows to combine/sort keys in a way more suitable for each particular data file.

The following files support scaled properties:

1. Grid files in *src/main/resources/matrices*
2. Page Properties in *resources/expected/page*

Support of different resolutions with same proportions will be implemented later.

---

## Test Results / Test execution artefacts ##

All artefacts produced by test execution are stored in *./target/runs* directory in structured subdirectories, as follows:

| Path                                                               | Description                                                                                                         |
|--------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|
| {test-configuration}                                               | Directory with all results of different {test-configuration} executions                                             |
| {test-configuration}/{timestamp}                                   | Directory of singe test execution started at {timestamp}                                                            |
| .../{timestamp}/snapshots                                          | Directory of interface snapshots taken during test execution                                                        |
| .../.../.../{timestamp}.{cycle}.{test-time}.{name}.png             | Screenshot taken during {cycle} at {test-time} since starting of test                                               |
| .../.../.../{timestamp}.{cycle}.{test-time}.{name}.xml             | Page code snapshot taken during {cycle} at {test-time}                                                              |
| .../{timestamp}/data                                               | Directory of data snapshots taken during test execution                                                             |
| .../.../.../{timestamp}.{cycle}.{test-time}.{operation}.properties | Snapshot of **Test Data Storage** Data storage after {operation} changed System State during {cycle} at {test-time} |
| .../.../{timestamp}.cycles.html                                    | Summary of performed Cycles                                                                                         |
| .../.../{timestamp}.issues.notice.html                             | List of Events including NOTICES                                                                                    |
| .../.../{timestamp}.issues.warning.html                            | List of WARNINGS and other more severe Events                                                                       |
| .../.../{timestamp}.run.json                                       | Results of test execution in json format (not final/used)                                                           |
| .../.../{timestamp}.run.log                                        | Copy of console output - most verbose explanation of whatever was done during test execution                        |
| .../.../{timestamp}.run.svg                                        | "Graphical" illustration of test actions/results                                                                    |
| .../.../{timestamp}.scenarios.html                                 | Per-scenario summary of execution                                                                                   |
| .../.../{timestamp}.telemetry.log                                  | Bot telemetry file                                                                                                  |
| .../.../{timestamp}.trainingsplans.html                            | Summary of Trainingsplan progress for each user                                                                     |

**{test-configuration}** is the name of Test Suite selected by **TEST** parameter, which corresponds to **Test Properties** file in *
src/main/resources/tests directory.

**{timestamp}** is a per-test-execution value which indicated the moment of test text initialisation.

**{test-time}** is the number of milliseconds passed since starting of a test.
This value used in test logs and filenames of screenshots and snapshots,
which allows easy binding of test data to an exact moment of test execution.

**{cycle}** is the number of Test Cycles at which a snapshot was taken, so that it's easier to bind it to particular action done by Bot.

**{name}** of a snapshot is defined by test code.

**{operation}** reflects which Data modification triggered that particular Data snapshot.
Additionally, detailed description of modification added as comment to each file.

### .../{timestamp}/snapshots ###

There are two types of snapshots:

1. Plain screenshots to *.png* files. These screenshots could also be additionally modified by markings depicting Element or Action performed.
2. Pairs of *.png* and *.xml*. XML file is in turn a snapshot of object hierarchy at the moment of snapshotting.

### .../{timestamp}/snapshots ###

While making a snapshot of **Test Data Storage** after each modification could be very handy for tests development and results analysis, it
could
also create a massive amounts if big files during each test execution. To avoid that, set **_data.snapshots.allowed** parameter to *false*.

---

## Configuring Remote test execution server ##

It is recommended to use a dedicated hardware server running Ubuntu 22.04 LTS (or later) with Java 17 installed.
The following steps are required to configure a server (freshly installed OS is assumed):

| Shell command                                                                                                                                                                      | Description                                             |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------|
| apt update                                                                                                                                                                         |                                                         |
| apt upgrade                                                                                                                                                                        | Post-installation packages update                       |
| ./jenkins/install-jenkins.bash                                                                                                                                                     | Script with all commands to install Jenkins on a server |
| apt install certbot                                                                                                                                                                | Certbot for Let's Encrypt certificates                  |
| certbot certonly                                                                                                                                                                   | First issue of certificate for a server                 |
| cd /etc/letsencrypt/live/{your domain}                                                                                                                                             | Going to directory with certificates for your domain    |
| openssl pkcs12 -export -in fullchain.pem -inkey privkey.pem -out server.p12 -name tomcat                                                                                           | Assumed export password is "password"                   |
| keytool -importkeystore -deststorepass password -destkeypass password -destkeystore keystore.jks -srckeystore server.p12 -srcstoretype PKCS12 -srcstorepass password -alias tomcat | Generation of keystore.jks                              |
| mv keystore.jks /var/lib/jenkins/keystore.jks                                                                                                                                      | Moving keystore to Jenkins                              |
| sudo systemctl edit jenkins                                                                                                                                                        | Editing Jenkins configuration                           |

The following lines are to be added to Jenkins configuration:

~~~
[Service]
Environment="JENKINS_PORT=-1"
Environment="JENKINS_HTTPS_PORT={port}"
Environment="JENKINS_HTTPS_KEYSTORE=/var/lib/jenkins/keystore.jks"
Environment="JENKINS_HTTPS_KEYSTORE_PASSWORD=password"
~~~

It is recommended to use non-standard port in case of WAN usage.

| Shell command                                     | Description                                            |
|---------------------------------------------------|--------------------------------------------------------|
| sudo systemctl restart jenkins                    | Restart Jenkins with new configuration                 |
| cat /var/lib/jenkins/secrets/initialAdminPassword | to get one-time password for initialization of Jenkins |

After that, Jenkins is ready to be initialised by opening https://{your domain}:{port}/ url and following on-screen
instructions.
Next steps:

1. Copy ```jenkins/jobs/Bot/config.xml``` file from a Bot repository file to ```/var/lib/jenkins/jobs/Bot/config.xml```
2. Restart Jenkins by ```systemctl restart jenkins``` to let it pick up "Bot" job
3. Start "Bot" job once to let Jenkins create workspace for "Bot" job
4. Copy contents of Test Bot repository to ```/var/lib/jenkins/workspace/Bot```
5. target and var directories must be owned/modifiable by Jenkins:

~~~
cd /var/lib/jenkins/workspace/Bot
chown -R jenkins:jenkins target
chown -R jenkins:jenkins var
~~~

Job's workspace considered as Production copy of Bot, deployment could be automated further.

Next, Command Line Tools of Android SDK should be installed:

| Shell command                                                                           | Description                                                                                      |
|-----------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| mkdir -p /opt/sdk                                                                       | Default location for Android SDK installation                                                    |
| wget https://dl.google.com/android/repository/commandlinetools-linux-9477386_latest.zip | Check "Command line tools only" of https://developer.android.com/studio for more recent versions |
| unzip *.zip                                                                             |                                                                                                  |
| mkdir -p /opt/sdk/cmdline-tools/latest                                                  | location for unpacked Commandline Tools                                                          |
| cd /opt/sdk/cmdline-tools                                                               |                                                                                                  |
| mv bin latest; mv lib latest; mv source.properties latest; mv NOTICE.txt latest         | as per documentation of Commandline Tools                                                        |

Now, the following lines should be added to ```~/.bashrc``` file:

~~~
export ANDROID_HOME=/opt/sdk
export ANDROID_SDK_ROOT=$ANDROID_HOME
export PATH=$ANDROID_SDK_ROOT/emulator:$ANDROID_SDK_ROOT/tools:$ANDROID_SDK_ROOT/tools/bin:$ANDROID_SDK_ROOT/platform-tools:$ANDROID_SDK_ROOT/cmdline-tools/latest/bin:$PATH
~~~

After that, either reboot your server or re-login into another session to pick up introduced changes.

Finally, other required parts of Android SDK must be installed:

| Shell command                                                                               | Description                                   |
|---------------------------------------------------------------------------------------------|-----------------------------------------------|
| sdkmanager --install "build-tools;35.0.0"                                                   | Installation of Android SDK components        |
| sdkmanager --install "emulator"                                                             |                                               |
| sdkmanager --install "platform-tools"                                                       |                                               |
| sdkmanager --install "platforms;android-35"                                                 |                                               |
| sdkmanager "system-images;android-35;google_apis;arm64-v8a"                                 | Exact versions of packages could be different |
| avdmanager create avd -n avd35_25 -d 25 -k "system-images;android-35;google_apis;arm64-v8a" | creation of virtual device named "avd35_25"   |

Emulator should be started in dedicated shell which will stay active after interactive login session exit. To do that:

1. Execute ```screen``` command
2. Within the screen session, execute ```emulator -avd avd33_25 -no-audio -no-window```
3. Press Ctrl+A and Ctrl+D to detach from the screen

Emulator will be running within its own screen session. To reattach, execute ```screen -r``` command.

## Locators ##

It is possible to address elements of interface by direct CSS and XPath references. For better logs readability though,
additional layer of named locators was added. The file *./etc/descriptors* contains all named references used in test
nodes. It was expected to have space characters inside references, so a standard Java properties file format wasn't
applicable. Double equals sign *==* is used as separator between named reference and locator.

---

Sergii Lysenko
sergii@lysenko.works
©2022-2026