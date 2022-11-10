package com.bangbang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bangbang.model.Employee;



public interface EmployeeService {
	List<Employee> getAllEmployee();
	void saveEmployee(Employee employee);

}
