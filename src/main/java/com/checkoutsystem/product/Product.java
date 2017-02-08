package com.checkoutsystem.product;

public enum Product {
	
	// TODO for this example the products are hard coded as an enum.
	// TODO they will come from an external source and will be stored in a suitable data structure.

	APPLE(60),
	ORANGE(25);
	
	private final int price;
	
	private Product(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}