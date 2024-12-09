package com.generate.invoice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "customer")
public class Customer extends BaseEntity {

	static final long serialVersionUID = 1L;

	@Column(name = "mobile_no")
	String mobileNo;

	@Column(name = "name")
	String name;

	@Column(name = "email_id")
	String emailId;

	@Column(name = "country_or_region")
	String countryOrRegion;

	@Column(name = "flat_house_no_building_company_apartment")
	String flatHouseNoBuildingCompanyApartment;

	@Column(name = "area_street_sector_village")
	String areaStreetSectorVillage;

	@Column(name = "landmark")
	String Landmark;
	
	@Column(name = "town_city")
	String townCity;

	@Column(name = "state")
	String State;

	@Column(name = "pincode")
	String pincode;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
	List<Order> order;

}