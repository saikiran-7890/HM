package com.kiran.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.www.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {

}
