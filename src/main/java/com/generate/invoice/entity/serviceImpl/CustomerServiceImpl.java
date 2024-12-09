package com.generate.invoice.entity.serviceImpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generate.invoice.entity.Customer;
import com.generate.invoice.entity.repository.CustomerRepository;
import com.generate.invoice.entity.service.CustomerService;
import com.generate.invoice.helper.CustomerHelper;
import com.generate.invoice.response.CustomerResponse;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomerHelper customerHelper;

	@Override
	public Customer findById(Long id) {

		return customerRepository.findById(id).get();
	}

	@Override
	public Customer save(Customer customer) {

		return customerRepository.save(customer);
	}

	@Override
	public Boolean existsByEmailId(String emailId) throws Exception {

		return customerRepository.existsByEmailId(emailId);
	}

	@Override
	public Boolean existsByMobileNumber(String mobileNumber) throws Exception {

		return customerRepository.existsByMobileNo(mobileNumber);
	}

	@Override
	public Boolean existsByMobileNumberAndIdNot(String mobileNumber, Long Id) throws Exception {

		try {
			return customerRepository.existsByMobileNumberAndIdNot(mobileNumber, Id);
		} catch (Exception e) {
			throw new Exception("Account already exists with the given mobile number.");
		}
	}

	@Override
	public Boolean existsByEmailIdNumberAndIdNot(String emailId, Long Id) throws Exception {

		try {
			return customerRepository.existsByEmailIdAndIdNot(emailId, Id);
		} catch (Exception e) {
			throw new Exception("Account already exists with the given email id.");

		}
	}

	@Override
	public List<Object> findAll() {
		List<Customer> list = this.customerRepository.findAll();
		return list.stream().map(customerHelper::getCustomer).collect(Collectors.toList());
	}

	@Override
	public void softDeleted(Long id) {
		Customer customer = this.customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Id  not Found"));
		customer.setDeleted(true);
		customerRepository.save(customer);
	}

}
