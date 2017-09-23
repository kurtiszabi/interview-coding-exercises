package com.random.developer.interview;

import java.util.function.Consumer;

import com.random.developer.interview.fixtures.BinaryNode;

public class PreOrderTraversal {

	public <T> void visit(BinaryNode<T> root, Consumer<T> consumer) {
		consumer.accept(root.getValue());
		if (root.getLeftChild() != null) {
			visit(root.getLeftChild(), consumer);
		}
		if (root.getRightChild() != null) {
			visit(root.getRightChild(), consumer);
		}
	}

	
}
