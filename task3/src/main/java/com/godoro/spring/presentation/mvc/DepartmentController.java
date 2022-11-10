package com.godoro.spring.presentation.mvc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godoro.spring.data.entity.Employee;
import com.godoro.spring.data.entity.Department;
import com.godoro.spring.data.repository.DepartmentRepository;

@Controller
@RequestMapping("/hogwarts")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@GetMapping("/department/insert")
	@ResponseBody
	public String insertDepartment(){
		Department gryffindor = new Department(0, "Gryffindor");
		gryffindor.setEmployeeList(new ArrayList<>());
		
		Employee employee1 = new Employee(0, "James Potter", 15000);
		employee1.setDepartment(gryffindor);
		gryffindor.getEmployeeList().add(employee1);
		
		Employee employee2 = new Employee(0, "Sirius Black", 13000);
		employee2.setDepartment(gryffindor);
		gryffindor.getEmployeeList().add(employee2);
		
		Employee employee3 = new Employee(0, "Minerva McGonagall", 14500);
		employee3.setDepartment(gryffindor);
		gryffindor.getEmployeeList().add(employee3);
		
		departmentRepository.save(gryffindor);
		
		return "Eklendi: " + gryffindor.getDepartmentId();
	}
}
