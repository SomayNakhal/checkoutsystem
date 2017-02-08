package com.checkoutsystem.basket;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.checkoutsystem.product.Product;
import com.checkoutsystem.test.CheckoutSystemBaseClassTest;

/*
 *  Tests for BasketImpl.processProduct() method
 */
public class BasketImpl_ProcessProductTest extends CheckoutSystemBaseClassTest {


	@Test
	public void testProcessEmptyProductString() {
		assertEquals(null, basket.processProduct(""));
		assertEquals(INVALID_PRODUCT_MESSAAGE_PREFIX_TEST + "\n", errContent.toString());
	}

	@Test
	public void testProcessNullProduct() {
		assertEquals(null, basket.processProduct(null));
		assertEquals(INVALID_PRODUCT_MESSAAGE_PREFIX_TEST + "null\n", errContent.toString());
	}

	@Test
	public void testProcessValidProductLowerCaseApple() {
		assertEquals(Product.APPLE, basket.processProduct("apple"));
		assertEquals("", errContent.toString());
	}

	@Test
	public void testProcessValidProductUpperCaseApple() {
		assertEquals(Product.APPLE, basket.processProduct("APPLE"));
		assertEquals("", errContent.toString());
	}

	@Test
	public void testProcessValidProductMixedCaseApple() {
		assertEquals(Product.APPLE, basket.processProduct("Apple"));
		assertEquals("", errContent.toString());
	}

	@Test
	public void testProcessValidProductLowerCaseOrange() {
		assertEquals(Product.ORANGE, basket.processProduct("orange"));
		assertEquals("", errContent.toString());
	}

	@Test
	public void testProcessValidProductUpperCaseOrange() {
		assertEquals(Product.ORANGE, basket.processProduct("ORANGE"));
		assertEquals("", errContent.toString());
	}

	@Test
	public void testProcessValidProductMixedCaseOrange() {
		assertEquals(Product.ORANGE, basket.processProduct("Orange"));
		assertEquals("", errContent.toString());
	}

}
