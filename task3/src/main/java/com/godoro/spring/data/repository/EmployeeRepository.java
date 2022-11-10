package com.godoro.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.godoro.spring.data.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query("select p from Employee p where p.department.departmentId = :departmentId ")
	List<Employee> findAllByDepartmentId(@Param("departmentId") long departmentId);	
}
