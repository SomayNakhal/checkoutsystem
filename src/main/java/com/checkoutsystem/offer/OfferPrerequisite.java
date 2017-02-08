package com.checkoutsystem.offer;

import com.checkoutsystem.product.Product;

public class OfferPrerequisite {
	
	private Product product;
	private int count;
	
	public OfferPrerequisite(Product product, int count) {
		super();
		this.product = product;
		this.count = count;
	}

	public Product getProduct() {
		return product;
	}

	public int getCount() {
		return count;
	}

}
