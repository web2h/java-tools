package com.web2h.tools;

public class ValidationTools {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static boolean isNullOrEmpty(Object value) {
		if (value == null) {
			return true;
		}
		if (value instanceof String && ((String) value).trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isNull(Object value) {
		return value == null;
	}

	public static boolean isEmailInvalid(String email) {
		if (email == null) {
			return true;
		}
		return !email.matches(EMAIL_PATTERN);
	}

	public static boolean isTooLong(String value, int maxLength) {
		if (value == null) {
			return false;
		}
		return value.length() > maxLength;
	}

	public static boolean isTooShort(String value, int minLength) {
		if (value == null) {
			return false;
		}
		return value.length() < minLength;
	}
}
