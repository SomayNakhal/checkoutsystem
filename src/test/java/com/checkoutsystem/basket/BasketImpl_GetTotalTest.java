package com.checkoutsystem.basket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.checkoutsystem.product.Product;
import com.checkoutsystem.test.CheckoutSystemBaseClassTest;

/*
 *  Tests for BasketImpl.getTotal() method
 */
public class BasketImpl_GetTotalTest extends CheckoutSystemBaseClassTest {

	@Test //move up
	public void testBasketIsEmptyWhenCreated() {
		assertTrue(basket.getBasket().isEmpty());		
	}

	@Test
	public void testEmptyBasketTotal() {
		assertTrue(basket.getBasket().isEmpty());
		assertEquals(0, basket.getTotal());
	}

	@Test
	public void testBasketTotalOneApple() {
		assertTrue(basket.getBasket().isEmpty());
		basket.getBasket().put(Product.APPLE, 1);
		assertEquals(APPLE_PRICE, basket.getTotal());
	}

	@Test
	public void testBasketTotalOneOrange() {
		assertTrue(basket.getBasket().isEmpty());
		basket.getBasket().put(Product.ORANGE, 1);
		assertEquals(ORANGE_PRICE, basket.getTotal());
	}

	@Test
	public void testBasketTotalTwoApples() {
		assertTrue(basket.getBasket().isEmpty());
		basket.getBasket().put(Product.APPLE, 2);
		assertEquals(APPLE_PRICE + APPLE_PRICE, basket.getTotal());
	}

	@Test
	public void testBasketTotalTwoOranges() {
		assertTrue(basket.getBasket().isEmpty());
		basket.getBasket().put(Product.ORANGE, 2);
		assertEquals(ORANGE_PRICE + ORANGE_PRICE, basket.getTotal());
	}

	@Test
	public void testBasketTotalOneAppleOneOranges() {
		assertTrue(basket.getBasket().isEmpty());
		basket.getBasket().put(Product.APPLE, 1);
		basket.getBasket().put(Product.ORANGE, 1);
		assertEquals(ORANGE_PRICE + APPLE_PRICE, basket.getTotal());
	}

	@Test
	public void testBasketTotalTwoApplesOneOranges() {
		assertTrue(basket.getBasket().isEmpty());
		basket.getBasket().put(Product.APPLE, 2);
		basket.getBasket().put(Product.ORANGE, 1);
		assertEquals(ORANGE_PRICE + APPLE_PRICE + APPLE_PRICE, basket.getTotal());
	}

	@Test
	public void testBasketTotalOneAppleTwoOranges() {
		assertTrue(basket.getBasket().isEmpty());
		basket.getBasket().put(Product.APPLE, 1);
		basket.getBasket().put(Product.ORANGE, 2);
		assertEquals(ORANGE_PRICE + ORANGE_PRICE + APPLE_PRICE, basket.getTotal());
	}

	@Test
	public void testBasketTotalTwoApplesTwoOranges() {
		assertTrue(basket.getBasket().isEmpty());
		basket.getBasket().put(Product.APPLE, 2);
		basket.getBasket().put(Product.ORANGE, 2);
		assertEquals(ORANGE_PRICE + ORANGE_PRICE + APPLE_PRICE + APPLE_PRICE, basket.getTotal());
	}

}
