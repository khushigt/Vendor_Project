package com.generate.invoice.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generate.invoice.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long>{

	
}
