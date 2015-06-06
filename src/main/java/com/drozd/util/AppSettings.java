package com.drozd.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppSettings {
	private static final String SETTINGS_JSON = "settings.json";
	private static final List<ToppingSettings> toppingsSettings;
	private static final List<PizzaSettings> pizzasSettings;
	static {
		toppingsSettings = loadToppings();
		pizzasSettings = loadPizzas();
	}

	private static List<ToppingSettings> loadToppings() {
		List<ToppingSettings> toppingsSettings = new ArrayList<>();
		try {
			String settingsStr = loadSettingsString();
			JSONArray toppings = new JSONObject(settingsStr)
					.getJSONArray("toppings");
			for (int i = 0; i < toppings.length(); i++) {
				ToppingSettings settings = new ToppingSettings();
				settings.setId(toppings.getJSONObject(i).getInt("id"));
				settings.setDescription(toppings.getJSONObject(i).getString(
						"description"));
				settings.setPrice(toppings.getJSONObject(i).getLong("price"));
				toppingsSettings.add(settings);
			}

		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		return toppingsSettings;
	}

	private static String loadSettingsString() throws IOException {
		String path = Thread.currentThread().getContextClassLoader()
				.getResource(SETTINGS_JSON).getPath();
		String settingsStr = new String(Files.readAllBytes(Paths.get(path)));
		return settingsStr;
	}

	private static List<PizzaSettings> loadPizzas() {
		List<PizzaSettings> pizzasSettings = new ArrayList<>();
		try {
			String settingsStr = loadSettingsString();
			JSONArray pizzas = new JSONObject(settingsStr)
					.getJSONArray("pizzas");
			for (int i = 0; i < pizzas.length(); i++) {
				PizzaSettings settings = new PizzaSettings();
				settings.setId(pizzas.getJSONObject(i).getInt("id"));
				settings.setToppingsIds(pizzas.getJSONObject(i).getString("toppings"));
				settings.setToppings(Arrays
						.stream(settings.getToppingsIds().split(","))
						.map(s -> getToppings().stream()
								.filter(t -> t.getId() == Integer.valueOf(s))
								.findFirst().get())
						.collect(Collectors.toList()));
				settings.setTitle(pizzas.getJSONObject(i).getString("title"));				
				pizzasSettings.add(settings);
			}

		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		return pizzasSettings;
	}

	public static List<PizzaSettings> getPizzas() {
		return pizzasSettings;
	}

	public static List<ToppingSettings> getToppings() {
		return toppingsSettings;
	}

}
