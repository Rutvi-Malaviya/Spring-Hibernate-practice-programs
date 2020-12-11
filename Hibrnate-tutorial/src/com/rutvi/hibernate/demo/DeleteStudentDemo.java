package com.rutvi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rutvi.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// delete student
//			System.out.println("Deleting student: " + theStudent);
//			session.delete(theStudent);
//			
			// delete student with id 2
			
			session.createQuery("delete Student where id=2").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		finally {
			factory.close();    
		}
	}

}
