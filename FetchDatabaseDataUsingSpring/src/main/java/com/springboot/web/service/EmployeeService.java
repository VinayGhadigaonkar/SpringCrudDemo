package com.springboot.web.service;

import java.util.List;

import com.springboot.web.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();
	
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(long id);
	
	void deleteEmployeeById(long id);
	
	
	
}
