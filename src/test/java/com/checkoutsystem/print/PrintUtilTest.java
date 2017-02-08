package com.checkoutsystem.print;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.checkoutsystem.test.CheckoutSystemBaseClassTest;


/*
 *  PrintUtil tests
 */
public class PrintUtilTest extends CheckoutSystemBaseClassTest {

	@Test
	public void testPrintZeroTotal() {
		PrintUtil.printTotal(0);

		assertEquals(TOTAL_PREFIX_TEXT_TEST + "0.00\n", outContent.toString());
	}

	@Test
	public void testPrint99PenceTotal() {
		PrintUtil.printTotal(99);

		assertEquals(TOTAL_PREFIX_TEXT_TEST + "0.99\n", outContent.toString());
	}

	@Test
	public void testPrintOnePoundTotal() {
		PrintUtil.printTotal(100);

		assertEquals(TOTAL_PREFIX_TEXT_TEST + "1.00\n", outContent.toString());
	}

	@Test
	public void testPrintOnePoundFiftyPenceTotal() {
		PrintUtil.printTotal(150);

		assertEquals(TOTAL_PREFIX_TEXT_TEST + "1.50\n", outContent.toString());
	}

	@Test
	public void testPrintTwoPoundsTotal() {
		PrintUtil.printTotal(200);

		assertEquals(TOTAL_PREFIX_TEXT_TEST + "2.00\n", outContent.toString());
	}
	
	@Test
	public void testPrintTenPoundsTotal() {
		PrintUtil.printTotal(1000);

		assertEquals(TOTAL_PREFIX_TEXT_TEST + "10.00\n", outContent.toString());
	}
	
	@Test
	public void testPrintHundredPoundsTotal() {
		PrintUtil.printTotal(10000);

		assertEquals(TOTAL_PREFIX_TEXT_TEST + "100.00\n", outContent.toString());
	}
	
	@Test
	public void testPrintThousandPoundsTotal() {
		PrintUtil.printTotal(100000);

		assertEquals(TOTAL_PREFIX_TEXT_TEST + "1000.00\n", outContent.toString());
	}

}
