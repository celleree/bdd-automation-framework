package com.celleree.framework.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.celleree.framework.steps",
        plugin = {
                "pretty",
                "html:reports/cucumber-report.html"
        })
public class TestRunner extends AbstractTestNGCucumberTests {
}
