package com.yycode.springboot.thymeleafdemo.dao;

import java.util.List;

import com.yycode.springboot.thymeleafdemo.entity.Employee;



public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}
