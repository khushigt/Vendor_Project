package com.generate.invoice.entity.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generate.invoice.entity.Product;
import com.generate.invoice.entity.repository.ProductRepository;
import com.generate.invoice.entity.service.ProductService;
import com.generate.invoice.entity.service.VendorService;
import com.generate.invoice.helper.ProductHelper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductHelper productHelper ;
	
	@Autowired
	private VendorService vendorService;

	@Override
	public Product findById(Long id) {
		return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
	}

	@Override
	public Product save(Product product) {

		return productRepository.save(product);
	}

	@Override
	public Product findByIdAndVendorId(Long productId, Long vendorId) {
		return this.findByIdAndVendorId(productId, vendorId);
	}

	@Override
	public void softDeleted(Long id) {
		Product product = this.productRepository.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
		product.setDeleted(true);
		productRepository.save(product);
	}
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

}
