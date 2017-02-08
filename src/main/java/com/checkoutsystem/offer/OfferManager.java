package com.checkoutsystem.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.checkoutsystem.product.Product;

public class OfferManager {
	
	List<Offer> offers = new ArrayList<Offer>();

	protected void addOffer(Offer offer){
		offers.add(offer);
	}
	
	public int calculateOffersAmount(Map<Product, Integer> basket) {
		int totalOfferAmount = 0;
		
		for (Offer offer:offers) {
			int numberOfOfferMatches = getNumberOfOfferMatches(offer, basket);

			totalOfferAmount += numberOfOfferMatches * offer.getOfferAmount();
		}

		return totalOfferAmount;
	}
	
	protected int getNumberOfOfferMatches(Offer offer, Map<Product, Integer> basket) {
		
		int numberOfOfferMatches = Integer.MAX_VALUE;
		
		// number of offer matches is the lowest number of prerequisites matched
		for(OfferPrerequisite prererequisite:offer.getOfferPrerequisites()){
			
			int numberOfPrerequisitesMatched = getNumberOfPrerequisitesMatched(prererequisite, basket);

			if (numberOfPrerequisitesMatched < numberOfOfferMatches) {
				numberOfOfferMatches = numberOfPrerequisitesMatched;
			}
		}
		
		if (numberOfOfferMatches == Integer.MAX_VALUE) {
			numberOfOfferMatches = 0;
		}
		
		return numberOfOfferMatches;
	}
	
	protected int getNumberOfPrerequisitesMatched (OfferPrerequisite prererequisite, Map<Product, Integer> basket) {
		Integer prererequisiteProductInBasketCount = basket.get(prererequisite.getProduct());

		if (prererequisiteProductInBasketCount == null) {
			prererequisiteProductInBasketCount = 0;
		}
		
		return prererequisiteProductInBasketCount / prererequisite.getCount();
	}
	
	public void loadOffers() {
		// for this example the offers are hard coded here
		// they will come from an external source (for eg database)
		
		// buy one, get one free on Apples
		List<OfferPrerequisite> prerequisites = new ArrayList<OfferPrerequisite>();
		prerequisites.add(new OfferPrerequisite(Product.APPLE, 2));
		Offer offer = new OfferImpl(prerequisites, Product.APPLE.getPrice());
		addOffer(offer);
		
	
		// 3 for the price of 2 on Oranges
		prerequisites = new ArrayList<OfferPrerequisite>();
		prerequisites.add(new OfferPrerequisite(Product.ORANGE, 3));
		offer = new OfferImpl(prerequisites, Product.ORANGE.getPrice());
		addOffer(offer);		
	}
}
