package com.drozd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.drozd.pizza.PizzaBasis;
import com.drozd.pizza.PizzaBuilder;

public class PizzaDecoratorTest {
	private PizzaBuilder builder = new PizzaBuilder();
	
	@Test
	public void createPizza() {
		PizzaBasis pizza = new PizzaBasis();
		pizza = builder.addTopping(pizza, 1);
		pizza = builder.addTopping(pizza, 2);
		System.out.println(pizza.getDescription());
		assertEquals(9L, pizza.getPrice().longValue());
	}
}
