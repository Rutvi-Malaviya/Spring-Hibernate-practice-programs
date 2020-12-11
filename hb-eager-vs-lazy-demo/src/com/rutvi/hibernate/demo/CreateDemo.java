package com.rutvi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rutvi.hibernate.demo.entity.Instructor;
import com.rutvi.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

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
			// create the objects 
//			Instructor tempInstructor = new Instructor("Rutvi", "Malaviya", "rjm647@nyu.edu");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://rutvimalaviya/youtube", "craft");
			
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhup481@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "music");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// begin transaction
			session.beginTransaction();
			
			// save the instructor
			// will also save the detail object because of cascade type all
			System.out.println("Saving instructor "+ tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction 
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();    
		}
	}

}
