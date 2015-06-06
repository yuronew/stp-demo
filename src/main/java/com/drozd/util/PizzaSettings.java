package com.drozd.util;

import java.util.List;

public class PizzaSettings{
	private int id;
	private String toppingsIds;
	private String title;
	private List<ToppingSettings> toppings;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getToppingsIds() {
		return toppingsIds;
	}
	public void setToppingsIds(String toppingsIds) {
		this.toppingsIds = toppingsIds;
	}
	public List<ToppingSettings> getToppings() {
		return toppings;
	}
	public void setToppings(List<ToppingSettings> toppings) {
		this.toppings = toppings;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}