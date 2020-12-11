package com.rutvi.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author rutvi
 *
 */
public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// get the application context 
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SpringConfig.class);
		
		// retrieve the bean
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());
		
		// close context
		context.close();

	}

	
}
