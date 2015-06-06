package com.drozd;

import java.util.ArrayList;
import java.util.List;

public class Cart<T> {
	private List<T> items = new ArrayList<>();
	
	public void addItem(T item){
		items.add(item);
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
}
