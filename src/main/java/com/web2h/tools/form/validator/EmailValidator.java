package com.web2h.tools.form.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.web2h.utils.form.validator.annotation.Email;

public class EmailValidator implements ConstraintValidator<Email, String> {

	@Override
	public void initialize(Email email) {
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext cxt) {
		if (email == null || email.isEmpty()) {
			return true;
		}
		return email.split("@").length == 2;
	}
}