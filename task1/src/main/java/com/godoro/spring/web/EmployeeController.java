package com.godoro.spring.web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.godoro.spring.Employee;

@Controller
public class EmployeeController {
	@GetMapping("/employee/get")
	@ResponseBody
	public String getEmployee() {
		long employeeId = 20;
		String url = "http://localhost:8080/api/employee/" + employeeId ; 
		RestTemplate restTemplate = new RestTemplate();
		Employee employee = restTemplate.getForObject(url, Employee.class);
		System.out.println("Personel: " + employee.getEmployeeName());
		return "Edinme Basarili " + employee.getEmployeeName() + " " + employee.getMonthlySalary();
	}
	
	@GetMapping("/employee/post")
	@ResponseBody
	public String postEmployee() {
		Employee employee = new Employee(0, "Montgomery Burns", 25000);
		String url = "http://localhost:8080/api/employee"; 
		RestTemplate restTemplate = new RestTemplate();
		Employee result = restTemplate.postForObject(url, employee, Employee.class);
		return "Yollama Basarili " + result.getEmployeeId();
	}
	
	@GetMapping("/employee/put")
	@ResponseBody
	public String putEmployee() {
		Employee employee = new Employee(12, "Bart Simpson", 14000);
		String url = "http://localhost:8080/api/employee"; 
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Employee>(employee), Void.class);
		return "Güncelleme Basarili ";
	}
	
	@GetMapping("/employee/delete")
	@ResponseBody
	public String deleteEmployee() {
		long employeeId = 12;
		String url = "http://localhost:8080/api/employee/" + employeeId; 
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		return "Silme Basarili ";
	}
}
