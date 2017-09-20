package com.random.developer.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.time.Duration.ofSeconds;

import com.random.developer.interview.test.AbstractUnitTestBase;

public class NthFibonacciNumberTest extends AbstractUnitTestBase<NthFibonacciNumber> {

	@Test
	public void testThatInputLessThanZeroIsNotAccepted() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			classUnderTest.apply(-1);
		});
		assertEquals("Input must be greater or equal to zero", exception.getMessage());
	}
	
	@ParameterizedTest(name  = "{0}th -> {1}")
	@CsvSource(value = {"0, 1", "1, 1", "2, 2", "3, 3", "4, 5", "5, 8", "6, 13", "7, 21"})
	public void testResults(int n, int expected) {
		assertEquals(expected, classUnderTest.apply(n));
	}
	
	@Test
	public void testThatItResondsInATimelyManner() {
		assertTimeoutPreemptively(ofSeconds(1), () -> {
			classUnderTest.apply(1_000);
		});
	}
	
}
