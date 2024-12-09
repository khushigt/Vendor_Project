package com.generate.invoice.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.generate.invoice.entity.constants.OrderStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author Manish
 *
 */

//@Entity
//@Table(name="orders")
//@Getter
//@Setter
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class Order extends BaseEntity{
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)  // auto generate unique value
//	Long id;
//	
//	@Enumerated(EnumType.STRING)
//	@Column(name = "order_status")
//	OrderStatus orderStatus;
//
//	@Column(name = "order_placed_date")
//	LocalDateTime orderdPlacedOnDate;
//
//	@Column(name = "order_product_quantity")
//	BigDecimal orderProductQuantity = BigDecimal.ZERO;
//
//	@Column(name = "product_price")
//	BigDecimal productPrice = BigDecimal.ZERO;
//	
//	@Column(name = "total_amount")
//	BigDecimal totalAmount = BigDecimal.ZERO;
//
//	@ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
//	@JoinColumn(name = "product_id", referencedColumnName = "id")
//	Product product;
//
//	@ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
//	@JoinColumn(name = "customer_id", referencedColumnName = "id")
//	Customer customer;
//	
//	
//}

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order extends BaseEntity {

	static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Column(name = "order_status")
	OrderStatus orderStatus;

	@Column(name = "order_placed_date")
	LocalDateTime orderdPlacedOnDate;

	@Column(name = "order_product_quantity")
	BigDecimal orderProductQuantity = BigDecimal.ZERO;

	@Column(name = "total_amount")
	BigDecimal totalAmount = BigDecimal.ZERO;

	@Column(name = "product_price")
	BigDecimal productPrice = BigDecimal.ZERO;

	@JsonIgnore
	@ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	Product product;

	@JsonIgnore
	@ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	Customer customer;

}
