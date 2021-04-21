package com.amazon.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
        glue="src/main/java/com/amazon/stepdefinitions")
public class CucumberRunner extends AbstractTestNGCucumberTests {

}

