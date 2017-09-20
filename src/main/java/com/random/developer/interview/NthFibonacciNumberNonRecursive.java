package com.random.developer.interview;

public class NthFibonacciNumberNonRecursive {

	public int apply(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Input must be greater or equal to zero");
		}
		int prev = 1;
		int prevPrev = 1;
		int current = 1;
		for (int i = 1; i < n; i++) {
			current = prev + prevPrev;
			prevPrev = prev;
			prev = current;
		}
		return current;
	}
	
}
