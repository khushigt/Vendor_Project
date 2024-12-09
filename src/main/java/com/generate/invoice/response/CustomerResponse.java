package com.generate.invoice.response;

import java.io.Serializable;

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
public class CustomerResponse implements Serializable{

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
