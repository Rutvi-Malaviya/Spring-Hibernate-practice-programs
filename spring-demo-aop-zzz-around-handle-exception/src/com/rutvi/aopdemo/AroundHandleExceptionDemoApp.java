package com.rutvi.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rutvi.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get bean from spring container
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain Program: AroundDemoApp");
		System.out.println("Calling getFortune");
		
		String data=null;
		try {
			boolean tripWire = true;
			data = fortuneService.getFortune(tripWire);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nMy fortune is: " + data);
		
		System.out.println("Finished");
		
		// close the context
		context.close();
		
		

	}

}
