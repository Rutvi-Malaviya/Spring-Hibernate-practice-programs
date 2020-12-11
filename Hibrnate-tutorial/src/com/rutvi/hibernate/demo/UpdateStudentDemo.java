package com.rutvi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rutvi.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			
			// get new session and begin transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve the student object using id: primary key
			System.out.println("\n Getting student with id: " + studentId);
			Student theStudent = session.get(Student.class, studentId);
			System.out.println("Updating student... ");
			theStudent.setFirstName("Scooby");
			
			// commit transaction
			session.getTransaction().commit();
			
			// NEW CODE
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Updating email of all the students");
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		finally {
			factory.close();    
		}
	}

}
