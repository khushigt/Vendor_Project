package com.generate.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generate.invoice.entity.Product;
import com.generate.invoice.entity.constants.ProductStatus;
import com.generate.invoice.entity.repository.ProductRepository;
import com.generate.invoice.entity.request.ProductRequest;
import com.generate.invoice.entity.service.ProductService;
import com.generate.invoice.helper.ProductHelper;
import com.generate.invoice.response.ProductResponse;

@RestController
@RequestMapping("/rest/product")
public class ProductRestController {

	@Autowired
	ProductService productService;

	@Autowired
	ProductHelper productHelper;
	
	@Autowired
	ProductRepository productRepository;

	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestBody ProductRequest productRequest) {

		try {
			Product product = productService.save(productHelper.getEntity(productRequest));
			return new ResponseEntity<Object>(product.getId(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(productRequest.getId(),HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PutMapping("/update/{vendorId}/{productId}")
	public ResponseEntity<Object> updateProductStatus(@RequestParam ProductStatus updateProductStatus,
			@RequestParam Long vendorId, @RequestParam Long productId) {
		try {
			Product product = productHelper.update(updateProductStatus, vendorId, productId);
			return new ResponseEntity<Object>(product.getId(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findById")
	public ResponseEntity<Object> findById(@RequestParam Long id){
		try {
		Product product = productService.findById(id);
		ProductResponse productResponse = productHelper.getProductResponseByBuilderMethod(product);
		return new ResponseEntity<Object>(productResponse,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	@GetMapping("/list")
//	public ResponseEntity<Object> findAll(){
//		try {
//			List<ProductResponse> list = productService.finndAll();
//			return new ResponseEntity<Object>(list,HttpStatus.OK);
//		}catch(Exception e) {
//			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<Object> list() {
		try {
			List<Product> list = productService.findAll();
			 List<ProductResponse> productListResponses = productHelper.listByBuilderMethod(list);
			return new ResponseEntity<Object>(productListResponses, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Object> softDeleted(@RequestParam Long Id){
		this.productService.softDeleted(Id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
