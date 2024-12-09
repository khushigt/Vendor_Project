package com.generate.invoice.entity.request;

import java.io.Serializable;
import java.math.BigDecimal;

import com.generate.invoice.entity.constants.ProductCategory;

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
public class CustomerRequest implements Serializable {

	static final long serialVersionUID = 1L;

	Long id;

	String mobileNo;

	String name;

	String emailId;

	String countryOrRegion;

	String flatHouseNoBuildingCompanyApartment;

	String areaStreetSectorVillage;

	String Landmark;

	String townCity;

	String State;

	String pincode;
}
