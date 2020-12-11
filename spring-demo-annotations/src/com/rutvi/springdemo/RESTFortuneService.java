package com.rutvi.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "Fortune from RESTFortuneService";
	}

}
