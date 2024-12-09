package com.generate.invoice.entity;

/**
 * 
 */

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.generate.invoice.entity.constants.ProductCategory;
import com.generate.invoice.entity.constants.ProductStatus;
import com.generate.invoice.entity.constants.StatusEnum;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author Manish
 *
 */
@Entity
@Table(name = "product")
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product extends BaseEntity {

	static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	StatusEnum status;

	@Column(name = "sku_number", nullable = true)
	String skuNumber;

	@Column(name = "quantity")
	BigDecimal quantity;

	@Column(name = "returnable")
	@ColumnDefault(value = "0")
	Boolean returnable = Boolean.FALSE;

	@Enumerated(EnumType.STRING)
	@Column(name = "product_status")
	ProductStatus productStatus;

	@Column(name = "live_date")
	LocalDateTime liveDate;

	@Column(name = "unit_price")
	BigDecimal unitPrice;

	@ColumnDefault(value = "0")
	@Column(name = "expiry")
	Boolean expiry = Boolean.FALSE;

	@ColumnDefault(value = "0")
	@Column(name = "live_status")
	Boolean liveStatus = Boolean.FALSE;

	@Column(name = "total_price")
	BigDecimal totalPrice = BigDecimal.ZERO;

	@Enumerated(EnumType.STRING)
	@Column(name = "product_category")
	ProductCategory productCategory;

	@Column(name = "description", nullable = false)
	@Lob
	String description;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
	List<Order> order;
	
	@ManyToOne(targetEntity = Vendor.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "vendor_id", referencedColumnName = "id")
	Vendor vendor;



}
