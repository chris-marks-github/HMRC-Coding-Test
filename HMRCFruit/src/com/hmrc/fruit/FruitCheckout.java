package com.hmrc.fruit;

import java.text.DecimalFormat;
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
		
		// Apple BOGOF
		int numberOfFreeApples = (int)appleCount/2;
		// ORANGE B2GOF
		int numberOfFreeOranges = (int)orangeCount/3;
		
		double total = (((orangeCount-numberOfFreeOranges)*orangePrice) + ((appleCount-numberOfFreeApples)*applePrice));
				
		System.out.println("Total cost for " + fruits.toString() + " including offers is £" + new DecimalFormat("0.00").format(total)); 
		return total;
		
	}
	
}
