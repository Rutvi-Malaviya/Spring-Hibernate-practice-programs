package com.rutvi.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationScopeDemoApp {

	public static void main(String[] args) {
		// load the application config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// check the two references
		
		boolean result = (theCoach==alphaCoach);
		
		System.out.println("The two references are same: " + result);
		System.out.println("Memory reference for theCoach: " + theCoach);
		System.out.println("Memory reference for alphaCoach: " + alphaCoach);

		// close the config file
		context.close();
	}

}
