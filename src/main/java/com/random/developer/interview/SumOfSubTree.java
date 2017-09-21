package com.random.developer.interview;

import com.random.developer.interview.fixtures.Node;

public class SumOfSubTree {

	public Integer sum(Node<Integer> node) {
		// summing items up recursively
		return node.getValue() + node.getChildren().stream().map(n -> sum(n)).reduce(Integer::sum).orElse(0); 
	}

}
