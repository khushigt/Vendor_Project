package com.generate.invoice.entity.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductStatus {

	UNDER_VERIFICATION("Under Verification"), LIVE("Live"), DISCONTINUED("Discontinued");

	private String displayName;
}
