package com.bangbang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bangbang.model.Employee;
import com.bangbang.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployee",employeeService.getAllEmployee() );
		return "index";
	}
	
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "newEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee")Employee employee,BindingResult result,Model model) {
		//model.addAttribute("employee", new Employee());
		if(result.hasErrors()) {
			return "index";
		}
		model.addAttribute("employee",new Employee());
		
		employeeService.saveEmployee(employee);
		return "redirect:/";
		
	}

}
