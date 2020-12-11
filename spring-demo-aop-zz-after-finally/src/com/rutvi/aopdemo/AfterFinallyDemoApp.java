package com.rutvi.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rutvi.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call method to find accounts
		List<Account> theAccounts = null;
		
		try {
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception exc) {
			System.out.println("\n\n Main Program ... caught exception " +exc );
		}
		
		// display the accounts
		System.out.println("\n Main program: After Throwing Demo App ");
		System.out.println("------");
		
		System.out.println(theAccounts);
		System.out.println("\n");
		
		// close the context
		context.close();
		
		

	}

}
