package com.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.web.model.Employee;
import com.springboot.web.service.EmployeeService;
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listEmployees",employeeService.getAllEmployee());
		return "index";
	}
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) 
	{
		//create model attribute to bind form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	
	 @PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee")Employee employee)
	{
		 // to handle the form data we use @ModelAttribute
		 //save employee to database
		 employeeService.saveEmployee(employee);
		 return "redirect:/";//redirec to the home page 
		
	}
	 @GetMapping("/showFormForUpdate/{id}")
	 public String showFormForUpdate(@PathVariable (value = "id")long id,Model model)
	 {
		 //get Employee from the service
		 Employee employee = employeeService.getEmployeeById(id);
		 
		 //set employee as a model attribute to pre-populate the form
		 model.addAttribute("employee", employee);
		 return "update_employee";
	 }
	 
	 @GetMapping("/deleteEmployee/{id}")
	 public String deleteEmployee(@PathVariable (value = "id") long id)
	 {
		 this.employeeService.deleteEmployeeById(id);
		 //call delete method employee
		 return "redirect:/";
		 
	 }
	
	
}
