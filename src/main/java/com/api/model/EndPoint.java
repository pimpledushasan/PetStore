package com.api.model;

public class EndPoint {
	private String baseURI;
	private String resource;
	
	public EndPoint(String url, String res) {
		this.baseURI = url;
		this.resource = res;
	}
	
	public String getBaseURI() {
		return baseURI;
	}
	public void setBaseURI(String baseURI) {
		this.baseURI = baseURI;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	
	

}
