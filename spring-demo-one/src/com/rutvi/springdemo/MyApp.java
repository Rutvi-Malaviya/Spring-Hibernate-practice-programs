package com.rutvi.springdemo;

public class MyApp {

	public static void main(String[] args) {
		// Create the coach object
		Coach coach = new TrackCoach();
		
		// Use the coach object
		System.out.println(coach.getDailyWorkout());

	}

}
