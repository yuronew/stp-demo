package com.drozd.pizza;

public class PizzaTopping extends AbstractPizzaDecorator{
	private PizzaBasis pizza;	
	public PizzaTopping(PizzaBasis pizza, String description, Long price) {
		this.description = description;
		this.price = price;
		this.pizza = pizza;
	}
	
	@Override
	public String getDescription() {
		return pizza.getDescription() + "+" + description;
	}

	@Override
	public Long getPrice() {
		return pizza.getPrice() + price;
	}

	@Override
	public String getTitle() {
		return pizza.getTitle();
	}
}
