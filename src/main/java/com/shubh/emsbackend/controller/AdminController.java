package com.shubh.emsbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubh.emsbackend.dto.AdminDTO;
import com.shubh.emsbackend.dto.LoginDTO;
import com.shubh.emsbackend.response.LoginResponse;
import com.shubh.emsbackend.service.AdminService;
import com.shubh.emsbackend.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping(path = "/save")
	public String saveEmployee(@RequestBody AdminDTO adminDTO)
	{
		String id = adminService.addAdmin(adminDTO);
		return id;
	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<?> loginAdmin(@RequestBody LoginDTO loginDTO)
	{
		LoginResponse loginResponse = adminService.loginAdmin(loginDTO);
		return ResponseEntity.ok(loginResponse);
	}
}
