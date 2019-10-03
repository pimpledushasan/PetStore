package com.api.steplib;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.api.model.PetDetails;
import com.api.model.PetVO;
import com.api.steps.BaseStep;

import freemarker.core.CollectionAndSequence;
import junit.framework.Assert;
import net.thucydides.core.annotations.Step;

public class PetStepLib extends BaseStep{

	/**
	 * The method is responsible for creating request object and calling endpoint
	 */
	public void accessGetPetEndpoint()
	{
		messageManager.createRequestGet(true);
		String strResource = messageManager.getEndPoint().getResource();
		
		response = getRequest().get(strResource);
	}
	
	/**
	 * Get the total count of pet matching search criteria.
	 */
	public void getTotalPetcount()
	{				
		PetVO petObj= (PetVO)messageManager.getPayloadObj();
		
		String status = petObj.getStatus();
		String name = petObj.getName();
		String query = "findAll{it.status=='"+status+"'  && it.name=='"+name+"'}";
		List<Map> mapList  = null;
		mapList = response.then().extract().path(query);
		
		//Set the value of total available pets matching search criteria to ues later verification. 
		count = mapList!= null?mapList.size():0;

	}
	
	@Step("Verify total Pets found : {0}" )
	public void verifyTotalPetCount(int expectedCount)
	{
		
		//Get the parameters from Payload object stored in messaging manager
		PetVO petObj= (PetVO)messageManager.getPayloadObj();
		
		String status = petObj.getStatus();
		String name = petObj.getName();
		
		//Use mapping response to java POJO //
		
		List<PetDetails> petList = response.then().extract().jsonPath().getList("",PetDetails.class);
		System.out.println("Total Number of Pets in Response  :"+petList.size());
		
		List<PetDetails> selPetList =
				petList.stream()
				.filter(pet -> (pet.getName()!= null && pet.getName().equals(name))  && (null!= pet.getStatus() && status.equals(pet.getStatus())))
				.collect(Collectors.toList());
		
		System.out.println("Total number of Pets found with name = "+name+" and status = "+status+" is : "+selPetList.size());		
		Assert.assertEquals("Total pets not matching", expectedCount,selPetList.size());
	
	}
	
	
	
}
