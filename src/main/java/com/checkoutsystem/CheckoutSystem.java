package com.checkoutsystem;

import com.checkoutsystem.basket.Basket;
import com.checkoutsystem.basket.BasketImpl;
import com.checkoutsystem.offer.OfferManager;
import com.checkoutsystem.print.PrintUtil;

public class CheckoutSystem {

	public static void main(String[] args) {
		Basket basket = new BasketImpl();
		
		//basket.loadProductsFromList() can also be used if not stand alone programme
		basket.loadProductsFromArray(args);
		OfferManager offerManager = new OfferManager();
		offerManager.loadOffers();
		
		
		int productsTotal = basket.getTotal();
		int offersTotal = offerManager.calculateOffersAmount(basket.getBasket());

		PrintUtil.printTotal(productsTotal - offersTotal);
	}
}