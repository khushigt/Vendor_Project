package com.generate.invoice.entity.request;

import java.io.Serializable;
import java.math.BigDecimal;

import com.generate.invoice.entity.constants.ProductCategory;
import com.generate.invoice.entity.constants.ProductStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Long id;

	BigDecimal quantity;

	BigDecimal unitPrice;

	ProductCategory productCategory;

	String description;
	
	Long vendorId;
	
	ProductStatus productStatus;
}
