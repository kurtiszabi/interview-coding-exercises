package com.random.developer.interview;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.random.developer.interview.fixtures.BinaryNode;
import com.random.developer.interview.test.AbstractUnitTestBase;

public class BinaryTreeTraversalNonRecursiveTest extends AbstractUnitTestBase<BinaryTreeTraversalNonRecursive> {
	
	private static final int BIG_TREE_SZ = 5000;

	private BinaryNode<String> root;
	
	private BinaryNode<String> bigRoot;
	
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
		bigRoot = createLinearTree(BIG_TREE_SZ);
	}
	
	private BinaryNode<String> createLinearTree(int size) {
		BinaryNode<String> prev = null;
		for (int i = 0; i < size; i++) {
			prev = new BinaryNode<String>(String.valueOf(i), prev, null); 			
		}
		return prev;
	}

	@Test
	public void inOrder_binaryTree_valuesAreFetchedInOrder() {
		List<BinaryNode<String>> inOrder = classUnderTest.inOrder(root);
		assertThat(inOrder.stream().map(BinaryNode::getValue).collect(toList()), contains("A", "B", "C", "D", "E", "F", "G", "H", "I"));
	}
	
	@Test
	public void inOrder_bigLinearTree_noStackOverflow() {
		List<BinaryNode<String>> inOrder = classUnderTest.inOrder(bigRoot);
		assertThat(inOrder, hasSize(BIG_TREE_SZ));
	}
	
	
}
