package com.generate.invoice.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.generate.invoice.entity.constants.OrderStatus;

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
public class OrderListResponse {
	
	Long id;
	
	OrderStatus orderStatus;

	LocalDateTime orderdPlacedOnDate;

	BigDecimal orderProductQuantity;

	BigDecimal productPrice;

	Long productId;

	Long customerId;

	BigDecimal totalAmount;

}
