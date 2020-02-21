package com.giffgaff.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ArraysTest {

	@Test
	void test() {
		// fail("Not yet implemented");
	}

	@Test
	public void arrays_sort_test() {

		int[] actualArray = { 17, 12, 11, 32, 22 };
		Arrays.sort(actualArray);
		int[] expectedArray = { 11, 12, 17, 22, 32 };

		assertArrayEquals(expectedArray, actualArray);
	}

	@Test
	public void array_exception_test() {

		int[] actaulArray = null;
		// int[] actaulArray = {};

		assertThrows(NullPointerException.class, () -> {
			Arrays.sort(actaulArray);
		});

	}

}
