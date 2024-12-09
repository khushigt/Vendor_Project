package com.generate.invoice.entity.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generate.invoice.entity.Vendor;
import com.generate.invoice.entity.repository.VendorRepository;
import com.generate.invoice.entity.service.VendorService;
import com.generate.invoice.helper.VendorHelper;
import com.generate.invoice.response.VendorResponse;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	VendorRepository vendorRepository;
	
	@Autowired
	VendorHelper vendorHelper;

	@Override
	public Vendor findById(Long id) {
		return this.vendorRepository.findById(id).get();
	}

	@Override
	public Vendor save(Vendor vendor) {
		return this.vendorRepository.save(vendor);
	}

	@Override
	public void softDeleted(Long Id) {
		Vendor vendor = this.vendorRepository.findById(Id).orElseThrow(()-> new RuntimeException("Id not found"));
		vendor.setDeleted(true);
		vendorRepository.save(vendor);
	}

	@Override
	public List<VendorResponse> findAll() {
		return this.vendorRepository.findAll().stream().map(vendorHelper::getVendor).collect(Collectors.toList());
	}

}
