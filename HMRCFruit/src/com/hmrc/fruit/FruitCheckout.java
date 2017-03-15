package com.hmrc.fruit;

import java.util.List;

import com.hmrc.exception.FruitException;

public class FruitCheckout {

	double applePrice = 0.60;
	double orangePrice = 0.25;
	
	public double totalFruitPrice(List<String> fruits) throws FruitException {
		
		long orangeCount = fruits.stream().filter(s -> s.equalsIgnoreCase("ORANGE")).count();
		long appleCount = fruits.stream().filter(s -> s.equalsIgnoreCase("APPLE")).count();
		if (fruits.size() != (orangeCount + appleCount)) {
			throw new FruitException("Foreign fruit present");
		}
		double total = orangeCount*orangePrice + appleCount*applePrice;
		System.out.println("Total cost for " + fruits.toString() + " is " + total); 
		return total;
		
	}
	
}
