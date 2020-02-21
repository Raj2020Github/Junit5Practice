/**
 * 
 */
package com.giffgaff.test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * @author ntttech03
 *
 */
public class MathTest {

	@Before
	void testBefore() {
		System.out.println("I am from before");
	}

	@Test
	void mathMin_Test() {

		int minVal = Math.min(12000, 21000);
		int expected = 12000;
		assertEquals(expected, minVal);

	}

	@Test
	void mathMax_Test() {

		int maxVal = Math.max(12000, 21000);
		int expected = 21000;
		assertEquals(expected, maxVal);

	}

	@Test
	void squre_Test() {

		int number = 4;
		int result_Val = number * number;
		int expected_num = 16;
		assertEquals(expected_num, result_Val);

	}

}
