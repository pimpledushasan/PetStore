package com.api.action;

import static io.restassured.RestAssured.given;

import com.api.builder.RequestSpecificationBuilder;
import com.api.payload.PetPayload;
import com.api.payload.Payload;


public class MessagingManager extends BaseMessagingManager {
		
	/**
	 * This method is a generic createRequest method for post api call
	 */
	public void createRequestPost()
	{	
		//TODO add code for post request
		request = given().spec(RequestSpecificationBuilder.createReqSpec(this, false));
		Payload payloadObj = createPayloadObject(getService());
		request.body(payloadObj.getPayLoad(getPayloadObj()));
	} 

	
	/**
	 * This method is a generic createRequest method for get api call
	 */
	public void createRequestGet(boolean queryParamPresent)
	{		
		request = given().spec(RequestSpecificationBuilder.createReqSpec(this, queryParamPresent));			 
	} 
	
	
	/**
	 * This method returns Payload object based on the service
	 * @param service
	 * @return payload
	 */
	public Payload createPayloadObject(String service) {
		
		Payload payload = null;
		switch(service){
		case "PET":
			payload = new PetPayload();
			break;

		default:
			//log error
		}
		
		return payload;
	}
	
}