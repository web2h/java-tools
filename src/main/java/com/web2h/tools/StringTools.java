package com.web2h.tools;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * String tools class.
 * 
 * @author Web2h
 */
public class StringTools {

	public static final String UNDERSCORE = "_";

	/**
	 * Sets of characters excepted the confusing ones ('0', 'o', 'O', 'i', 'I',
	 * 'l').
	 */
	private static final String CHARACTER_SET_WITHOUT_CONFUSING_ONES = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ123456789";
	/** Max length for building a string with unique characters. */
	private static final int MAX_LENGTH_FOR_UNIQUE_CHARACTER_STRING = 30;

	/**
	 * Checks if the given string contains only unique characters
	 * 
	 * @param string
	 *            String to test
	 * @return true if the given string contains only unique characters, false
	 *         otherwise
	 */
	public static boolean containsUniqueCharacters(String string) {
		if (string == null) {
			return true;
		}
		Map<Character, Integer> charCounter = new HashMap<Character, Integer>();
		for (int i = 0; i < string.length(); i++) {
			Character currentChar = string.charAt(i);
			if (charCounter.get(currentChar) == null) {
				charCounter.put(currentChar, 1);
			} else {
				// Already exists
				return false;
			}
		}
		return true;
	}

	/**
	 * Builds a random string containing only unique alphanumeric characters (no
	 * duplicates). We avoid '0', 'o', 'O', 'i', 'I', 'l' to avoid confusions.
	 * 
	 * @param length
	 *            Expected length of the string (must be positive and not exceed 30
	 *            to built a unique string easily)
	 * @return The built string, null if the length is negative or zero
	 */
	public static String randomUniqueAlphanumeric(final int length) {
		if (length <= 0) {
			return null;
		}

		if (length > MAX_LENGTH_FOR_UNIQUE_CHARACTER_STRING) {
			return null;
		}

		String randomString = null;
		boolean uniqueCharactersOnly = false;
		do {
			randomString = RandomStringUtils.random(length, CHARACTER_SET_WITHOUT_CONFUSING_ONES);
			if (containsUniqueCharacters(randomString)) {
				uniqueCharactersOnly = true;
			}
		} while (!uniqueCharactersOnly);
		return randomString;
	}

	public static String random(final int length) {
		return RandomStringUtils.random(length, CHARACTER_SET_WITHOUT_CONFUSING_ONES);
	}

	/**
	 * Turn into a java syntax the given string whose words are separated by the
	 * given separator. TEST_STRING will be transformed into testString.
	 * 
	 * @param source
	 *            The string to transform
	 * @param separator
	 *            The word separator
	 * @return The result string
	 */
	public static String javaize(final String source, final String separator) {
		String[] parts = source.split(separator);
		StringBuffer buffer = new StringBuffer();
		for (String part : parts) {
			String tempPart = part.toLowerCase();
			if (buffer.length() == 0) {
				buffer.append(tempPart);
			} else {
				buffer.append(tempPart.substring(0, 1).toUpperCase()).append(tempPart.substring(1));
			}
		}
		return buffer.toString();
	}

	public static String getFieldAndValueToString(Object field, Object value) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" - ");
		buffer.append(field);
		buffer.append(" [");
		buffer.append(value);
		buffer.append("]");
		return buffer.toString();
	}
}