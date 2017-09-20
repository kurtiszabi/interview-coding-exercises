package com.random.developer.interview;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.random.developer.interview.test.AbstractUnitTestBase;

public class NthFibonacciNumberNonRecursiveTest extends AbstractUnitTestBase<NthFibonacciNumberNonRecursive> {
	
	@Test
	public void testThatInputLessThanZeroIsNotAccepted() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			classUnderTest.apply(-1);
		});
		assertEquals("Input must be greater or equal to zero", exception.getMessage());
	}
	
	@ParameterizedTest(name  = "{0}th -> {1}")
	@CsvSource(value = {"0, 1", "1, 1", "2, 2", "3, 3", "4, 5", "5, 8", "6, 13", "7, 21", "8, 34", "9, 55"})
	public void testResults(int n, int expected) {
		assertEquals(expected, classUnderTest.apply(n));
	}
	
	@Test
	public void testThatWorksForLargeN() {
		int n = 1_000_000;
		assertTrue(() -> classUnderTest.apply(n) > n);		
	}
	
}
