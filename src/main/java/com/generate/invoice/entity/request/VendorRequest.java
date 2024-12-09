package com.generate.invoice.entity.request;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import com.generate.invoice.entity.Product;
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
public class VendorRequest implements Serializable {

	private static final long serialVersionUID = 1L;

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
