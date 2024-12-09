package com.generate.invoice.entity.service;

import java.util.List;

import com.generate.invoice.entity.Vendor;
import com.generate.invoice.response.VendorResponse;

public interface VendorService {

	Vendor findById(Long id);
	
	Vendor save(Vendor vendor);
	
	void softDeleted(Long Id);
	
	List<VendorResponse> findAll();
}
