package com.generate.invoice.entity.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.generate.invoice.entity.constants.OrderStatus;

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
public class OrderRequest implements Serializable{

	Long id;
	
	OrderStatus orderStatus;
	
	LocalDateTime orderdPlacedOnDate;
	
	BigDecimal orderProductQuantity;
	
	BigDecimal productPrice;
	
	BigDecimal totalAmount;
	
	Long productId;
	
	Long customerId;
}
