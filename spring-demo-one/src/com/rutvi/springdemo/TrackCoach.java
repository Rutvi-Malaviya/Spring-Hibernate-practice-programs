package com.rutvi.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneServices fortuneService;
	
	public TrackCoach() {
		
	}

	public TrackCoach(FortuneServices fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run for 5km";
	}

	@Override
	public String getDailyFortune() {
		return "Go Ahead - " + fortuneService.getDailyFortune();
	}

//	init method
	public void doStartUp() {
		System.out.println("Inside init method");
	}
	
//	destroy method
	public void doCleanUp() {
		System.out.println("Inside destroy method");
	}
}