package com.random.developer.interview;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.random.developer.interview.fixtures.BinaryNode;
import com.random.developer.interview.test.AbstractUnitTestBase;
import com.random.developer.interview.test.StringCollector;

public class PreOrderTraversalTest extends AbstractUnitTestBase<PreOrderTraversal> {

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
	public void visit_binaryTree_nodesAreVisitedPreOrder() {
		classUnderTest.visit(root, collector);
		assertThat(collector.get(), contains("F", "B", "A", "D", "C", "E", "G", "I", "H"));
	}
	
}
