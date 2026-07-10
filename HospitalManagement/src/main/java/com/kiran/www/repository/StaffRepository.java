package com.kiran.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.kiran.www.dto.StaffRequest;
import com.kiran.www.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {
	
	boolean existsByEmail(String email);

	//void save(StaffRequest staffrequest);

}