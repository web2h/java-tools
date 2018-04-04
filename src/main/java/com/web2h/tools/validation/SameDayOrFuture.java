package com.web2h.tools.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.web2h.tools.validation.validator.SameDayOrFutureValidator;

@Documented
@Constraint(validatedBy = SameDayOrFutureValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface SameDayOrFuture {
	// used to get later in the resource bundle the i18n text
	String message() default "{validation.date.SameDayOrFuture.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}