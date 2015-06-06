package com.drozd.ui;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.drozd.Cart;
import com.drozd.pizza.PizzaBasis;

@ManagedBean(name= "cartController")
@SessionScoped
public class CartController {
	private Cart<PizzaBasis> cart = new Cart<PizzaBasis>();

	public Cart<PizzaBasis> getCart() {
		return cart;
	}
	
	public List<PizzaBasis> getItems(){
		return cart.getItems();
	}
	
	public void setCart(Cart<PizzaBasis> cart) {
		this.cart = cart;
	}

	public class Pair<K,V>{
		private K key;
		private V value;
		
		public Pair(K k, V v) {
			this.key = k;
			this.value = v;
		}
	
		public K getKey() {
			return key;
		}
		
		public void setKey(K key) {
			this.key = key;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}
		
	}
}
