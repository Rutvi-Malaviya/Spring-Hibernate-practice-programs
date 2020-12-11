package com.rutvi.springboot.crud.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rutvi.springboot.crud.demo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager em) {
		entityManager=em;
	}
	
	@Override
	public List<Employee> findAll() {
	
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class); 
		
		// create query
		Query<Employee> theQuery = 
				currentSession.createQuery("from Employee", Employee.class);
		
		// execute query and get result
		List<Employee> employees = theQuery.getResultList();
		
		//return result
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class); 
				
		// execute query and get result
		Employee employee = currentSession.get(Employee.class, theId);
				
		//return result
		return employee;
	}

	@Override
	public void save(Employee theEmployee) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class); 
				
		// save employee
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class); 
				
		Query theQuery = 
				currentSession.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}
