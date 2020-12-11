package com.rutvi.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "Fortune from DatabaseFortuneService";
	}

}
