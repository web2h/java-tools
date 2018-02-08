package com.web2h.tools.authentication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.RandomStringUtils;

import com.web2h.tools.encoding.ByteArrayEncoder;
import com.web2h.tools.encoding.Hex;

public class PasswordFactory {

	private final static String UTF8 = "UTF-8";

	/**
	 * Creates a salt value of the given length.
	 * 
	 * @param length
	 *            Length of the salt string
	 * @return The salt value
	 */
	public static String createSalt(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	/**
	 * Creates a encrypted password.
	 * 
	 * @param clearPassword
	 *            The clear password input by the user
	 * @param encryptionMethod
	 *            The encryption method used
	 * @param iterations
	 *            The number of times the encryption method will be used
	 * @param salt
	 *            The salt value
	 * @return The encrypted password
	 */
	public static String createEncryptedPassword(String clearPassword, String encryptionMethod, int iterations, String salt) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance(encryptionMethod);
		messageDigest.reset();
		String saltedPass = clearPassword + "{" + salt + "}";
		byte[] digest = messageDigest.digest(ByteArrayEncoder.encode(saltedPass, UTF8));

		// "stretch" the encoded value if configured to do so
		for (int i = 1; i < iterations; i++) {
			digest = messageDigest.digest(digest);
		}
		return new String(Hex.encode(digest));
	}

	public static String maskPassword(String password) {
		if (password == null) {
			return null;
		}
		return password.replaceAll(".", "*");
	}
}