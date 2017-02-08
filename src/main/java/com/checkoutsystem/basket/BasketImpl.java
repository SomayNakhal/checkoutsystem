package com.checkoutsystem.basket;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.checkoutsystem.product.Product;

public class BasketImpl implements Basket {

	private final String INVALID_PRODUCT_MESSAGE_PREFIX = "Invalid product ignored :";
	private final String NULL_PRODUCT_MESSAGE = "Attempting to add a null product ignored.";

	private Map<Product, Integer> basket = new HashMap<Product, Integer>();

	@Override
	public void loadProductsFromArray(String[] commandLineArgs) {
		loadProductsFromList(Arrays.asList(commandLineArgs));
	}
	
	
	@Override
	public void loadProductsFromList(List<String> products) {

		for (String productString:products) {
			Product product = processProduct(productString);
			if (product != null) {
				addProduct(product, 1);
			}
		}
	}

	protected Product processProduct(String commandLineArg) {
		Product product = null;

		try {
			product = Product.valueOf(commandLineArg.toUpperCase());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.err.println(getInvalidProductMessagePrefix() + commandLineArg);
		}

		return product;
	}

	public String getInvalidProductMessagePrefix() {
		return INVALID_PRODUCT_MESSAGE_PREFIX;
	}
	
	public String getNullProductMessage() {
		return NULL_PRODUCT_MESSAGE;
	}


	protected void addProduct(Product product, Integer count){
		if (product != null) {
		
			Integer currentProductCount = basket.get(product);

			if (currentProductCount == null)  {
				currentProductCount = 0;
			}

			basket.put(product, currentProductCount + count);
		} else {
			System.err.println(NULL_PRODUCT_MESSAGE);
		}
	}

	@Override
	public int getTotal(){
		int total = 0;
		for (Product product:basket.keySet()) {
			total += basket.get(product) * product.getPrice();
		}		
		return total;
	}

	public Map<Product,Integer> getBasket() {
		return basket;
	}
}