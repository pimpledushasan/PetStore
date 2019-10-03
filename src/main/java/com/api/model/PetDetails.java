package com.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetDetails 
{
	Long id;
	String name;
	String status;
	Map category = new HashMap<>();	
	List<String> photoUrls = new ArrayList<String>();
	List<Map> tags = new ArrayList<Map>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Map getCategory() {
		return category;
	}
	public void setCategory(Map category) {
		this.category = category;
	}
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public List<Map> getTags() {
		return tags;
	}
	public void setTags(List<Map> tags) {
		this.tags = tags;
	}

}
