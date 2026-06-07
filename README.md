# OpenCart - UI automation framework
- A scalable UI test automation framework for an e-commerce platform built using Java, Selenium WebDriver, TestNG,
  Maven, Docker, and Selenium Grid

## Core Capabilities
- Cross operating-system / cross-browser testing
- Thread-safe parallel execution
- Local and remote execution support
- Selenium Grid execution using Docker
- Jenkins CI integration
- Data-driven testing with Excel
- ExtentReports reporting / Log4j2 logging
- XML-driven TestNG suite execution
- Screenshots on test failure

## Tools/Technologies Used
- Programming Language: `Java`
- Build Tool: `Maven`
- CI: `Jenkins`
- Containerization: `Docker`
- Remote Execution: `Selenium Grid`
- Parallel Execution: `TestNG`
- Reporting: `ExtentReports`
- Logging: `Log4j2`
- Data-Driven Testing: `Apache POI and Excel`
- Test Execution: `TestNG, Maven, and Selenium Grid`
- Configuration Management: `TestNG XML & .properties file`

## Framework Features
- Thread-safe parallel execution
- Cross-operating-system / cross-browser support
- Local and Remote execution environments
- Jenkins CI execution support
- Selenium Grid execution using Docker containers
- Data-driven testing with Excel integration
- Page Object Model design pattern
- Factory and Strategy pattern implemented
- Screenshot capture on test failure
- ExtentReports HTML reporting
- TestNG Listeners for reporting and failure handling
- Utility-based reusable architecture
- Explicit Wait utilities
- Log4j2 logging
- XML-driven browser and operating system configuration

## Framework Architecture

### Base Layer

#### Base Test

- WebDriver initialization
- Browser and Environment (local/remote) configuration
- Setup & Teardown methods
- Every test inherits from the `BaseTest` class

#### Base Page

- Provides reusable page methods and objects
    - `findElement()`,`click()`, `sendKeys()`, etc...
    - Waits, Logger, JavaScript methods, etc...
- Every Page class inherits from the `BasePage`

### Page Layer

- Page Object Model (POM) implementation
- Separate page classes with encapsulated locators
- Clear separation between test logic and UI interactions

### Component Layer

- Reusable UI components shared across pages
- Encapsulates common page sections (Header)
- Reduces duplication and improves maintainability

### Driver & Execution Layer

- Local / Remote execution support
- Selenium Grid integration
- Dockerized browser nodes
- Thread-safe WebDriver management using ThreadLocal
- Parallel cross-browser execution

### Test Layer

- TestNG based test suites
- XML-driven execution
- Group-based test execution
- Data-driven testing using Excel and Data Providers

### Utility Layer

- Screenshot handling
- Wait handling
- Excel data handling
- Log4j2 handling
- ExtentReports handling
- Properties file reading/handling

### Test Data Layer

- Excel / Properties
- Data-Driven testing

### Reporting / Logging Layer

- ExtentReports
- Screenshots on failure
- Log4j2
- Execution logs

### CI Integration

- Jenkins pipeline execution
- Maven-based build and test execution

### Design Patterns

- Page Object Model (POM)
- Factory Pattern
- Strategy Pattern
- Component Object Pattern

```text
docker
logs
reports
screenshots
testSuites
|-- src
|   |-- main
|   |   |-- constants
|   |   |-- driver
|   |       |-- browser_options
|   |       |-- environment
|   |   |-- pages
|   |   |-- utilities
|   |       |-- excel
|   |       |-- logger
|   |       |-- methods
|   |       |-- properties
|   |       |-- reports
|   |       |-- screencapture
|   |-- test
|       |-- dataprovider
|       |-- listener
|       |-- tests
|       |-- resources
|   |       |-- config
|   |       |-- testData
```

## How To Run

### Pre-Requisites

- `Java, Maven, Selenium Grid, and Docker` installed

#### Clone project

- `git clone https://github.com/zohairawan/OpenCart.git`

#### Run locally - Default Suite XML file

- Make sure execution environment is set to `local` in `config.properties` file
- Run command: `mvn clean test`

#### Run locally - Specific TestNG Suite

- Make sure execution environment is set to `local` in `config.properties` file
- Run command: `mvn clean test -Dsurefire.suiteXmlFiles=testSuites/path/to/suite.xml`

#### Run Selenium Grid + Docker

- Make sure Docker engine is running
- Make sure execution environment is set to `remote` in `config.properties` file
- `cd` into docker directory
- Run command: `docker compose up -d` to start docker containers + selenium grid
- Go back to project root `cd ..`
- Run command: `mvn clean test -Dsurefire.suiteXmlFiles=testSuites/remote/remote-linux.xml`
- Run command: `docker compose down` to stop docker containers + selenium grid

### Selenium Grid

![sg-ui.png](docs/img/sg-ui.png)
---
![sg-sessions.png](docs/img/sg-sessions.png)
---
![docker-containers.png](docs/img/docker-containers.png)

### ExtentReports

![er-dashboard.png](docs/img/er-dashboard.png)
---
![er-tests.png](docs/img/er-tests.png)
---
![er-groups.png](docs/img/er-groups.png)

### Jenkins

![jenkins-dashboard.png](docs/img/jenkins-dashboard.png)
---
![jenkins-builds.png](docs/img/jenkins-builds.png)
---
![jenkins-output.png](docs/img/jenkins-output.png)

### Parallel Execution Logs

![logs-parallel.png](docs/img/logs-parallel.png)

