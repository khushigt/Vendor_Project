package com.generate.invoice.util;

import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

	public static boolean isValid(Long value) {
		return value != null && value > 0;
	}
}
