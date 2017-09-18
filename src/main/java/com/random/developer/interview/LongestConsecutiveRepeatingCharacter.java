package com.random.developer.interview;

public class LongestConsecutiveRepeatingCharacter {

	public char apply(String input) {
		if (input == null || input.length() < 1) {
			throw new IllegalArgumentException("Input must not be empty or null");
		}
		char maxChar, currentChar;
		maxChar = currentChar = input.charAt(0);
		int maxLength, currentLength;
		maxLength = currentLength = 1;
		for (int i = 1; i < input.length(); i++) {
			char c = input.charAt(i); 
			if (c == currentChar) {
				currentLength++;
			} else {
				currentChar = c;
				currentLength = 1;
			}
			if (currentLength > maxLength) {
				maxLength = currentLength;
				maxChar = currentChar;
			}
		}
		return maxChar;
	}
	
}
