package com.web2h.utils.authentication;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.web2h.tools.authentication.PasswordFactory;

public class PasswordFactoryTest {

	@Test
	public void createSalt() {
		String salt1 = PasswordFactory.createSalt(50);
		assertThat(salt1.length(), is(50));
		assertTrue(salt1.matches("^[a-zA-Z0-9]*$"));

		try {
			PasswordFactory.createSalt(-1);
			assertTrue(false);
		} catch (IllegalArgumentException iae) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void createPasswordWithUnknownAlgorithm() {
		try {
			PasswordFactory.createEncryptedPassword("123456", "UNKNOWN-ALGORITHM", 1500, PasswordFactory.createSalt(100));
			assertTrue(false);
		} catch (NoSuchAlgorithmException nsae) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void createPassword() {
		try {
			String password = PasswordFactory.createEncryptedPassword("123456", "SHA-256", 1500, PasswordFactory.createSalt(100));
			assertThat(password, not(is("123456")));
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void maskPassword() {
		assertNull(PasswordFactory.maskPassword(null));
		assertEquals("*****", PasswordFactory.maskPassword("Passw"));
		assertEquals("********", PasswordFactory.maskPassword("Password"));
	}
}