package com.generate.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generate.invoice.entity.Vendor;
import com.generate.invoice.entity.request.VendorRequest;
import com.generate.invoice.entity.service.VendorService;
import com.generate.invoice.helper.VendorHelper;
import com.generate.invoice.response.VendorResponse;

@RestController
@RequestMapping("rest/vendor")
public class VendorRestController {
	
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private VendorHelper vendorHelper;
	
	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestBody VendorRequest vendorRequest){
		try {
			Vendor vendor = this.vendorService.save(vendorHelper.getEntity(vendorRequest));
			return new ResponseEntity(vendor.getId(),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(vendorRequest.getId(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findById")
	public ResponseEntity<Object> findById(@RequestParam Long id){
		try {
			Vendor vendor = this.vendorService.findById(id);
			return new ResponseEntity<Object>(vendor,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<Object> findAll(){
		try {
			List<VendorResponse> list = vendorService.findAll();
			return new ResponseEntity<>(list,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleted")
	public ResponseEntity<Object> softDeleted(@RequestParam Long id){
		 this.vendorService.softDeleted(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
		
		
	}
}
