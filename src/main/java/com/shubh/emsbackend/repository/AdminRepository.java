package com.shubh.emsbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.shubh.emsbackend.entity.Admin;

@EnableJpaRepositories
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	Optional<Admin> findOneByEmailAndPassword(String email, String password);
	
	Admin findByEmail(String email);

}

