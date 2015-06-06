package com.drozd.pizza;


public abstract class AbstractPizzaDecorator extends PizzaBasis{
	protected Long price;
	public abstract String getDescription();
	public abstract Long getPrice();
	public abstract String getTitle();
}
