package com.kiran.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiran.www.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
	boolean existsByEmail(String email);

}
