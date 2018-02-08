package com.web2h.tools;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class StringToolsTest {

	@Test
	public void containsUniqueCharacters_stringIsNull_mustReturnTrue() {
		assertTrue(StringTools.containsUniqueCharacters(null));
	}

	@Test
	public void containsUniqueCharacters_stringContainsDuplicates_mustReturnFalse() {
		assertFalse(StringTools.containsUniqueCharacters("RolR"));
		assertFalse(StringTools.containsUniqueCharacters("R7j99le"));
		assertFalse(StringTools.containsUniqueCharacters("abcdefABCDeF"));
		assertFalse(StringTools.containsUniqueCharacters("00"));
		assertFalse(StringTools.containsUniqueCharacters("RandomString"));
	}

	@Test
	public void containsUniqueCharacters_stringContainsUniqueCharacters_mustReturnTrue() {
		assertTrue(StringTools.containsUniqueCharacters("abcedfghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
		assertTrue(StringTools.containsUniqueCharacters("4"));
		assertTrue(StringTools.containsUniqueCharacters("a"));
		assertTrue(StringTools.containsUniqueCharacters("aleoui"));
		assertTrue(StringTools.containsUniqueCharacters("AsdeSa"));
	}

	@Test
	public void randomUniqueAlphanumeric_lengthIsZero_mustReturnNull() {
		assertNull(StringTools.randomUniqueAlphanumeric(0));
	}

	@Test
	public void randomUniqueAlphanumeric_lengthIsNegative_mustReturnNull() {
		assertNull(StringTools.randomUniqueAlphanumeric(-20));
	}

	@Test
	public void randomUniqueAlphanumeric_lengthExceedTheCharacterSetLength_mustReturnNull() {
		assertNull(StringTools.randomUniqueAlphanumeric(31));
	}

	@Test
	public void randomUniqueAlphanumeric_lengthIs30_mustReturnA30CharacterStringWithUniqueCharacters() {
		String randomString = StringTools.randomUniqueAlphanumeric(30);
		assertNotNull(randomString);
		assertThat(randomString.length(), is(30));
		assertTrue(containsNoDuplicates(randomString));
	}

	@Test
	public void randomUniqueAlphanumeric_buildMultipleStrings_mustNeverContainDuplicates() {
		for (int i = 0; i < 100000; i++) {
			assertTrue(containsNoDuplicates(StringTools.randomUniqueAlphanumeric(20)));
		}
	}

	@Test
	public void javaize_oneWord_mustReturnOneWord() {
		assertEquals("test", StringTools.javaize("TEST", StringTools.UNDERSCORE));
	}

	@Test
	public void javaize_twoWords_mustReturnTwoWords() {
		assertEquals("testWord", StringTools.javaize("TEST_WORD", StringTools.UNDERSCORE));
	}

	@Test
	public void javaize_threeWords_mustReturnThreeWords() {
		assertEquals("testMoreWord", StringTools.javaize("TEST_MORE_WORD", StringTools.UNDERSCORE));
	}

	private boolean containsNoDuplicates(String string) {
		Set<Character> characters = new HashSet<Character>();
		for (int j = 0; j < string.length(); j++) {
			characters.add(string.charAt(j));
		}
		// Character set size must equals the random string length
		return string.length() == characters.size();
	}
}