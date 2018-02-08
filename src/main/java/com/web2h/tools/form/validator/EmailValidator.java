package com.web2h.tools.form.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.web2h.utils.form.validator.annotation.Email;

public class EmailValidator implements ConstraintValidator<Email, String> {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{12,})$";

	@Override
	public void initialize(Email email) {
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext cxt) {
		if (email == null || email.isEmpty()) {
			return true;
		}
		return email.matches(EMAIL_PATTERN);
	}
}