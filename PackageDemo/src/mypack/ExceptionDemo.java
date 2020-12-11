package mypack;

import java.io.IOException;

public class ExceptionDemo {
	
	static void demo() throws IllegalAccessException, IOException 
	{
		throw new IOException("demo");
//		try
//		{
//			throw new IllegalAccessError("demo");
//		}
//		catch(Exception e)
//		{
//			throw e;
//		}
		
//		int a = 5/0;
	}
	
	public static void main(String[] args) throws IllegalAccessException, IOException
	{
	
		demo();
//		try
//		{
//			demo();
//		}
//		catch(Exception e)
//		{
//			System.out.println("Handled");
//		}
		
		System.out.println("Remaining");
	}
}
