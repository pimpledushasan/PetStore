package com.api.builder;

import java.util.Map;

import com.api.action.MessagingManager;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationBuilder {
	
    public static RequestSpecBuilder reqbuilder;
    public static RequestSpecification requestSpec;

    
    /**
     * This method createRequestSpecification object for current request
     * @param msgMgr
     * @return RequestSpecification
     */
    public static RequestSpecification createReqSpec(MessagingManager msgMgr, boolean queryParamPresent)
    {   	
    
    	Map<String, String> headerMap = HeaderBuilder.createHeaders(msgMgr.getService());
    	
        reqbuilder = new RequestSpecBuilder();
        reqbuilder.addHeaders(headerMap);
        if(queryParamPresent) {
        	reqbuilder.addQueryParams(msgMgr.getQueryParam());
        }
        
        reqbuilder.setBaseUri(msgMgr.getEndPoint().getBaseURI()); 
        requestSpec = reqbuilder.build();
        return requestSpec;
    }
    
} 