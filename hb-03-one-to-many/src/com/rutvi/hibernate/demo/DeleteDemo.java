package com.rutvi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rutvi.hibernate.demo.entity.Instructor;
import com.rutvi.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// begin transaction
			session.beginTransaction();
			
			// get the instructor by primary key: id
			int theId = 1;
			
			Instructor theInstructor = session.get(Instructor.class, theId);
			System.out.println("Found instructor: " + theInstructor);
			
			// delete the instructor 
			
			if(theInstructor!=null) {
				System.out.println("Deleting " + theInstructor);
				
				session.delete(theInstructor);
			}
			
			
			// commit transaction 
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();    
		}
	}

}
