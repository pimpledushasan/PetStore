package com.api.steps;

import com.api.steplib.PetStepLib;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PetStep extends BaseStep
{
	@Steps
	PetStepLib petsteplib;
	
	@When("^I access endpoint (.*) with status (.*) and petname (.*)$")
	public void iAccessPetEndpoint(String strendpoint, String status, String name) {
		enrichEndPoint(strendpoint);
		enrichQueryParameters("status:"+status);
		createObject("pet", name, status);
		petsteplib.accessGetPetEndpoint();
	}

	@Then("^I count the total available pets$")
	public void countAvailablePets() {
		petsteplib.getTotalPetcount();
	}

	@Then("^I verify the available pets$")
	public void iverifyAavailablePets() {
		petsteplib.verifyTotalPetCount(count);
	}
}
