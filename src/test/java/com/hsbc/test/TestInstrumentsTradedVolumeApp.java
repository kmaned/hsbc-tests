package com.hsbc.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue={"/src/test/java/com/hsbc/steps"},
        plugin = {
        "json:target/cucumber-report/tests.json",
        "html:target/cucumber-report/tests.html"}
)
public class TestInstrumentsTradedVolumeApp {
}