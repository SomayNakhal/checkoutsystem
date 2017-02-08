package com.checkoutsystem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.checkoutsystem.test.CheckoutSystemBaseClassTest;

/*
 *  high level functional tests
 */
public class CheckoutSystemTest extends CheckoutSystemBaseClassTest {

	@Test
	public void testNoProducts() {
		CheckoutSystem.main(new String[]{});
		assertEquals(TOTAL_PREFIX_TEXT_TEST+"0.00\n", outContent.toString());
		assertEquals("", errContent.toString());

	}

	@Test
	public void testOneInvalidProduct() {
		CheckoutSystem.main(new String[]{"prod1"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST+"0.00\n", outContent.toString());
		assertEquals(INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod1\n", errContent.toString());
	}

	@Test
	public void testTwoInvalidProducts() {
		CheckoutSystem.main(new String[]{"prod1", "prod2"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST+"0.00\n", outContent.toString());
		assertEquals(INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod1\n"+INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod2\n", errContent.toString());

	}

	@Test
	public void testOneValidProductSmallCase() {
		CheckoutSystem.main(new String[]{"apple"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",APPLE_PRICE/100.0), outContent.toString());
		assertEquals("", errContent.toString());
	}

	@Test
	public void testOneValidProductUpperCase() {
		CheckoutSystem.main(new String[]{"APPLE"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",APPLE_PRICE/100.0), outContent.toString());
		assertEquals("", errContent.toString());
	}

	@Test
	public void testOneValidProductMixedCase() {
		CheckoutSystem.main(new String[]{"Apple"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",APPLE_PRICE/100.0), outContent.toString());
		assertEquals("", errContent.toString());
	}

	@Test
	public void testOneValidProductOneInvalidProduct() {
		CheckoutSystem.main(new String[]{"apple", "prod1"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",APPLE_PRICE/100.0), outContent.toString());
		assertEquals(INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod1\n", errContent.toString());
	}

	@Test
	public void testOneValidProductTwoInvalidProduct() {
		CheckoutSystem.main(new String[]{"apple", "prod1", "prod2"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",APPLE_PRICE/100.0), outContent.toString());
		assertEquals(INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod1\n"+INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod2\n", errContent.toString());
	}

	@Test
	public void testTwoValidProducts() {
		CheckoutSystem.main(new String[]{"apple", "orange"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",(APPLE_PRICE + ORANGE_PRICE)/100.0), outContent.toString());
		assertEquals("", errContent.toString());
	}

	@Test
	public void testTwoValidProductsOrderSwaped() {
		CheckoutSystem.main(new String[]{"orange", "apple"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",(APPLE_PRICE + ORANGE_PRICE)/100.0), outContent.toString());
		assertEquals("", errContent.toString());
	}

	@Test
	public void testTwoValidProductsOneInvalidProduct() {
		CheckoutSystem.main(new String[]{"apple", "orange", "prod1"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",(APPLE_PRICE + ORANGE_PRICE)/100.0), outContent.toString());
		assertEquals(INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod1\n", errContent.toString());
	}

	@Test
	public void testTwoValidProductsTwoInvalidProduct() {
		CheckoutSystem.main(new String[]{"apple", "orange", "prod1", "prod2"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",(APPLE_PRICE + ORANGE_PRICE)/100.0), outContent.toString());
		assertEquals(INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod1\n"+INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod2\n", errContent.toString());
	}

	@Test
	public void testOneValidProductRepeadedTwice() {
		CheckoutSystem.main(new String[]{"apple", "apple"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",(APPLE_PRICE + APPLE_PRICE)/100.0), outContent.toString());
		assertEquals("", errContent.toString());
	}

	@Test
	public void testOneValidProductRepeadedTwiceWithAnotherValidProduct() {
		CheckoutSystem.main(new String[]{"apple", "apple", "orange"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",(APPLE_PRICE + APPLE_PRICE + ORANGE_PRICE)/100.0), outContent.toString());
		assertEquals("", errContent.toString());
	}

	@Test
	public void testOneValidProductRepeadedTwiceWithAnotherValidProductAndOneInvalidProduct() {
		CheckoutSystem.main(new String[]{"apple", "apple", "orange", "prod1"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",(APPLE_PRICE + APPLE_PRICE + ORANGE_PRICE)/100.0), outContent.toString());
		assertEquals(INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod1\n", errContent.toString());
	}

	@Test
	public void testOneValidProductRepeadedThrice() {
		CheckoutSystem.main(new String[]{"apple", "apple", "apple"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",(APPLE_PRICE + APPLE_PRICE + APPLE_PRICE)/100.0), outContent.toString());
		assertEquals("", errContent.toString());
	}

	@Test
	public void testOneValidProductRepeadedThriceWithAnotherValidProduct() {
		CheckoutSystem.main(new String[]{"apple", "apple", "apple", "orange"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",(APPLE_PRICE + APPLE_PRICE + APPLE_PRICE + ORANGE_PRICE)/100.0), outContent.toString());
		assertEquals("", errContent.toString());
	}

	@Test
	public void testOneValidProductRepeadedThriceWithAnotherValidProductAndOneInvalidProduct() {
		CheckoutSystem.main(new String[]{"apple", "apple", "apple", "orange", "prod1"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",(APPLE_PRICE + APPLE_PRICE + APPLE_PRICE + ORANGE_PRICE)/100.0), outContent.toString());
		assertEquals(INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod1\n", errContent.toString());
	}

	@Test
	public void testTwoValidProductsRepeadedTwiceEach() {
		CheckoutSystem.main(new String[]{"apple", "apple", "orange", "orange"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",(APPLE_PRICE + APPLE_PRICE + ORANGE_PRICE + ORANGE_PRICE)/100.0), outContent.toString());
		assertEquals("", errContent.toString());
	}

	@Test
	public void testTwoValidProductsRepeadedTwiceEachWithOneInvalidProduct() {
		CheckoutSystem.main(new String[]{"apple", "apple", "orange", "orange", "prod1"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",(APPLE_PRICE + APPLE_PRICE + ORANGE_PRICE + ORANGE_PRICE)/100.0), outContent.toString());
		assertEquals(INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod1\n", errContent.toString());
	}

	@Test
	public void testTwoValidProductsRepeadedTwiceEachWithTwoInvalidProducts() {
		CheckoutSystem.main(new String[]{"apple", "apple", "orange", "orange", "prod1", "prod2"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",(APPLE_PRICE + APPLE_PRICE + ORANGE_PRICE + ORANGE_PRICE)/100.0), outContent.toString());
		assertEquals(INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod1\n"+INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod2\n", errContent.toString());
	}

	@Test
	public void testTwoValidProductsRepeadedThriceEach() {
		CheckoutSystem.main(new String[]{"apple", "apple","apple", "orange", "orange", "orange"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",(APPLE_PRICE + APPLE_PRICE + APPLE_PRICE + ORANGE_PRICE + ORANGE_PRICE + ORANGE_PRICE)/100.0), outContent.toString());
		assertEquals("", errContent.toString());
	}

	@Test
	public void testTwoValidProductsRepeadedThriceEachWithOneInvalidProduct() {
		CheckoutSystem.main(new String[]{"apple", "apple","apple", "orange", "orange", "orange", "prod1"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",(APPLE_PRICE + APPLE_PRICE + APPLE_PRICE + ORANGE_PRICE + ORANGE_PRICE + ORANGE_PRICE)/100.0), outContent.toString());
		assertEquals(INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod1\n", errContent.toString());
	}

	@Test
	public void testTwoValidProductsRepeadedThriceEachWithTwoInvalidProducts() {
		CheckoutSystem.main(new String[]{"apple", "apple","apple", "orange", "orange", "orange", "prod1", "prod2"});
		assertEquals(TOTAL_PREFIX_TEXT_TEST + String.format("%.2f\n",(APPLE_PRICE + APPLE_PRICE + APPLE_PRICE + ORANGE_PRICE + ORANGE_PRICE + ORANGE_PRICE)/100.0), outContent.toString());
		assertEquals(INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod1\n"+INVALID_PRODUCT_MESSAAGE_PREFIX_TEST+"prod2\n", errContent.toString());
	}

}
