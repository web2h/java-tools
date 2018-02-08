package com.web2h.tools;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidationToolsTest {

	@Test
	public void checkIfEmailInvalid_longextension_shouldBeValid() {
		assertFalse(ValidationTools.isEmailInvalid("test@domain.extension"));
	}

	@Test
	public void checkIfEmailInvalid_invalidEmails_shouldBeInvalid() {
		assertTrue(ValidationTools.isEmailInvalid("test@domain"));
		assertTrue(ValidationTools.isEmailInvalid("@domain.meteo"));
		assertTrue(ValidationTools.isEmailInvalid("testdomain.fr"));
	}

	@Test
	public void isTooLong_tooLongValues_shouldReturnFalse() {

	}
}