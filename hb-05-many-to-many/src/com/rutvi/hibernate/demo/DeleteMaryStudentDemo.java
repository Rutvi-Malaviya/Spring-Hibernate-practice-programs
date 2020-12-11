package com.rutvi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rutvi.hibernate.demo.entity.Course;
import com.rutvi.hibernate.demo.entity.Instructor;
import com.rutvi.hibernate.demo.entity.InstructorDetail;
import com.rutvi.hibernate.demo.entity.Review;
import com.rutvi.hibernate.demo.entity.Student;

public class DeleteMaryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// begin transaction
			session.beginTransaction();
			
			// get the student mary from database
			int theId = 2;
			Student tempStudent = session.get(Student.class, theId);
			
			System.out.println("\nLoaded Student: " + tempStudent);
			System.out.println("Course: " + tempStudent.getCourses());
			
			// delete student
			System.out.println("\nDeleting Student: " + tempStudent);
			session.delete(tempStudent);
			
			// commit transaction 
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();    
		}
	}

}
