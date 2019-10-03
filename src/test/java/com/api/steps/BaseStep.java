package com.api.steps;

import java.util.HashMap;
import java.util.Map;

import com.api.action.MessagingManager;
import com.api.model.GenericVO;
import com.api.utils.APIUtility;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

/**
 * @author
 * @Dushasan
 */
public class BaseStep{

	public static ValidatableResponse valResponse;
	public static RequestSpecification request;
	public static Response response;
	public static JsonPath jsonPath;
	public static MessagingManager messageManager = new MessagingManager();
	public static int count;
	

	
	/**
	 * Method to return request specification object.
	 * @return request
	 */
	public static RequestSpecification getRequest()
	{
		return MessagingManager.request;
	
	}
	
	/**
	 * Method to set Service type and end points associated to current request.
	 * @param res
	 */
	public static void enrichEndPoint(String res)
	{
		messageManager.setEndPoint(APIUtility.getEndPoint(res));
		messageManager.setService(APIUtility.getServiceType(res));
	}
	
	/**
	 * This method creates the map of query Parameters which is used by RequestSpecification builder
	 * @param params
	 */
	public static void enrichQueryParameters(String ...params)
	{
		Map<String, String> queryParamMap = new HashMap<String,String>();
		for(String qparam:params) {
			String p[] = qparam.split(":");
			if(!p[1].equalsIgnoreCase("null")) {
				queryParamMap.put(p[0], p[1]);
			}
		}
		messageManager.setQueryParam(queryParamMap);
		
	}
	
	
	/**
	 * This method creates the payload object base on the parameters supplied.
	 * @param objtype
	 * @param params
	 */
	public static void createObject(String objtype, String ...params)
	{
		GenericVO obj = BaseStepHelper.createObject(objtype, params);
		messageManager.setPayloadObj(obj);
	}

	public static MessagingManager getMessageManager() {
		return messageManager;
	}

	public static void setMessageManager(MessagingManager messageManager) {
		BaseStep.messageManager = messageManager;
	}
	
	
}