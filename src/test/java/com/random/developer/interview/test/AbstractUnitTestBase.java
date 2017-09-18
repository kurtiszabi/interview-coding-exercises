package com.random.developer.interview.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.ParameterizedType;

import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract public class AbstractUnitTestBase<T> {
	
	protected T classUnderTest;
	
	@BeforeEach
	public void setUp() {
		classUnderTest = createInstance();
	}
	
	@SuppressWarnings("unchecked")
	protected T createInstance() {
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class<T> t = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
		try {	
			T instance = ConstructorUtils.invokeConstructor(t);
			return instance;
		} catch (Exception e) {
			throw new IllegalStateException("Failed to instantiate class under test", e);
		}
	}
	
	@Test
	public void testThatTestPackageAndClassNameMatches() {
		String className = classUnderTest.getClass().getName();
		assertEquals(className + "Test", this.getClass().getName());
	}
	
}
