package com.generate.invoice.entity.service;

import java.util.List;

import com.generate.invoice.entity.Customer;
import com.generate.invoice.response.CustomerResponse;

public interface CustomerService {

	Customer findById(Long id);
	
	Customer save(Customer customer);
	
	Boolean existsByEmailId(String emailId) throws Exception;
	
	Boolean existsByMobileNumber(String mobileNumber) throws Exception;
	
	Boolean existsByMobileNumberAndIdNot(String mobileNumber, Long Id) throws Exception;
	
	Boolean existsByEmailIdNumberAndIdNot(String emailId, Long Id) throws Exception;
	
	List<Object> findAll();
	
	void softDeleted(Long id);
	

}
