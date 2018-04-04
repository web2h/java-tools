package com.web2h.tools.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.web2h.tools.validation.validator.ConfirmationValidator;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConfirmationValidator.class)
@Documented
public @interface Confirmation {

	String message() default "{com.web2h.utils.form.validator.Confirmation.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * @return The original field
	 */
	String original();

	/**
	 * @return The confirmation field
	 */
	String confirmation();

	/**
	 * Defines several <code>@Confirmation</code> annotations on the same
	 * element
	 *
	 * @see Confirmation
	 */
	@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		Confirmation[] value();
	}
}