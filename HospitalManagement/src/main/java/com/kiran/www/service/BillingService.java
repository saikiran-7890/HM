package com.kiran.www.service;

//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kiran.www.entity.Billing;
import com.kiran.www.repository.BillingRepository;

@Service
public class BillingService {
	
	@Autowired
	private BillingRepository billingRepository;
	
	public Billing GenerateBill(Billing billing){
		
		
		return billingRepository.save(billing);	
		
	}
	
	public Billing GetBill(Long BillingId) {
		
		return billingRepository.findById(BillingId).get();
		
	}
	
//	public ResponseEntity<String> UpdateParticularColumn(Long BillId,Map<String,Object>BillData){
//		
//		Billing bill = billingRepository.findById(BillId).get();
//		
//		if(bill==null) {
//			
//			BillData.forEach((key,value)->{
//				
//				switch (key) {
//				
//				case "BillId":
//				break;
//								
//				case "PatientId":
//				break;		
//				
//				case "ConsultationFee":
//				break;
//				
//				case "MedicineCharge":
//				break;
//					
//				case "RoomCharge":
//				break;
//					
//				case "LabCharge":
//				break;
//					
//				case "TotalAmount":
//				break;
//				
//				case "PaymentStatus":
//				break;
//		
//				case "PaymentDate":
//				break;
//
//
//				default:
//				break;
//				}			
//				
//			});
//			
//		}
//		
//	}
	
	public Billing UpdatePaymentStatus(Billing Billing){
	
		Billing bill = billingRepository.findById(Billing.getBillId()).get();
		
		bill.setConsultationFee(Billing.getConsultationFee());
		bill.setMedicineCharge(Billing.getMedicineCharge());
		bill.setRoomCharge(Billing.getRoomCharge());
		bill.setLabCharge(Billing.getLabCharge());
		bill.setTotalAmount(Billing.getTotalAmount());
		bill.setPaymentStatus(Billing.getPaymentStatus());
		bill.setPaymentDate(Billing.getPaymentDate());
		
		return billingRepository.save(Billing);
		
	}
	
	public String DeleteBills(Long BillId){
				
		if(!billingRepository.existsById(BillId)) {
			
			return "Bill Record is not found";		
			
		}else {
			Billing bill = billingRepository.findById(BillId).get();
			billingRepository.delete(bill);

			return " Patient Bill Id Sucessfully";
		
		}
			
		
	}
	
	
	

}
