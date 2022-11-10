package com.godoro.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.spring.Employee;

@RestController
public class EmployeeResource {
	
	@GetMapping("/api/employee/{id}")
	public Employee getEmployee(@PathVariable("id")long employeeId) {
		Employee employee = new Employee(employeeId, "Lisa Simpson", 20000);
		return employee;
	}
	
	@GetMapping("/api/employees")
	public List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(11,"Homer Simpson",15000));
		employeeList.add(new Employee(12,"Bart Simpson",12000));
		employeeList.add(new Employee(13,"Marge Simpson",18000));
		return employeeList;
	}
	
	@PostMapping("/api/employee")
	public Employee postEmployee(@RequestBody Employee employee) {
		employee.setEmployeeId(1);
		System.out.println("Personel eklendi: " + employee.getEmployeeId() + " "
				+ employee.getEmployeeName() + " "
				+ employee.getMonthlySalary());
		return employee;
	}
	
	@PutMapping("/api/employee")
	public void putEmployee(@RequestBody Employee employee) {
		System.out.println("Personel güncellendi: " + employee.getEmployeeId() + " "
				+ employee.getEmployeeName() + " "
				+ employee.getMonthlySalary());
	}
	
	@DeleteMapping("/api/employee/{id}")
	public void deleteEmployeet(@PathVariable("id")long employeeId) {
		System.out.println("Personel silindi " + employeeId);
	}
}
