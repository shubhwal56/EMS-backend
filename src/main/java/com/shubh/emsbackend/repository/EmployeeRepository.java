package com.shubh.emsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shubh.emsbackend.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
}
