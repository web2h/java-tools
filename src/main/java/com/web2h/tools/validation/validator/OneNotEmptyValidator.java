package com.web2h.tools.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import com.web2h.tools.validation.OneNotEmpty;

public class OneNotEmptyValidator implements ConstraintValidator<OneNotEmpty, Object> {
	private String firstField;
	private String secondField;
	private String thirdField;

	public void initialize(final OneNotEmpty constraintAnnotation) {
		firstField = constraintAnnotation.first();
		secondField = constraintAnnotation.second();
		thirdField = constraintAnnotation.third();
	}

	@SuppressWarnings("deprecation")
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		boolean valid = false;

		try {
			final Object firstObj = BeanUtils.getProperty(value, firstField);
			final Object secondObj = BeanUtils.getProperty(value, secondField);
			final Object thirsObj = BeanUtils.getProperty(value, thirdField);

			valid = firstObj != null || secondObj != null || thirsObj != null;
		} catch (final Exception eToIgnore) {
			valid = false;
		}
		if (!valid) {
			context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addNode(firstField).addConstraintViolation().disableDefaultConstraintViolation();
		}
		return valid;
	}
}