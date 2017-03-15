package com.hmrc.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hmrc.exception.FruitException;
import com.hmrc.fruit.FruitCheckout;

public class FruitTest {

	List<String> validFruits;
	List<String> invalidFruits;
	FruitCheckout fruitCheckout;
	
	@Before
	public void defineFruitLists() {
	
		validFruits = Arrays.asList("ORANGE", "ORANGE", "apple", "orange", "APPLE");
		invalidFruits = Arrays.asList("ORANGE", "pear", "peach", "SULTANA", "APPLE");
		fruitCheckout = new FruitCheckout();
		
	}
	
	@Test
	public void testValidFruits() {

		try {
			assertTrue(fruitCheckout.totalFruitPrice(validFruits) == 1.95D);
		} catch (FruitException e) {
			fail();
		}
		
	}
	
	@Test
	public void testInvalidFruits() {

		try {
			fruitCheckout.totalFruitPrice(invalidFruits);
			fail();
		} catch (FruitException e) {
			// Nothing
		}
		
	}

}
