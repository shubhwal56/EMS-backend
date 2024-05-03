package com.shubh.emsbackend.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shubh.emsbackend.dto.AdminDTO;
import com.shubh.emsbackend.dto.LoginDTO;
import com.shubh.emsbackend.entity.Admin;
import com.shubh.emsbackend.repository.AdminRepository;
import com.shubh.emsbackend.response.LoginResponse;
import com.shubh.emsbackend.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String addAdmin(AdminDTO adminDto) {
		
		Admin admin = new Admin(
				adminDto.getAdminId(),
				adminDto.getAdminName(),
				adminDto.getEmail(),
				
				this.passwordEncoder.encode(adminDto.getPassword())
				);
		
		adminRepo.save(admin);
		
		return admin.getAdminName();
	}

	@Override
	public LoginResponse loginAdmin(LoginDTO loginDTO) {
		String msg = "";
		Admin admin1 = adminRepo.findByEmail(loginDTO.getEmail());
		
		if(admin1 != null) {
			String password = loginDTO.getPassword();
			String encodedPassword = admin1.getPassword();
			Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
			if(isPwdRight) {
				Optional<Admin>admin = adminRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
				if(admin.isPresent()) {
					return new LoginResponse("Login success", true);
				} else {
					return new LoginResponse("Login Failed", false);
				}
			} else {
				return new LoginResponse("password not match", false);
			}
		} else {
			return new LoginResponse("Email not exists", false);
		}
	}
	
	
	
	
}