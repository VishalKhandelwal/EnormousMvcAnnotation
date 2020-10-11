package com.vk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vk.model.Employee;
import com.vk.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/empform")
	public String showform(Model m)
	{
		m.addAttribute("command", new Employee());
		return "empform";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("emp") Employee emp)
	{
		employeeService.save(emp);
		return "redirect:/viewemp";
	}
	
	@RequestMapping("/viewemp")
	public String viewemp(Model m)
	{
		List<Employee> list = employeeService.getEmployees();
		m.addAttribute("list", list);
		return "viewemp";
	}
	
	@RequestMapping(value="/editemp/{id}")
	public String edit(@PathVariable int id, Model m)
	{
		Employee emp = employeeService.getEmpById(id);
		m.addAttribute("command",emp);
		return "empeditform";
	}
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") Employee emp){    
		employeeService.update(emp);    
        return "redirect:/viewemp";    
    }    
	
	 @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id){    
		 employeeService.delete(id);    
	        return "redirect:/viewemp";    
	    }     
}
