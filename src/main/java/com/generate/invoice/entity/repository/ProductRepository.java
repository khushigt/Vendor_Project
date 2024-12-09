package com.generate.invoice.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generate.invoice.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findByIdAndVendorId(Long productId, Long vendorId);

}
