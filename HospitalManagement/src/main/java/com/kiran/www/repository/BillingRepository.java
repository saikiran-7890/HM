package com.kiran.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiran.www.entity.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing,Long> {

}
