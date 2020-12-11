package com.rutvi.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.rutvi.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@AfterThrowing(
			pointcut="execution(* com.rutvi.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="exc"
			)
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable exc) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======> Executing @AfterThrowing on method "+ method);
		
		System.out.println("\n======> Exception is "+ exc);
	}
	
	@AfterReturning(
			pointcut="execution(* com.rutvi.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		// print method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======> Executing @AfterReturning on method "+ method);
		
		// print out the result of method call
		System.out.println("\n======> Result is "+ result);
		
		// modify the return data, post-process
		
		// convert the account names to upper case
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n======> Result is "+ result);
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		// loop through accounts 
		for(Account temp: result) {
			// get uppercase version of name
			// update name on the account object
			temp.setName(temp.getName().toUpperCase());
		}
		
	}

	@Before("com.rutvi.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: "+methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop through args
		for(Object temp: args) {
			System.out.println(temp);
			
			if(temp instanceof Account) {
				// downcast and print specific stuff
				Account theAccount = (Account) temp;
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
	
	}
	
}
