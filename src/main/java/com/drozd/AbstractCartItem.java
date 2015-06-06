package com.drozd;

public abstract class AbstractCartItem {
	protected String description = "empty item";
	
	public String getDescription(){
		return description;
	}
	
	public abstract Long getPrice();
}
