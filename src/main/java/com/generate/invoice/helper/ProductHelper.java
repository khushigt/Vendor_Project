package com.generate.invoice.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.generate.invoice.entity.Product;
import com.generate.invoice.entity.constants.ProductStatus;
import com.generate.invoice.entity.constants.StatusEnum;
import com.generate.invoice.entity.repository.ProductRepository;
import com.generate.invoice.entity.request.ProductRequest;
import com.generate.invoice.entity.service.ProductService;
import com.generate.invoice.entity.service.VendorService;
import com.generate.invoice.response.ProductResponse;
import com.generate.invoice.util.CommonUtil;

@Component
public class ProductHelper {

	@Autowired
	ProductService productService;

	@Autowired
	VendorService vendorService;

	@Autowired
	private ProductRepository productRepository;

	public Product getEntity(ProductRequest request) throws Exception {
		Product product;
		if (CommonUtil.isValid(request.getId())) {
			product = productService.findById(request.getId());

		} else {
			product = new Product();
			product.setSkuNumber(UUID.randomUUID().toString());
		}
		product.setStatus(StatusEnum.PRODUCT_CREATED_SUCCESSFULY);

		product.setQuantity(request.getQuantity());

		product.setProductStatus(ProductStatus.UNDER_VERIFICATION);
		if (request.getDescription().length() < 10 || request.getDescription().length() > 5000)
			throw new RuntimeException("Description must in between 10 to 5000 character.");
		product.setProductCategory(request.getProductCategory());

		product.setUnitPrice(request.getUnitPrice());
		product.setDescription(request.getDescription());
		BigDecimal unitPrice = request.getUnitPrice();
		BigDecimal quantity = request.getQuantity();
		BigDecimal totalPrice = unitPrice.multiply(quantity);
		product.setTotalPrice(totalPrice);
//		product.setUnitPrice(request.getUnitPrice());
//		product.setDescription(request.getDescription());
//		BigDecimal unitPrice = request.getUnitPrice();
//		BigDecimal quantity = request.getQuantity();
//		BigDecimal totalPrice = unitPrice.multiply(quantity);
//		product.setTotalPrice(totalPrice);
		product.setVendor(vendorService.findById(request.getVendorId()));
		return product;
	}

	public Product update(ProductStatus productStatus, Long productId, Long vendorId) {
		Product product = productRepository.findByIdAndVendorId(productId, vendorId);
		if (product.getId() == null) {
			throw new RuntimeException("Product Not found with given id " + productId + " and vendor id " + vendorId);
		}
		product.setProductStatus(productStatus);
		productRepository.save(product);
		return product;

	}

	public ProductResponse getProduct(Product product) {
		return ProductResponse.builder().id(product.getId()).description(product.getDescription())
				.productCategory(product.getProductCategory()).productStatus(product.getProductStatus())
				.vendorId(product.getVendor().getId()).build();
	}

	public ProductResponse getProductResponseByBuilderMethod(Product product) {
		return ProductResponse.builder().id(product.getId()).totalPrice(product.getTotalPrice())
				.quantity(product.getQuantity()).unitPrice(product.getUnitPrice()).vendorId(product.getVendor().getId())
				.productCategory(product.getProductCategory()).productStatus(product.getProductStatus())
				.description(product.getDescription()).build();

	}

	public List<ProductResponse> listByBuilderMethod(List<Product> products) {
		List<ProductResponse> productResponses = new ArrayList<>();
		products.forEach(product -> {
			productResponses.add(ProductResponse.builder().id(product.getId()).quantity(product.getQuantity())
					.unitPrice(product.getUnitPrice()).productCategory(product.getProductCategory())
					.productStatus(product.getProductStatus()).totalPrice(product.getTotalPrice())
					.vendorId(product.getVendor().getId()).description(product.getDescription()).build());
		});
		return productResponses;
	}

}