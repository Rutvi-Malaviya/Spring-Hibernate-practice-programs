package com.rutvi.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
//	generate array of random fortunes
	
	String[] data = {
			"Beware of wolf in sheep's clothing",
			"Diligence is the mother of fortune",
			"Meet the world with full enthusiasm"
	};
	
//	create random number generator
	Random myRandom = new Random();
	
	@Override
	public String getDailyFortune() {
		
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
