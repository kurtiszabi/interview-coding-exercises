package com.random.developer.interview;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.random.developer.interview.Palindrom;
import com.random.developer.interview.test.AbstractUnitTestBase;

public class PalindromTest extends AbstractUnitTestBase<Palindrom> {

	@Test
	public void testThatNullIsNotAccepted() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			classUnderTest.check(null);
		});
		assertEquals(exception.getMessage(), "Input must not be null");
	}
	
	@Test
	public void testEmptyString() {
		assertTrue(() -> classUnderTest.check(""),  "We consider empty string to be a palindrom");
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "a", "b", "c" })
	public void testSingleCharacter(String param) {
		assertTrue(() -> classUnderTest.check(param), "Strings of lenght 1 are always palindroms");
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "aa", "bab", "cbbc", "dcbcd", "@@@@@@" })
	public void testPalindromsOfLengthGreaterThanOne(String param) {
		assertTrue(classUnderTest.check(param));		
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "ab", "abc", "abcab" })
	public void testNonPalindroms(String param) {
		assertFalse(classUnderTest.check(param));
	}
	
}
