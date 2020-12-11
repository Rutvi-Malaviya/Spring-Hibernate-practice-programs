package com.rutvi.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
//	@Value("${foo.email}")
//	private String email;
	
	public TennisCoach() {
		System.out.println("<< TennisCoach: Inside default constructor");
	}
	
//	init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside doMyStartupStuff()");
	}
	
//	destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside doMyCleanupStuff()");
	}
	
	
	
//	@Autowired
//	public TennisCoach(@Qualifier("randomFortuneService")FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

//	@Autowired
//	public void randomMethod(FortuneService fortuneService) {
//		System.out.println("<< TennisCoach: Inside randomMethod");
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		return "Practice 15 minutes of backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}
	
//	@Override
//	public String getEmail() {
//		
//		return email;
//		
//	}

}
