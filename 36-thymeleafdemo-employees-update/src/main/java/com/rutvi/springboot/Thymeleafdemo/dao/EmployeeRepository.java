package com.rutvi.springboot.Thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rutvi.springboot.Thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
