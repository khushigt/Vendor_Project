package com.generate.invoice.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.generate.invoice.entity.constants.ProductCategory;
import com.generate.invoice.entity.constants.ProductStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "vendor")
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vendor extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "first_name")
	String firstName;

	@Column(name = "last_name")
	String lastName;

	@Column(name = "email_id")
	String emailId;

	String location;

	@Column(name = "mobile_no")
	String mobileNo;

	String website;

	@Column(name = "agency_name", nullable = false)
	String agencyName;

	@Column(name = "incorparation_date", nullable = false)
	LocalDateTime incorparationDate;

	@Column(name = "gst_number")
	String gstNumber;


	@OneToMany(cascade = CascadeType.ALL,mappedBy="vendor", fetch = FetchType.LAZY)
	List<Product> products;
}
