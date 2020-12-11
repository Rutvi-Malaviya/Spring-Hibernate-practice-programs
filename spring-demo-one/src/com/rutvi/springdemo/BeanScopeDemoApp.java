package com.rutvi.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load application context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		// load class
		Coach coach = context.getBean("coach",Coach.class);
		
		Coach coach2 = context.getBean("coach",Coach.class);
		
		boolean isEqual = (coach==coach2);
		
		System.out.println("coach and coach2 are same: " + isEqual);
		System.out.println("address of coach: "+coach);
		System.out.println("address of coach2: "+coach2);
		
		// close the context
		context.close();
		
	}

}
