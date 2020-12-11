package com.rutvi.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneServices fortuneService;
	
	public BaseballCoach() {
		
	}
	
//	Constructor
	public BaseballCoach(FortuneServices fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Perform 30 minutes of batting practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}
}
