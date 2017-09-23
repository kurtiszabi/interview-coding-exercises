package com.random.developer.interview.test;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class StringCollector implements Consumer<String>, Supplier<List<String>> {

	private final List<String> collection = new LinkedList<>();
	
	@Override
	public void accept(String str) {
		collection.add(str);
	}

	@Override
	public List<String> get() {
		return collection;
	}
}
