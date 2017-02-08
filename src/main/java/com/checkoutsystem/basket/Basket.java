package com.checkoutsystem.basket;

import java.util.List;

public interface Basket {

	public void loadProductsFromArray(String[] commandLineArgs);
	public int getTotal();
	void loadProductsFromList(List<String> products);
}