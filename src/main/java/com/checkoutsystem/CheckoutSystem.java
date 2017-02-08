package com.checkoutsystem;

import com.checkoutsystem.basket.Basket;
import com.checkoutsystem.basket.BasketImpl;
import com.checkoutsystem.print.PrintUtil;

public class CheckoutSystem {

	public static void main(String[] args) {
		Basket basket = new BasketImpl();	
		
		//basket.loadProductsFromList() can also be used if not stand alone programme
		basket.loadProductsFromArray(args);
		
		int productsTotal = basket.getTotal();

		PrintUtil.printTotal(productsTotal);
	}
}