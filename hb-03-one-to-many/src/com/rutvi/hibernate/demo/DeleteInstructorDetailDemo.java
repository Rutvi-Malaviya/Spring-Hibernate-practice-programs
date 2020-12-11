package com.rutvi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rutvi.hibernate.demo.entity.Instructor;
import com.rutvi.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			
			// get the instructor detail object
			int theId = 3;
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, theId); 
			
			//print the instructor detail
			System.out.println("Instructor Detail: " + theInstructorDetail);
			
			// print the associated instructor
			System.out.println("Associated instructor: " + theInstructorDetail.getInstructor());
			
			// remove the associated object reference
			// beak the bi-directional link
			theInstructorDetail.getInstructor().setInstructorDetail(null);
			
			// delete the instructor detail
			System.out.println("Deleting the instruction detail object: " + theInstructorDetail);
			session.delete(theInstructorDetail);
			
			
			// commit transaction 
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			factory.close();    
		}
	}

}
