package com.generate.invoice.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.generate.invoice.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Boolean existsByMobileNo(String mobileNumber);
	
	Boolean existsByEmailId(String emailId);
	
	@Query("SELECT COUNT(c.id)>0 FROM Customer c  where (c.deleted=false or c.deleted IS NULL) and c.mobileNo=?1  and (?2 IS NULL OR c.id<>?2)")
	Boolean existsByMobileNumberAndIdNot(String mobileNumber, Long Id);
	
	@Query("SELECT COUNT(c.id)>0 FROM Customer c  where (c.deleted=false or c.deleted IS NULL) and c.emailId=?1 and (?2 IS NULL OR c.id<>?2)")
	Boolean existsByEmailIdAndIdNot(String emailId, Long Id);


}
