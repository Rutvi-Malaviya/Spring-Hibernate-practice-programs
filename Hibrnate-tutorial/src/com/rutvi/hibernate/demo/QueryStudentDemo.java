package com.rutvi.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rutvi.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// begin transaction
			session.beginTransaction();
			
			// query the students
			List<Student> theStudents = session.createQuery("from Student").getResultList();	 
			
			// display the students
			displayStudents(theStudents);
			
			// query where last name = doe
			
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			System.out.println("\n Students having last name Doe");
			displayStudents(theStudents);
			
			// query where last name = doe or first name = daffy
			
			theStudents = session.createQuery("from Student s where s.lastName='Doe' or s.firstName='Daffy'").getResultList();
					
			System.out.println("\n Students having last name Doe or first name daffy");
			displayStudents(theStudents);
			
			// query where emails ends with gmail.com
			
			theStudents = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();
								
			System.out.println("\n Students having email ending with gmail.com");
			displayStudents(theStudents);
			
			// commit transaction 
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();    
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student s: theStudents) {
			System.out.println(s);
		}
	}

}
