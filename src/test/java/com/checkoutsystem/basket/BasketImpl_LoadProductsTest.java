package com.checkoutsystem.basket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.checkoutsystem.product.Product;
import com.checkoutsystem.test.CheckoutSystemBaseClassTest;

/*
 *  Tests for BasketImpl.loadProductsFromArray() 
 *  and BasketImpl.loadProductsFromList() methods
 */
public class BasketImpl_LoadProductsTest extends CheckoutSystemBaseClassTest{

	@Test
	public void testLoadNoProductsInArray() {
		basket.loadProductsFromArray(new String[]{});
		assertTrue(basket.getBasket().isEmpty());
	}

	@Test
	public void testLoadEmptyStringProductInArray() {
		basket.loadProductsFromArray(new String[]{""});
		assertTrue(basket.getBasket().isEmpty());
	}

	@Test
	public void testLoadTwoEmptyStringProductInArray() {
		basket.loadProductsFromArray(new String[]{"",""});
		assertTrue(basket.getBasket().isEmpty());
	}

	@Test
	public void testLoadOneValidProductInArray() {
		basket.loadProductsFromArray(new String[]{"apple"});
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(1, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
	}

	@Test
	public void testLoadOneValidProductandOneInvalidInArray() {
		basket.loadProductsFromArray(new String[]{"apple","prod1"});
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(1, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
	}

	@Test
	public void testLoadOneValidProductandTwoInvalidInArray() {
		basket.loadProductsFromArray(new String[]{"apple","prod1","prod2"});
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(1, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
	}
	
	@Test
	public void testLoadMultipleValidProductsInArray() {
		basket.loadProductsFromArray(new String[]{"apple","apple"});
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(1, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));	
		assertEquals((Integer)2, (Integer)basket.getBasket().get(Product.APPLE));
	}
	
	@Test
	public void testLoadMultipleValidProductsWithAnotherProductInArray() {
		basket.loadProductsFromArray(new String[]{"apple","apple","orange"});
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(2, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		assertTrue(basket.getBasket().containsKey(Product.ORANGE));	
		assertEquals((Integer)2, (Integer)basket.getBasket().get(Product.APPLE));
		assertEquals((Integer)1, (Integer)basket.getBasket().get(Product.ORANGE));
	}

	@Test
	public void testLoadRwoValidProductsInArray() {
		basket.loadProductsFromArray(new String[]{"apple","orange"});
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(2, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		assertTrue(basket.getBasket().containsKey(Product.ORANGE));
	}

	@Test
	public void testLoadRwoValidProductsAndOneInvalidProductInArray() {
		basket.loadProductsFromArray(new String[]{"apple","orange","prod1"});
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(2, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		assertTrue(basket.getBasket().containsKey(Product.ORANGE));
	}

	@Test
	public void testLoadRwoValidProductsAndTwoInvalidProductsInArray() {
		basket.loadProductsFromArray(new String[]{"apple","orange","prod1","prod2"});
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(2, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		assertTrue(basket.getBasket().containsKey(Product.ORANGE));
	}
	
	
	@Test
	public void testLoadNoProductsInList() {
		basket.loadProductsFromList(new ArrayList<String>());
		assertTrue(basket.getBasket().isEmpty());
	}

	@Test
	public void testLoadEmptyStringProductInList() {
		List<String> products = new ArrayList<String>();
		products.add("");
		basket.loadProductsFromList(products);
		assertTrue(basket.getBasket().isEmpty());
	}

	@Test
	public void testLoadTwoEmptyStringProductInList() {
		List<String> products = new ArrayList<String>();
		products.add("");
		products.add("");
		basket.loadProductsFromList(products);
		assertTrue(basket.getBasket().isEmpty());
	}

	@Test
	public void testLoadOneValidProductInList() {
		List<String> products = new ArrayList<String>();
		products.add("apple");
		basket.loadProductsFromList(products);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(1, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
	}

	@Test
	public void testLoadOneValidProductandOneInvalidInList() {
		List<String> products = new ArrayList<String>();
		products.add("apple");
		products.add("prod1");
		basket.loadProductsFromList(products);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(1, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
	}

	@Test
	public void testLoadOneValidProductandTwoInvalidInList() {
		List<String> products = new ArrayList<String>();
		products.add("apple");
		products.add("prod1");
		products.add("prod2");
		
		basket.loadProductsFromList(products);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(1, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
	}
	
	@Test
	public void testLoadMultipleValidProductsInList() {
		List<String> products = new ArrayList<String>();
		products.add("apple");
		products.add("apple");
		basket.loadProductsFromList(products);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(1, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));	
		assertEquals((Integer)2, (Integer)basket.getBasket().get(Product.APPLE));
	}
	
	@Test
	public void testLoadMultipleValidProductsWithAnotherProductInList() {
		List<String> products = new ArrayList<String>();
		products.add("apple");
		products.add("apple");
		products.add("orange");
		basket.loadProductsFromList(products);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(2, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		assertTrue(basket.getBasket().containsKey(Product.ORANGE));	
		assertEquals((Integer)2, (Integer)basket.getBasket().get(Product.APPLE));
		assertEquals((Integer)1, (Integer)basket.getBasket().get(Product.ORANGE));
	}

	@Test
	public void testLoadRwoValidProductsInList() {
		List<String> products = new ArrayList<String>();
		products.add("apple");
		products.add("orange");
		basket.loadProductsFromList(products);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(2, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		assertTrue(basket.getBasket().containsKey(Product.ORANGE));
	}

	@Test
	public void testLoadRwoValidProductsAndOneInvalidProductInList() {
		List<String> products = new ArrayList<String>();
		products.add("apple");
		products.add("orange");
		products.add("prod1");
		
		basket.loadProductsFromList(products);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(2, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		assertTrue(basket.getBasket().containsKey(Product.ORANGE));
	}

	@Test
	public void testLoadRwoValidProductsAndTwoInvalidProductsInList() {
		List<String> products = new ArrayList<String>();
		products.add("apple");
		products.add("orange");
		products.add("prod1");
		products.add("prod2");
		basket.loadProductsFromList(products);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(2, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		assertTrue(basket.getBasket().containsKey(Product.ORANGE));
	}
	
}
