package com.checkoutsystem.basket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.checkoutsystem.product.Product;
import com.checkoutsystem.test.CheckoutSystemBaseClassTest;

/*
 *  Tests for BasketImpl.addProduct() method
 */
public class BasketImpl_addProductTest extends CheckoutSystemBaseClassTest{
	

	@Test
	public void testAddNullBasket() {
		assertTrue(basket.getBasket().isEmpty());
		basket.addProduct(null, 1);
		assertEquals(NULL_PRODUCT_MESSAGE_TEST + "\n", errContent.toString());
		assertTrue(basket.getBasket().isEmpty());
	}

	@Test
	public void testAddOneAppleToAnEmptyBasket() {
		assertTrue(basket.getBasket().isEmpty());
		basket.addProduct(Product.APPLE, 1);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(1, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
	}

	@Test
	public void testAddOneOrangeToAnEmptyBasket() {
		assertTrue(basket.getBasket().isEmpty());
		basket.addProduct(Product.ORANGE, 1);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(1, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.ORANGE));
	}

	@Test
	public void testAddOneAppleAndOneOrangeToAnEmptyBasket() {
		assertTrue(basket.getBasket().isEmpty());
		basket.addProduct(Product.APPLE, 1);
		basket.addProduct(Product.ORANGE, 1);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(2, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		assertTrue(basket.getBasket().containsKey(Product.ORANGE));
	}

	@Test
	public void testAddOneAppleToANonEmptyBasket() {
		assertTrue(basket.getBasket().isEmpty());
		basket.addProduct(Product.ORANGE, 1);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(1, basket.getBasket().size());

		basket.addProduct(Product.APPLE, 1);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(2, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		assertTrue(basket.getBasket().containsKey(Product.ORANGE));
	}

	@Test
	public void testIncrementingAppleCountInBasket() {
		assertTrue(basket.getBasket().isEmpty());
		
		basket.addProduct(Product.APPLE, 1);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(1, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		int currentAppleCount = basket.getBasket().get(Product.APPLE);
		assertEquals(1, currentAppleCount);
		assertTrue(!basket.getBasket().containsKey(Product.ORANGE));		

		basket.addProduct(Product.APPLE, 1);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(1, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		currentAppleCount = basket.getBasket().get(Product.APPLE);
		assertEquals(2, currentAppleCount);
		assertTrue(!basket.getBasket().containsKey(Product.ORANGE));
		
		basket.addProduct(Product.APPLE, 2);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(1, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		currentAppleCount = basket.getBasket().get(Product.APPLE);
		assertEquals(4, currentAppleCount);
		assertTrue(!basket.getBasket().containsKey(Product.ORANGE));
	}
	
	
	@Test
	public void testIncrementingBothAppleAndOrangesCountInBasket() {
		assertTrue(basket.getBasket().isEmpty());
		
		basket.addProduct(Product.APPLE, 1);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(1, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		assertEquals((Integer)1, basket.getBasket().get(Product.APPLE));
		assertTrue(!basket.getBasket().containsKey(Product.ORANGE));
		
		basket.addProduct(Product.ORANGE, 1);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(2, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		assertTrue(basket.getBasket().containsKey(Product.ORANGE));
		assertEquals((Integer)1, (Integer)basket.getBasket().get(Product.APPLE));
		assertEquals((Integer)1, basket.getBasket().get(Product.ORANGE));
		
		
		
		basket.addProduct(Product.APPLE, 2);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(2, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		assertTrue(basket.getBasket().containsKey(Product.ORANGE));		
		assertEquals((Integer)3, (Integer)basket.getBasket().get(Product.APPLE));
		assertEquals((Integer)1, (Integer)basket.getBasket().get(Product.ORANGE));
		
		
		basket.addProduct(Product.ORANGE, 2);
		assertTrue(!basket.getBasket().isEmpty());
		assertEquals(2, basket.getBasket().size());
		assertTrue(basket.getBasket().containsKey(Product.APPLE));
		assertTrue(basket.getBasket().containsKey(Product.ORANGE));
		assertEquals((Integer)3, (Integer)basket.getBasket().get(Product.APPLE));
		assertEquals((Integer)3, (Integer)basket.getBasket().get(Product.ORANGE));
	}
	
	

}
