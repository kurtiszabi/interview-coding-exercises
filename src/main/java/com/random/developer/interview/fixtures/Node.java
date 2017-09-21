package com.random.developer.interview.fixtures;

import java.util.LinkedList;
import java.util.List;

public class Node<T> {

	private T value;
	
	private final List<Node<T>> children;

	public Node(T value) {
		super();
		this.value = value;
		this.children = new LinkedList<>();
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public List<Node<T>> getChildren() {
		return children;
	}

	public void addChild(Node<T> node) {
		children.add(node);
	}
	
	public void removeChild(Node<T> node) {
		children.remove(node);
	}
	
}
