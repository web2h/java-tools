package com.web2h.tools.validation.validator;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.web2h.tools.DateTools;
import com.web2h.tools.validation.SameDayOrFuture;

public class SameDayOrFutureValidator implements ConstraintValidator<SameDayOrFuture, Date> {

	@SuppressWarnings("unused")
	private SameDayOrFuture constraintAnnotation;

	@Override
	public void initialize(SameDayOrFuture constraintAnnotation) {
		this.constraintAnnotation = constraintAnnotation;
	}

	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		Date todayAtStartOfDay = DateTools.atStartOfDay(new Date());

		return value.equals(todayAtStartOfDay) || value.after(todayAtStartOfDay);
	}
}