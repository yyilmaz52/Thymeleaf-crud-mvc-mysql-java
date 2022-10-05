package com.yycode.springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yycode.springboot.thymeleafdemo.entity.Employee;
import com.yycode.springboot.thymeleafdemo.service.EmployeeService;



@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	
	
	//add mapping for "/list"
	@GetMapping("/list")
	public String getEmployees(Model theModel){
		
		//add to the spring model
		theModel.addAttribute("employees",employeeService.findAll());
		
		return "employees/list-employees";
		
	}
	
	//add mapping for "/showFormForAdd"
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
			
		Employee theEmployee = new Employee();
		//add to the spring model
		theModel.addAttribute("employee",theEmployee);
			
		return "employees/form-add";
	
	}
		
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee")Employee theEmployee) {
		
		//save the employee
		employeeService.save(theEmployee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId")int theId,
									Model theModel) {
		//get the employee
		Employee theEmployee = employeeService.findById(theId);
		
		// set employee as a model attribute to pre-populate
		theModel.addAttribute("employee", theEmployee);
		
		//send over to our form
		return "employees/form-add";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		//delete the employee
		employeeService.deleteById(theId);
		
		//redirect to employees/list
		return "redirect:/employees/list";
	}
	
	
}
















