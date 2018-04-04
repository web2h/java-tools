package com.web2h.tools.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.web2h.tools.validation.validator.OneNotEmptyValidator;

/**
 * Constraint validation. One of the 3 fields must not be empty.
 * 
 * @author Web2h
 */
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OneNotEmptyValidator.class)
@Documented
public @interface OneNotEmpty {

	String message() default "{com.web2h.utils.form.validator.OneNotEmpty.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * @return The first field
	 */
	String first();

	/**
	 * @return The second field
	 */
	String second();

	/**
	 * @return The third field
	 */
	String third() default "";

	/**
	 * Defines several <code>@OneNotEmpty</code> annotations on the same element
	 *
	 * @see OneNotEmpty
	 */
	@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		OneNotEmpty[] value();
	}
}
