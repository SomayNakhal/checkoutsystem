package com.checkoutsystem.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*
 * Will run all available tests
 */
@RunWith(Suite.class)
@SuiteClasses({ com.checkoutsystem.test.CheckoutSystemBaseClassTest.class, 
				com.checkoutsystem.CheckoutSystemTest.class,
				com.checkoutsystem.basket.BasketImpl_LoadProductsTest.class,
				com.checkoutsystem.basket.BasketImpl_ProcessProductTest.class,
				com.checkoutsystem.basket.BasketImpl_addProductTest.class,
				com.checkoutsystem.basket.BasketImpl_GetTotalTest.class,
				com.checkoutsystem.print.PrintUtilTest.class,
				com.checkoutsystem.offer.OfferManagerTest.class})
public class AllTests {

}
