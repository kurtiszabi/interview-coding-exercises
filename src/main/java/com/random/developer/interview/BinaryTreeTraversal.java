package com.random.developer.interview;

import java.util.function.Consumer;

import com.random.developer.interview.fixtures.BinaryNode;

public class BinaryTreeTraversal {

	public <T> void preOrder(BinaryNode<T> root, Consumer<T> consumer) {
		consumer.accept(root.getValue());
		if (root.getLeftChild() != null) {
			preOrder(root.getLeftChild(), consumer);
		}
		if (root.getRightChild() != null) {
			preOrder(root.getRightChild(), consumer);
		}
	}

	public <T> void inOrder(BinaryNode<T> root, Consumer<T> consumer) {
		if (root.getLeftChild() != null) {
			inOrder(root.getLeftChild(), consumer);
		}
		consumer.accept(root.getValue());
		if (root.getRightChild() != null) {
			inOrder(root.getRightChild(), consumer);
		}
	}

	public <T> void postOrder(BinaryNode<T> root, Consumer<T> consumer) {
		if (root.getLeftChild() != null) {
			postOrder(root.getLeftChild(), consumer);
		}
		if (root.getRightChild() != null) {
			postOrder(root.getRightChild(), consumer);
		}
		consumer.accept(root.getValue());
	}
	
}
