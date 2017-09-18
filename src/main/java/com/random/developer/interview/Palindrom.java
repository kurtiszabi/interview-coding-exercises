package com.random.developer.interview;

public class Palindrom {

	public boolean check(String input) {
		if (input == null) {
			throw new IllegalArgumentException("Input must not be null");
		}
		for (int i = 0; i < input.length() / 2; i++) {
			if (input.charAt(i) != input.charAt(input.length() - 1 - i))
				return false;
		}
		return true;
	}
	
}
