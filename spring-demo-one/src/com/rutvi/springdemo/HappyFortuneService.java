package com.rutvi.springdemo;

public class HappyFortuneService implements FortuneServices {

	@Override
	public String getDailyFortune() {
		return "Today is your luck day!";
	}

}
