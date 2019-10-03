package com.api.steps;

import com.api.steplib.CommonStepLib;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class CommonStep extends BaseStep
{
	@Steps
	CommonStepLib commonsteplib;
	@Given("^I check pet service is running$")
	public void iCheckServiceStatus() {
		//TODO Add code for checking service status
	}
	
	@Then("^I verify the statuscode is \"(.*)\"$")
	public void iVerifyStatuscode(String statusCode) {
		commonsteplib.verifyStatusCode(statusCode);
	}
}
