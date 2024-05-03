package com.shubh.emsbackend.service;

import java.util.List;

import com.shubh.emsbackend.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee );
	
	void deleteEmployee(Long employeeId);
	
}
