package com.api.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.api.common.Constant;
import com.api.model.EndPoint;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;

public class APIUtility 
{
	public static Map <String, EndPoint>endPointMap = new HashMap<String, EndPoint>();
	public static Map <String, Object> headerMap = new HashMap<String, Object>();
	public static Map <String, String> serviceMap = new HashMap<String, String>();
	
	private static final Logger logger = LoggerFactory.getLogger(APIUtility.class);
	
	static {
		populateEndPoints();
		populateHeaderParams();
		createServiceMap();
	}
	
	/**
	 * This method returns EndPoint object based on res supplied
	 * @param res
	 * @return EndPoint
	 */
	//public static EndPoint getEndPoint(String res)
	public static EndPoint getEndPoint(String res)
	{
		return endPointMap.get(res);
	}
	
	/**
	 * This method returns headerMap
	 * @return headerMap
	 */
	public static Map<String, Object> getHeaderMap()
	{
		return headerMap;
	}
	
	/**
	 * This method returns the Service base on res (endpoint) supplied 
	 * @param res
	 * @return serviceType
	 */
	
	public static String getServiceType(String res)
	{
		return serviceMap.get(res);
	}
	
	/**
	 * This method creates endpoint using static values.
	 */
	public static void populateEndPoints()
	{
		String env = System.getProperty("env")!= null?System.getProperty("env"):"DEV";
		String envProperties = null;
		switch(env.toUpperCase()) {
		case "DEV":
			envProperties = Constant.DEV_ENDPOINT;
			break;
		case "CIT":
				//Add file here
			break;	
		}
		Properties prop = readPropertiesFile(envProperties);
		prop.forEach((key, value) ->endPointMap.put(key.toString(), new EndPoint(value.toString(), key.toString())));
		
	}
	
	/**
	 * This method creates headerMap using static values
	 */
	public static void populateHeaderParams()
	{
		Properties prop = readPropertiesFile(Constant.HEADER_PARAMS);
		prop.forEach((key, value) ->headerMap.put(key.toString(), value.toString()));
		
	}
	
	/**
	 * This method creates serviceMap using static values. This map may be created 
	 * using csv file.
	 */
	//This service is used in createPayloadObject() method.
	public static void createServiceMap()
	{
		Properties prop = readPropertiesFile(Constant.SERVICE);
		prop.forEach((key, value) ->serviceMap.put(key.toString(), value.toString()));
	}
		
	
	/**
	 * This method loads properties file and return properties object
	 * @param filename
	 * @return
	 */
	private static  Properties readPropertiesFile(String filename) {
		Properties properties = new Properties();
		try {
			//System.out.println("User dir :"+System.getProperty("user.dir")+"/resources");
			FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"/resources/"+filename);
			properties.load(input); 
		}catch(IOException e) {
			//System.out.println("Error in reading properties file :" + filename);
			e.printStackTrace();
		}
		
		return properties;
	}
	
}