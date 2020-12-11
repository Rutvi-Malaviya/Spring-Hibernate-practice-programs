package com.rutvi.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author rutvi
 *
 */
public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// get the application context 
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SpringConfig.class);
		
		// retrieve the bean
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// close context
		context.close();

	}

	
}
