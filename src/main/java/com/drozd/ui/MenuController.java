package com.drozd.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drozd.pizza.DefaultPizzaFactory;
import com.drozd.pizza.PizzaBasis;
import com.drozd.util.AppSettings;
import com.drozd.util.PizzaSettings;

@ManagedBean(name= "menu")
@ViewScoped
public class MenuController {
	private static final Logger LOG = LoggerFactory.getLogger(MenuController.class);
	private DefaultPizzaFactory factory;
	private List<Pair<Integer, PizzaBasis>> pizzas = new ArrayList<>();
	private PizzaBasis selected;
	
	@ManagedProperty(value = "#{cartController}")
	private CartController cartController;
	
	@PostConstruct
	public void init(){
		factory = new DefaultPizzaFactory();
		for(PizzaSettings settigns : AppSettings.getPizzas()){
			getPizzas().add(new Pair<Integer, PizzaBasis>(settigns.getId(), factory.pizzaById(settigns.getId())));
		}
	}

	public void select(){
		Map<String, String> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		final int id = Integer.valueOf(requestMap.get("id"));
		selected = getPizzas().stream().filter(p -> p.getKey() == id).findFirst().get().getValue();
	}
	
	public void add(){
		LOG.info("Adding " + selected.getTitle());
		cartController.getCart().addItem(selected);
	}

	public PizzaBasis getSelected() {
		return selected;
	}

	public void setSelected(PizzaBasis selected) {
		this.selected = selected;
	}
	
	public List<Pair<Integer, PizzaBasis>> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pair<Integer, PizzaBasis>> pizzas) {
		this.pizzas = pizzas;
	}

	public void setCartController(CartController cartController) {
		this.cartController = cartController;
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
