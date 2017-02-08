package com.checkoutsystem.basket;

import java.util.List;
import java.util.Map;

import com.checkoutsystem.product.Product;

public interface Basket {

	public void loadProductsFromArray(String[] commandLineArgs);
	public int getTotal();
	public Map<Product,Integer> getBasket();
	void loadProductsFromList(List<String> products);
}