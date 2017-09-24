package com.random.developer.interview;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.random.developer.interview.fixtures.BinaryNode;
import com.random.developer.interview.test.AbstractUnitTestBase;
import com.random.developer.interview.test.StringCollector;

public class BinaryTreeTraversalTest extends AbstractUnitTestBase<BinaryTreeTraversal> {

	private BinaryNode<String> root;
	
	private StringCollector collector;
	
	@BeforeEach
	public void init() {
		//        (F)
		//      /    \
		//    (B)    (G)
		//    / \      \ 
		//  (A) (D)    (I)
		//      / \    /
		//    (C) (E)(H)
		//
		BinaryNode<String> c = new BinaryNode<>("C");
		BinaryNode<String> e = new BinaryNode<>("E");
		BinaryNode<String> d = new BinaryNode<>("D", c, e);
		BinaryNode<String> a = new BinaryNode<>("A");
		BinaryNode<String> b = new BinaryNode<>("B", a, d);
		BinaryNode<String> h = new BinaryNode<>("H");
		BinaryNode<String> i = new BinaryNode<>("I", h, null);
		BinaryNode<String> g = new BinaryNode<>("G", null, i);
		root = new BinaryNode<>("F", b, g);
		collector = new StringCollector();
	}
	
	@Test
	public void preOrder_binaryTree_nodesAreVisitedPreOrder() {
		classUnderTest.preOrder(root, collector);
		assertThat(collector.get(), contains("F", "B", "A", "D", "C", "E", "G", "I", "H"));
	}
	
	@Test
	public void inOrder_binaryTree_nodesAreVisitedInOrder() {
		classUnderTest.inOrder(root, collector);
		assertThat(collector.get(), contains("A", "B", "C", "D", "E", "F", "G", "H", "I"));
	}
	
	@Test
	public void postOrder_binaryTree_nodesAreVisitedPostOrder() {
		classUnderTest.postOrder(root, collector);
		assertThat(collector.get(), contains("A", "C", "E", "D", "B", "H", "I", "G", "F"));
	}
	
}
