package com.rutvi.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemo {

	public static void main(String[] args) {
		
		// load the xml configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean object
		CricketCoach coach = context.getBean("cricketCoach", CricketCoach.class);
		
		// call methods on bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		System.out.println(coach.getEmailAddress());
		System.out.println(coach.getTeam());
		
		// close the context file
		context.close();

	}

}
