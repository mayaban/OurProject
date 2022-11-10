package com.bangbang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.model.Employee;
import com.bangbang.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}

}
