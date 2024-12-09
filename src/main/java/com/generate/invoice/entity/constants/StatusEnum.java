package com.generate.invoice.entity.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author Manish
 */

@Getter
@AllArgsConstructor
public enum StatusEnum {

	PENDING("pending"), PUBLISHED("published"), UNVERIFIED("unverified"), REJECTED("rejected"), EXPIRED("expired"),
	ASSIGNED("assigned"), ACCEPTED("accepted"), CLOSED("closed"), VERIFIED("verified"), COMPLETED("completed"),
	CANCELLED("cancelled"), CONFIRMED("confirmed"), RESCHEDULED("resheduled"), SUCCESS("success"),PRODUCT_CREATED_SUCCESSFULY("Product Created Successfuly");

	String displayName;
}
