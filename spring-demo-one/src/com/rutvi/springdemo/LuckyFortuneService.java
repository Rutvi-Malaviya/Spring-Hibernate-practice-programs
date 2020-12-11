package com.rutvi.springdemo;

import java.util.Random;

public class LuckyFortuneService implements FortuneServices {

	@Override
	public String getDailyFortune() {
		String[] fortune = {"Lucky","Happy", "Unlucky"};
		Random rand = new Random();
		return fortune[rand.nextInt()%(fortune.length)];
	}

}
