package com.generate.invoice.response;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class VendorResponse implements Serializable{

	Long id;

	String firstName;

	String lastName;

	String emailId;

	String location;

	String mobileNo;

	String website;

	String agencyName;

	String gstNumber;

	LocalDateTime incorparationDate;

}
