package com.ctl.example.cucumber.runner;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
    tags = {"@CLC_IPS"}, // You must explicitly state which tests to run
    features = {"src/test/java/com/ctl/example/cucumber/feature"},
    glue = {"com/ctl/example/cucumber/step"}
)
public class RunCukesTest {

}