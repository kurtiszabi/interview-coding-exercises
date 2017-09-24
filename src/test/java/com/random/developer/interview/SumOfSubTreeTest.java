package com.random.developer.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.random.developer.interview.fixtures.Node;
import com.random.developer.interview.test.AbstractUnitTestBase;

public class SumOfSubTreeTest extends AbstractUnitTestBase<SumOfSubTree> {

	private Node<Integer> grandParent;

	private Node<Integer> childOne;
	
	private Node<Integer> childTwo;
	
	private Node<Integer> childThree;
	
	private Node<Integer> grandChild;

	@BeforeEach
	public void init() {
		grandParent = new Node<>(1);
		childOne = new Node<>(3);
		childTwo = new Node<>(5);
		childThree = new Node<>(7);
		grandParent.addChild(childOne);
		grandParent.addChild(childTwo);
		grandParent.addChild(childThree);
		grandChild = new Node<>(11);				
		childOne.addChild(grandChild);
		// Construct the tree below:
		//            (1)
		//          /  |  \
		//        (3) (5)  (7)
		//       /
		//     (11)
	}
	
	@Test
	public void sum_singleNode_returnsValue() {
		assertEquals(grandChild.getValue(), classUnderTest.sum(grandChild));
	}
	
	@Test
	public void sum_parentAndChild_returnsSumOfTheTwo() {
		assertEquals((Integer)(childOne.getValue() + grandChild.getValue()), classUnderTest.sum(childOne));
	}
	
	@Test
	public void sum_rootNode_returnsSumOfAllNodes() {
		Integer expected = Stream.of(grandParent, childOne, childTwo, childThree, grandChild).map(Node::getValue).reduce(Integer::sum).get();
		assertEquals(expected, classUnderTest.sum(grandParent));
	}

	
	
}
