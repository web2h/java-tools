package com.web2h.tools.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import com.web2h.tools.validation.Confirmation;

public class ConfirmationValidator implements ConstraintValidator<Confirmation, Object> {
	private String originalField;
	private String confirmationField;

	public void initialize(final Confirmation constraintAnnotation) {
		originalField = constraintAnnotation.original();
		confirmationField = constraintAnnotation.confirmation();
	}

	@SuppressWarnings("deprecation")
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		boolean valid = false;

		try {
			final Object firstObj = BeanUtils.getProperty(value, originalField);
			final Object secondObj = BeanUtils.getProperty(value, confirmationField);

			valid = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
		} catch (final Exception eToIgnore) {
			valid = false;
		}
		if (!valid) {
			context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addNode(confirmationField).addConstraintViolation().disableDefaultConstraintViolation();
		}
		return valid;
	}
}