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

import com.generate.invoice.constant.UrlConstant;
import com.generate.invoice.entity.Customer;
import com.generate.invoice.entity.request.CustomerRequest;
import com.generate.invoice.entity.service.CustomerService;
import com.generate.invoice.helper.CustomerHelper;
import com.generate.invoice.response.CustomerResponse;

@RestController
@RequestMapping(UrlConstant.CUSTOMER_BASE_URL)
public class CustomerRestController {

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerHelper customerHelper;

	@PostMapping(UrlConstant.CREATE)
	public ResponseEntity<Object> create(@RequestBody CustomerRequest customerRequest) {
		try {
			Customer customer = customerService.save(customerHelper.getEntity(customerRequest));
			return new ResponseEntity<Object>(customer.getId(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.OK);
		}

	}
	
	@GetMapping(UrlConstant.FIND_BY_ID)
	public ResponseEntity<Object> findById(@RequestParam Long id) {
		try {
			Customer customer = this.customerService.findById(id);
			return new ResponseEntity<Object>(customer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(UrlConstant.LIST)
	public ResponseEntity<List<Object>> findAll() {
		try {
	List<Object> list = this.customerService.findAll();
	return new ResponseEntity<List<Object>>(list,HttpStatus.OK);
		}catch(Exception e) {
			return  new ResponseEntity<List<Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(UrlConstant.DELETE)
	public ResponseEntity<Object> deleted(@RequestParam Long id){
		try {
			this.customerService.softDeleted(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
