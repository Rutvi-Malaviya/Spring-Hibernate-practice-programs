package com.rutvi.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rutvi.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query ... sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",
																Customer.class);
		
		// get result list using query
		List<Customer> customers = theQuery.getResultList();
		
		// return result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update customer
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve from database using primary key 
		Customer customer = currentSession.get(Customer.class, theId);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Customer> searchCustomers(String name) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		// search only if name is not empty
		if(name!=null && name.trim().length()>0) {
			
			// search for firstName or lastName
			theQuery = currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
			
			theQuery.setParameter("theName", "%"+name.toLowerCase()+"%");
			
		}
		else {
			// name is null so get all the customers
			
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

}
