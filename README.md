# BDD Automation Framework

A small Java 21 BDD test automation framework built with Maven, Cucumber-JVM, Selenium WebDriver, RestAssured, and TestNG.

## Prerequisites

- Java 21
- Maven 3.9+
- Git
- Google Chrome

## Run the test suite

From the repository root, run:

```powershell
mvn test
```

The suite includes:

- SauceDemo successful login UI scenario
- SauceDemo invalid login UI scenario
- JSONPlaceholder API scenario

## HTML report

After a successful test run, Cucumber generates an HTML report at:

```text
reports/cucumber-report.html
```

Open that file in a browser to review the scenario and step results. The `reports` directory is kept in the repository so a report from a verified real run can be committed as the assignment artifact.
