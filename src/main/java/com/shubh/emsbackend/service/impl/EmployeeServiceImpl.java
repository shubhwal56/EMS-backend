package com.shubh.emsbackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.*;
import org.springframework.stereotype.Service;

import com.shubh.emsbackend.dto.EmployeeDto;
import com.shubh.emsbackend.entity.Employee;
import com.shubh.emsbackend.exception.ResourceNotFoundException;
import com.shubh.emsbackend.mapper.EmployeeMapper;
import com.shubh.emsbackend.repository.EmployeeRepository;
import com.shubh.emsbackend.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);

		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
			.orElseThrow(() -> 
				new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
		
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exists with given id: "+ employeeId)
		);
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		
		Employee updatedEmpObj = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(updatedEmpObj);
		
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exists with given id: "+ employeeId)
		);
		
		employeeRepository.deleteById(employeeId);
	}
	
	

	
}
