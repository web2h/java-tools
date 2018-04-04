package com.web2h.tools.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.web2h.tools.validation.validator.EmailValidator;

/**
 * Email constraint for email validation An email must look like
 * address@domain.ext.
 */
@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {

	String message() default "{com.web2h.utils.form.validator.Email.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}