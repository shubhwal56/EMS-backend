package com.shubh.emsbackend.service;

import com.shubh.emsbackend.dto.AdminDTO;
import com.shubh.emsbackend.dto.LoginDTO;
import com.shubh.emsbackend.response.LoginResponse;

public interface AdminService {

	String addAdmin(AdminDTO adminDto);
	
	LoginResponse loginAdmin(LoginDTO loginDTO);
}
