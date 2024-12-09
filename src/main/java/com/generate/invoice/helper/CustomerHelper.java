package com.generate.invoice.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.generate.invoice.entity.Customer;
import com.generate.invoice.entity.request.CustomerRequest;
import com.generate.invoice.entity.service.CustomerService;
import com.generate.invoice.response.CustomerResponse;
import com.generate.invoice.util.CommonUtil;

@Component
public class CustomerHelper {

	@Autowired
	CustomerService customerService;

	public Customer getEntity(CustomerRequest request) throws Exception {
		Customer customer;
		if (CommonUtil.isValid(request.getId())) {
			customer = customerService.findById(request.getId());

		} else {
			customer = new Customer();

			if (customer.getId() == null) {
				if (customerService.existsByMobileNumber(request.getMobileNo())) {
					throw new Exception("Account already exists with the given mobile number.");
				} else if (customerService.existsByEmailId(request.getEmailId())) {
					throw new Exception("Account already exists with the given email id.");
				}
			}

			else {
				if (customerService.existsByMobileNumberAndIdNot(request.getMobileNo(), customer.getId())) {
					throw new Exception("Account already exists with the given mobile number.");
				} else if (customerService.existsByEmailIdNumberAndIdNot(request.getEmailId(), customer.getId())) {
					throw new Exception("Account already exists with the given email id.");
				}
			}
		}
		customer.setMobileNo(request.getMobileNo());
		customer.setName(request.getName());
		customer.setEmailId(request.getEmailId());
		customer.setCountryOrRegion(request.getCountryOrRegion());
		customer.setFlatHouseNoBuildingCompanyApartment(request.getFlatHouseNoBuildingCompanyApartment());
		customer.setAreaStreetSectorVillage(request.getAreaStreetSectorVillage());
		customer.setLandmark(request.getLandmark());
		customer.setTownCity(request.getTownCity());
		customer.setState(request.getState());
		customer.setPincode(request.getPincode());
		return customer;

	}

//	public List<CustomerResponse> getCustomerList(List<Customer> customers) {
//		
//		List<CustomerResponse> customerResponses=new ArrayList<>();
//		customers.forEach(customer->{
//			
//			 customerResponses.add(CustomerResponse.builder().id(customer.getId()).mobileNo(customer.getMobileNo())
//					.emailId(customer.getEmailId()).areaStreetSectorVillage(customer.getAreaStreetSectorVillage())
//					.countryOrRegion(customer.getCountryOrRegion())
//					.flatHouseNoBuildingCompanyApartment(customer.getFlatHouseNoBuildingCompanyApartment())
//					.State(customer.getState()).Landmark(customer.getLandmark()).pincode(customer.getPincode())
//					.name(customer.getName()).townCity(customer.getTownCity()).build());
//
//		});
//
//		return customerResponses;
//
//	}

	public Customer getCustomerRequest(CustomerRequest customerRequest) {
		return Customer.builder().emailId(customerRequest.getEmailId()).name(customerRequest.getName())
				.areaStreetSectorVillage(customerRequest.getAreaStreetSectorVillage())
				.countryOrRegion(customerRequest.getCountryOrRegion())
				.flatHouseNoBuildingCompanyApartment(customerRequest.getFlatHouseNoBuildingCompanyApartment())
				.Landmark(customerRequest.getLandmark()).mobileNo(customerRequest.getMobileNo())
				.State(customerRequest.getState()).townCity(customerRequest.getTownCity())
				.pincode(customerRequest.getPincode()).build();

	}
	
	public CustomerResponse getCustomer(Customer customer) {
				return CustomerResponse.builder().id(customer.getId()).mobileNo(customer.getMobileNo())
				.emailId(customer.getEmailId()).areaStreetSectorVillage(customer.getAreaStreetSectorVillage())
				.countryOrRegion(customer.getCountryOrRegion())
				.flatHouseNoBuildingCompanyApartment(customer.getFlatHouseNoBuildingCompanyApartment())
				.State(customer.getState()).Landmark(customer.getLandmark()).pincode(customer.getPincode())
				.name(customer.getName()).townCity(customer.getTownCity()).build();
	}
	
}
