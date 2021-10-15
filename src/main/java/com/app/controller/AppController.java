package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.employeeModel.Employee;
import com.app.serviceImpl.EmployeeServiceImpl;

@Controller
public class AppController {
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

	@RequestMapping("/")
	public String view() {
		System.out.println("hello");
		return "index";
	}

	@RequestMapping("/abc")
	public String view1(ModelMap m) {
		Employee e = new Employee();
		e.setName("sss");
		m.addAttribute("employee", e);
		return "index";
	}

	@GetMapping("/add")
	public ModelAndView addEmployee(HttpServletRequest request, ModelMap m)
			throws ClassNotFoundException, SQLException {
		ModelAndView mv = new ModelAndView();
		String message = null;
		Employee employee = new Employee();
		employee.setName(request.getParameter("name"));
		employee.setAddress(request.getParameter("address"));
		if (request.getParameter("action").equals("save")&& message==null) {
			if (employeeService.addEmployee(employee)) {
				message = "Record added";
			} else {
				message = "record not added";
			}
		} else if (request.getParameter("action").equals("edit")) {
			if (employeeService.editEmployee(employee)) {
				message = "update succesfully";
			} else {
				message = "not updated";
			}
		}
		mv.addObject("message", message);
		mv.setViewName("index");
		return mv;
	}

	@GetMapping("/allEmp")
	public ModelAndView getAllEmployee(ModelMap m) throws SQLException {
		ModelAndView mv = new ModelAndView();
		mv.addObject("empList", employeeService.getAllEmployee());
		mv.setViewName("allEmp");
		return mv;
	}

	@GetMapping("/edit")
	public ModelAndView getEmployeeById(HttpServletRequest request, ModelMap m) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee", employeeService.getEmployeeById(Integer.parseInt(request.getParameter("id"))));
		mv.addObject("isEdit", true);
		mv.setViewName("index");
		return mv;
	}
}
