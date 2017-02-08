package com.checkoutsystem.offer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.checkoutsystem.product.Product;



public class OfferManagerTest {


	@Test
	public void testNoPrerequisitsMatchMissingProduct() {
		OfferManager offerManager = new OfferManager();
		OfferPrerequisite prerequisite = new OfferPrerequisite(Product.APPLE, 1);
		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(Product.ORANGE, 1);

		assertEquals(0,offerManager.getNumberOfPrerequisitesMatched(prerequisite, basket));
	}

	@Test
	public void testNoPrerequisitsMatchInsufficentProduct() {
		OfferManager offerManager = new OfferManager();
		OfferPrerequisite prerequisite = new OfferPrerequisite(Product.APPLE, 2);
		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(Product.ORANGE, 1);
		basket.put(Product.APPLE, 1);

		assertEquals(0,offerManager.getNumberOfPrerequisitesMatched(prerequisite, basket));
	}

	@Test
	public void testOnePrerequisitMatch() {
		OfferManager offerManager = new OfferManager();
		OfferPrerequisite prerequisite = new OfferPrerequisite(Product.APPLE, 2);
		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(Product.ORANGE, 1);
		basket.put(Product.APPLE, 2);

		assertEquals(1,offerManager.getNumberOfPrerequisitesMatched(prerequisite, basket));
	}

	@Test
	public void testMultilePrerequisitMatch() {
		OfferManager offerManager = new OfferManager();
		OfferPrerequisite prerequisite = new OfferPrerequisite(Product.APPLE, 2);
		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(Product.ORANGE, 1);
		basket.put(Product.APPLE, 7);

		assertEquals(3,offerManager.getNumberOfPrerequisitesMatched(prerequisite, basket));
	}


	@Test
	public void testNoOfferMatch() {
		OfferManager offerManager = new OfferManager();
		List<OfferPrerequisite> prerequisites = new ArrayList<OfferPrerequisite>();
		prerequisites.add(new OfferPrerequisite(Product.APPLE, 2));
		Offer offer = new OfferImpl(prerequisites, 60);

		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(Product.ORANGE, 1);

		assertEquals(0,offerManager.getNumberOfOfferMatches(offer, basket));
	}

	@Test
	public void testNoOfferMatchOnePrerquisiteMatch() {
		OfferManager offerManager = new OfferManager();
		List<OfferPrerequisite> prerequisites = new ArrayList<OfferPrerequisite>();
		prerequisites.add(new OfferPrerequisite(Product.APPLE, 2));
		prerequisites.add(new OfferPrerequisite(Product.ORANGE, 1));

		Offer offer = new OfferImpl(prerequisites, 60);

		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(Product.ORANGE, 1);

		assertEquals(0,offerManager.getNumberOfOfferMatches(offer, basket));
	}

	@Test
	public void testOneOfferMatchOnePrerquisiteMatch() {
		OfferManager offerManager = new OfferManager();
		List<OfferPrerequisite> prerequisites = new ArrayList<OfferPrerequisite>();
		prerequisites.add(new OfferPrerequisite(Product.APPLE, 2));

		Offer offer = new OfferImpl(prerequisites, 60);

		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(Product.ORANGE, 1);
		basket.put(Product.APPLE, 2);


		assertEquals(1,offerManager.getNumberOfOfferMatches(offer, basket));
	}

	@Test
	public void testOneOfferMatchMultiplePrerquisitesMatch() {
		OfferManager offerManager = new OfferManager();
		List<OfferPrerequisite> prerequisites = new ArrayList<OfferPrerequisite>();
		prerequisites.add(new OfferPrerequisite(Product.APPLE, 2));
		prerequisites.add(new OfferPrerequisite(Product.ORANGE, 1));

		Offer offer = new OfferImpl(prerequisites, 60);

		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(Product.ORANGE, 1);
		basket.put(Product.APPLE, 2);


		assertEquals(1,offerManager.getNumberOfOfferMatches(offer, basket));
	}


	@Test
	public void testMultipleOfferMatchesMultiplePrerquisitesMatch() {
		OfferManager offerManager = new OfferManager();
		List<OfferPrerequisite> prerequisites = new ArrayList<OfferPrerequisite>();
		prerequisites.add(new OfferPrerequisite(Product.APPLE, 2));
		prerequisites.add(new OfferPrerequisite(Product.ORANGE, 1));

		Offer offer = new OfferImpl(prerequisites, 60);

		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(Product.ORANGE, 4);
		basket.put(Product.APPLE, 7);


		assertEquals(3,offerManager.getNumberOfOfferMatches(offer, basket));
	}

	@Test
	public void testCalculateOfferAmountNoOfferMatches() {
		OfferManager offerManager = new OfferManager();
		List<OfferPrerequisite> prerequisites = new ArrayList<OfferPrerequisite>();
		prerequisites.add(new OfferPrerequisite(Product.APPLE, 2));

		offerManager.addOffer(new OfferImpl(prerequisites, 60));

		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(Product.ORANGE, 2);
		basket.put(Product.APPLE, 1);


		assertEquals(0,offerManager.calculateOffersAmount(basket));
	}

	@Test
	public void testCalculateOfferAmountOneOfferMatch() {
		OfferManager offerManager = new OfferManager();
		List<OfferPrerequisite> prerequisites = new ArrayList<OfferPrerequisite>();
		prerequisites.add(new OfferPrerequisite(Product.APPLE, 2));

		offerManager.addOffer(new OfferImpl(prerequisites, 60));

		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(Product.ORANGE, 2);
		basket.put(Product.APPLE, 3);


		assertEquals(60,offerManager.calculateOffersAmount(basket));
	}

	@Test
	public void testCalculateOfferAmountMultipleOfferMatchesOfSameOffer() {
		OfferManager offerManager = new OfferManager();
		List<OfferPrerequisite> prerequisites = new ArrayList<OfferPrerequisite>();
		prerequisites.add(new OfferPrerequisite(Product.APPLE, 2));

		offerManager.addOffer(new OfferImpl(prerequisites, 60));

		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(Product.ORANGE, 2);
		basket.put(Product.APPLE, 7);

		assertEquals(180,offerManager.calculateOffersAmount(basket));
	}

	@Test
	public void testCalculateOfferAmountMultipleOfferMatchesOfMultipleOffers() {
		OfferManager offerManager = new OfferManager();
		List<OfferPrerequisite> prerequisites = new ArrayList<OfferPrerequisite>();
		prerequisites.add(new OfferPrerequisite(Product.APPLE, 2));

		offerManager.addOffer(new OfferImpl(prerequisites, 60));

		prerequisites = new ArrayList<OfferPrerequisite>();
		prerequisites.add(new OfferPrerequisite(Product.APPLE, 1));
		prerequisites.add(new OfferPrerequisite(Product.ORANGE, 2));

		offerManager.addOffer(new OfferImpl(prerequisites, 80));


		Map<Product, Integer> basket = new HashMap<Product, Integer>();
		basket.put(Product.ORANGE, 5);
		basket.put(Product.APPLE, 5);


		assertEquals(280,offerManager.calculateOffersAmount(basket));
	}


}
