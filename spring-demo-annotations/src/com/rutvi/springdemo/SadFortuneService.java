package com.rutvi.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "This is a sad day :(";
	}

}
