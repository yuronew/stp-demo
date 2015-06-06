package com.drozd.pizza;

import java.util.List;

import com.drozd.util.AppSettings;
import com.drozd.util.ToppingSettings;

public class PizzaBuilder {
	private List<ToppingSettings> toppingsSettings;
	
	public PizzaBuilder() {
		toppingsSettings = AppSettings.getToppings();		
	}
	
	public PizzaBasis addTopping(PizzaBasis pizza, final int toppingId){		
		ToppingSettings settings = toppingsSettings.stream().filter(s -> s.getId() == toppingId).findAny().get();
		pizza = new PizzaTopping(pizza, settings.getDescription(), settings.getPrice());
		
		return pizza;
	}
}
