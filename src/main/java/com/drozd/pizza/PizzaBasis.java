package com.drozd.pizza;

import com.drozd.AbstractCartItem;

public class PizzaBasis extends AbstractCartItem{
	private String title;
	
	public PizzaBasis() {
		this.description = "basis";
	}

	@Override
	public Long getPrice() {
		return 1L;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
