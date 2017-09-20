package com.random.developer.interview;

import java.util.concurrent.ConcurrentHashMap;

public class NthFibonacciNumber {

	private final ConcurrentHashMap<Integer, Integer> precomputed = new ConcurrentHashMap<>();
	
	public int apply(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Input must be greater or equal to zero");
		}
		if (n <= 1) {
			return 1;
		}
		Integer result = precomputed.get(n);
		if (result == null) {
			result = apply(n - 1) + apply(n - 2);
			precomputed.put(n, result);
		}				
		return result;
	}
}
