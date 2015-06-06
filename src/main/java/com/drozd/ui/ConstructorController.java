package com.drozd.ui;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drozd.pizza.PizzaBasis;
import com.drozd.pizza.PizzaBuilder;
import com.drozd.util.AppSettings;
import com.drozd.util.ToppingSettings;

@ManagedBean(name= "constructor")
@ViewScoped
public class ConstructorController {
	private static final Logger LOG = LoggerFactory.getLogger(ConstructorController.class);
	private List<ToppingSettings> toppings;
	private ToppingSettings selected;
	private PizzaBasis pizza = new PizzaBasis();
	private PizzaBuilder builder = new PizzaBuilder();
	
	@ManagedProperty(value = "#{cartController}")
	private CartController cartController;
	
	@PostConstruct
	public void init(){
		toppings = AppSettings.getToppings();
	}

	public List<ToppingSettings> getToppings() {
		return toppings;
	}

	public void setToppings(List<ToppingSettings> toppings) {
		this.toppings = toppings;
	}
	
	public void select(){
		Map<String, String> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		int id = Integer.valueOf((String)requestMap.get("id"));
		setSelected(toppings.stream().filter(t -> t.getId() == id).findAny().get());
	}
	
	public void add(){
		LOG.info("Adding " + selected.getDescription());
		pizza = builder.addTopping(pizza, selected.getId());
	}
	
	public void submit(){
		cartController.getCart().addItem(pizza);
	}

	public ToppingSettings getSelected() {
		return selected;
	}

	public void setSelected(ToppingSettings selected) {
		this.selected = selected;
	}

	public PizzaBasis getPizza() {
		return pizza;
	}

	public void setPizza(PizzaBasis pizza) {
		this.pizza = pizza;
	}

	public void setCartController(CartController cartController) {
		this.cartController = cartController;
	}
}
