
package com.kiran.www.controller;

//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.www.entity.Billing;
import com.kiran.www.service.BillingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/billing")
public class BillingConrtroller {
	
	@Autowired
	private BillingService billingService;
	
	@PostMapping("/Sendbill")
	public ResponseEntity<Billing> GenerateBill(@RequestBody @Valid Billing billing) {
		
		return new ResponseEntity<>(billingService.GenerateBill(billing),HttpStatus.CREATED);
				
	}
	
	@GetMapping("/getbill/{billId}")
	public Billing GetBill(@PathVariable Long BillId) {
		
		return billingService.GetBill(BillId);
	}
	
	@PutMapping("/update")
	public Billing UpdatePaymentStatus(@RequestBody Billing Billing){
		
		return billingService.UpdatePaymentStatus(Billing);
	}
	
	
	
//	@PatchMapping("/Column/{BillId}")
//	public ResponseEntity<String>UpdateParticularColumn(@PathVariable Long BillId,@RequestBody Map<String,Object>BillData) {
//		
//		return billingService.UpdateParticularColumn(BillId,BillData);
//		
//	}
	
	@DeleteMapping("/delete/{BillId}")
	public String DeleteBills(@PathVariable Long BillId){
		return billingService.DeleteBills(BillId);
		
	}
	

}
