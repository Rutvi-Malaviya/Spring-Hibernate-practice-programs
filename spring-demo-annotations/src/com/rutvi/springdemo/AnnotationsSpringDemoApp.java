package com.rutvi.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author rutvi
 *
 */
public class AnnotationsSpringDemoApp {

	public static void main(String[] args) {
		
		// get the application context 
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve the bean
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// close context
		context.close();

	}

	
}
