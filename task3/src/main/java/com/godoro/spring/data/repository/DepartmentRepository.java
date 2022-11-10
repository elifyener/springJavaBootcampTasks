package com.godoro.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.godoro.spring.data.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
