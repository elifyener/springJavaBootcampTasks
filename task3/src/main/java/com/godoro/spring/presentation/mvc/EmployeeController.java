package com.godoro.spring.presentation.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godoro.spring.data.entity.Employee;
import com.godoro.spring.data.repository.EmployeeRepository;

@Controller
@RequestMapping("/hogwarts")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees/bydepartment")
	@ResponseBody
	public String getEmployeesByDepartment(){
		long departmentId = 1;
		List<Employee> employees = employeeRepository.findAllByDepartmentId(departmentId);
		double totalSalary = 0;
		for(Employee employee : employees) {
			System.out.println(employee.getEmployeeId() + " "
					+ employee.getEmployeeName() + " "
					+ employee.getMonthlySalary());
			totalSalary += employee.getMonthlySalary();
		}
		double monthlySalary = 0;
		if(employees.size() > 0) {
			monthlySalary = totalSalary / employees.size();
		}
		return "Ortalama Maaş: " + monthlySalary;
	}
}
