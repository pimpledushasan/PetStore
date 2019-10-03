package com.api.action;

import java.util.Map;

import com.api.model.EndPoint;
import com.api.model.GenericVO;
import io.restassured.specification.RequestSpecification;

public class BaseMessagingManager {
	
	private GenericVO  payloadObj;
	
	public static RequestSpecification request;
	private EndPoint endPoint;
	private Map<String, String> queryParam;
	
	//This parameter stores the Service name like PET which can be used to identify payload.
	private String service;


	public GenericVO getPayloadObj() {
		return payloadObj;
	}

	public void setPayloadObj(GenericVO payloadObj) {
		this.payloadObj = payloadObj;
	}
	
	public EndPoint getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(EndPoint endPoint) {
		this.endPoint = endPoint;
	}

	public Map<String, String> getQueryParam() {
		return queryParam;
	}

	public void setQueryParam(Map<String, String> queryParam) {
		this.queryParam = queryParam;
	}
	
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
}