package com.drozd.pizza;

import java.util.List;

import com.drozd.util.AppSettings;
import com.drozd.util.PizzaSettings;

public class DefaultPizzaFactory {
	private List<PizzaSettings> pizzasSettings;
	private PizzaBuilder pizzaBuilder = new PizzaBuilder();
	
	public DefaultPizzaFactory() {
		pizzasSettings = AppSettings.getPizzas();
	}
	
	public PizzaBasis pizzaById(int id){
		PizzaSettings pizzaSettings = pizzasSettings.stream().filter(p -> p.getId() == id).findFirst().get();
		PizzaBasis pizza = new PizzaBasis();
		pizza.setTitle(pizzaSettings.getTitle());
		
		for (String toppingId : pizzaSettings.getToppingsIds().split(",")){
			pizza = pizzaBuilder.addTopping(pizza, Integer.valueOf(toppingId));
		}
		
		return pizza;
	}
}
