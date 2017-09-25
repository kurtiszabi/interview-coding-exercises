package com.random.developer.interview;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.random.developer.interview.fixtures.BinaryNode;

public class BinaryTreeTraversalNonRecursive {

	public <T> List<BinaryNode<T>> inOrder(BinaryNode<T> root) {
		Stack<BinaryNode<T>> stack = new Stack<>();
		List<BinaryNode<T>> list = new LinkedList<>();
		BinaryNode<T> node = root;
		
		// find the leftmost
		while(node != null) {
			stack.push(node);
			node = node.getLeftChild();
		}
		
		// traverse the tree
		while(!stack.isEmpty()) {
			node = stack.pop();
			// collect the current node
			list.add(node);
			// visit the right child
			if (node.getRightChild() != null) {
				node = node.getRightChild();				
				// the next node will be the leftmost in the subtree
				while(node != null) {
					stack.push(node);
					node = node.getLeftChild();					
				}				
			}
		}
		return list;
	}

	public <T> List<BinaryNode<T>> preOrder(BinaryNode<T> root) {
		Stack<BinaryNode<T>> stack = new Stack<>();
		List<BinaryNode<T>> list = new LinkedList<>();
		BinaryNode<T> node = root;

		// find the leftmost
		while(node != null) {
			list.add(node);
			stack.add(node);
			node = node.getLeftChild();
		}
		
		// traverse the tree
		while(!stack.isEmpty()) {
			node = stack.pop();
			// visit the right child
			if (node.getRightChild() != null) {
				node = node.getRightChild();
				// find the leftmost item in the subtree on collect nodes on the go
				while(node!= null) {
					list.add(node);
					stack.add(node);
					node = node.getLeftChild();
				}
			}
		}
		return list;
	} 
	
}
