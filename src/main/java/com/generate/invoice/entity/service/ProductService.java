package com.generate.invoice.entity.service;

import java.util.List;

import com.generate.invoice.entity.Product;

public interface ProductService {
	
	
	Product findById(Long id);
	
	Product save(Product product);
	
	Product findByIdAndVendorId(Long productId, Long vendorId);

	void softDeleted(Long id);
	
	List<Product> findAll();
}
