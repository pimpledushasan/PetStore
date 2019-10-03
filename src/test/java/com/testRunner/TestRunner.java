package com.testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="resources/features",
glue="com/api/steps",
tags= {"@pet"}
)
public class TestRunner {

}
