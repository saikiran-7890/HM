package com.kiran.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiran.www.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
	
	boolean existsByEmail(String email);

}