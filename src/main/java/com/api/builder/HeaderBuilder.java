package com.api.builder;

import java.util.HashMap;
import java.util.Map;

public class HeaderBuilder {

	/**
	 * This method creates the map of header parameter based on the Service being used in the current request
	 * @param strService
	 * @return Map<String,String>
	 */
	public static Map<String, String> createHeaders(String strService)
	{	
		Map<String, String> headerMap = new HashMap<String, String>();
		switch(strService) {
		case "PET":
			headerMap.put("Content-Type", "application/json");
			break;

		default:
			//TODO add/log some error code	
		}
		return headerMap;
	}
}