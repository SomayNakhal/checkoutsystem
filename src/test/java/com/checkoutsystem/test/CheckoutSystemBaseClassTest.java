package com.checkoutsystem.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.checkoutsystem.CheckoutSystem;
import com.checkoutsystem.basket.BasketImpl;
import com.checkoutsystem.print.PrintUtil;
import com.checkoutsystem.product.Product;

/*
 * Base class for constants and setting up streams
 */
public class CheckoutSystemBaseClassTest {


	protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	protected final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	protected final String INVALID_PRODUCT_MESSAAGE_PREFIX_TEST = "Invalid product ignored :";
	protected final String TOTAL_PREFIX_TEXT_TEST = "Total: \u00a3";
	protected final String NULL_PRODUCT_MESSAGE_TEST = "Attempting to add a null product ignored.";
	
	protected final int APPLE_PRICE = 60;
	protected final int ORANGE_PRICE = 25;


	protected BasketImpl basket = new BasketImpl();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}

	@Test
	public void testInvalidProductMessagePrefix() {
		CheckoutSystem.main(new String[]{});
		assertEquals(INVALID_PRODUCT_MESSAAGE_PREFIX_TEST, basket.getInvalidProductMessagePrefix());
	}

	@Test
	public void testTotalPrefixText() {
		CheckoutSystem.main(new String[]{});
		assertEquals(TOTAL_PREFIX_TEXT_TEST, PrintUtil.getTotalPrefixText());
	}
	
	@Test
	public void testNullProductMessage() {
		CheckoutSystem.main(new String[]{});
		assertEquals(NULL_PRODUCT_MESSAGE_TEST, basket.getNullProductMessage());
	}

	@Test
	public void testApplePrice() {
		CheckoutSystem.main(new String[]{});
		assertEquals(APPLE_PRICE, Product.APPLE.getPrice());
	}

	@Test
	public void testOrangePrice() {
		CheckoutSystem.main(new String[]{});
		assertEquals(ORANGE_PRICE, Product.ORANGE.getPrice());
	}
}
