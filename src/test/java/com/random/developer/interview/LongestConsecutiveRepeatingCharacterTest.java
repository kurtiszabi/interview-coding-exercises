package com.random.developer.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.random.developer.interview.test.AbstractUnitTestBase;

public class LongestConsecutiveRepeatingCharacterTest
		extends AbstractUnitTestBase<LongestConsecutiveRepeatingCharacter> {

	private static final String EXPECTED_EXCEPTION_MSG = "Input must not be empty or null";

	@Test
	public void testThatNullOrEmptyStringIsNotAccepted() {
		assertEmptyInput(() -> classUnderTest.apply(null));
		assertEmptyInput(() -> classUnderTest.apply(""));
	}
	
	private void assertEmptyInput(Executable supplier) {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, supplier);
		assertEquals(EXPECTED_EXCEPTION_MSG, exception.getMessage());		
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "A", "B", "C" })
	public void testSingleCharacter(String input) {
		assertEquals(input.charAt(0), classUnderTest.apply(input));
	}
		
	@ParameterizedTest(name = "{index}: apply({1}) -> {0}")
	@CsvSource({"A, AAz", "B, BBz", "C, CCz"})
	public void testLongestConsecutiveCharAtStart(char expected, String input) {
		assertEquals(expected, classUnderTest.apply(input));
	}
	
	@Test
	public void testLongestConsecutiveCharInMiddle() {
		assertEquals('B', classUnderTest.apply("aBBc"));
	}
	
	@Test
	public void testLongestConsecutiveCharAtTheEnd() {
		assertEquals('C', classUnderTest.apply("abCC"));
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "AAbAc", "bAAcA"})
	public void testLongestConsecutiveCharRepeating(String input) {
		assertEquals('A', classUnderTest.apply(input));
	}
}
