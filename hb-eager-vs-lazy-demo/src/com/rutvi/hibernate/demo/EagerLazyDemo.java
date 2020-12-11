package com.rutvi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rutvi.hibernate.demo.entity.Course;
import com.rutvi.hibernate.demo.entity.Instructor;
import com.rutvi.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// begin transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("instructor: " + tempInstructor);
			
			System.out.println("courses1: " + tempInstructor.getCourses());
			
			// get courses for the instructor 
			
			// commit transaction 
			session.getTransaction().commit();

			// close session
			session.close();
			System.out.println("\n Session is closed \n");
			
			System.out.println("courses: " + tempInstructor.getCourses());

			
			System.out.println("luv2code: Done!");
		}
		finally {
			session.close();
			factory.close();    
		}
	}

}
