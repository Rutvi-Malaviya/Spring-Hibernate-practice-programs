package com.rutvi.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		// load application context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

		// load class
		Coach coach = context.getBean("coach",Coach.class);
		
		System.out.println(coach.getDailyFortune());
		
		// close the context
		context.close();
		
	}

}
