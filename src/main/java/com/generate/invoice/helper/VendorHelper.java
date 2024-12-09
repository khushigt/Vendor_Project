package com.generate.invoice.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.generate.invoice.entity.Product;
import com.generate.invoice.entity.Vendor;
import com.generate.invoice.entity.constants.ProductCategory;
import com.generate.invoice.entity.repository.ProductRepository;
import com.generate.invoice.entity.repository.VendorRepository;
import com.generate.invoice.entity.request.VendorRequest;
import com.generate.invoice.response.VendorResponse;
import com.generate.invoice.util.CommonUtil;

@Component
public class VendorHelper {

	@Autowired
	VendorRepository vendorRepository;
	
	public Vendor getEntity(VendorRequest vendorRequest) {
		Vendor vendor;
		if (CommonUtil.isValid(vendorRequest.getId())) {
			vendor = this.vendorRepository.findById(vendorRequest.getId())
					.orElseThrow(() -> new RuntimeException("Vendor Id Not Found"));
		} else {
			vendor = new Vendor();
		}
		vendor.setAgencyName(vendorRequest.getAgencyName());
		vendor.setFirstName(vendorRequest.getFirstName());
		vendor.setLastName(vendorRequest.getLastName());
		vendor.setEmailId(vendorRequest.getEmailId());
		vendor.setLocation(vendorRequest.getLocation());
		vendor.setMobileNo(vendorRequest.getMobileNo());
		vendor.setWebsite(vendorRequest.getWebsite());
		vendor.setGstNumber(vendorRequest.getGstNumber());
		vendor.setIncorparationDate(vendorRequest.getIncorparationDate());
		return vendor;

	}

	public VendorResponse getVendor(Vendor vendor) {
		return VendorResponse.builder().id(vendor.getId()).firstName(vendor.getFirstName())
				.lastName(vendor.getLastName()).emailId(vendor.getEmailId()).agencyName(vendor.getAgencyName())
				.gstNumber(vendor.getGstNumber()).location(vendor.getLocation())
				.incorparationDate(vendor.getIncorparationDate()).mobileNo(vendor.getMobileNo())
				.website(vendor.getWebsite()).build();
	}
}
