package com.generate.invoice.response;

import java.io.Serializable;
import java.math.BigDecimal;

import com.generate.invoice.entity.constants.ProductCategory;
import com.generate.invoice.entity.constants.ProductStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse implements Serializable{

	Long id;

	BigDecimal quantity;

	BigDecimal unitPrice;

	ProductCategory productCategory;

	String description;
	
	Long vendorId;
	
	ProductStatus productStatus;
	
	BigDecimal totalPrice;
}
