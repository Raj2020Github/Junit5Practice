/**
 * 
 */
package com.giffgaff.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author ntttech03
 *
 */
public class StringTest {

	private String str;

	@Test
	void word_length_test() {
		// fail("Not yet implemented");
		int length = "Hello World".length();
		int expected = 11;
		assertEquals(expected, length);
	}

	@Test
	void length_basic() {
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		assertEquals(expectedLength, actualLength);
	}

	@Test
	void contains_test() {
		String name = "Rajkumar";
		boolean actual = name.contains("ma");
		assertTrue(actual);
		assertTrue(name.contains("aj"));
		assertFalse(name.contains("Aj"));
		assertFalse(name.contains("v"));

	}

	@Test
	void uppercase_test() {

		String state = "Andhra";
		String result = state.toUpperCase();

		assertEquals("ANDHRA", result);

	}

	@Test

	void null_test() {
		try {
			String line = "Hello World";
			String empty = null;
			String expected = line.substring(2, 5);
			assertNull(empty);
			assertNotNull(expected);
		} catch (Exception e) {

		}
	}

	@Test
	void arrayValue_test() {

		String str = "Hello World this is junit5";
		// String str = "Hello Java";
		String[] actualResult = str.split(" ");
		String[] expectedResult = { "Hello", "World", "this", "is", "junit5" };
		// String[] expectedResult = new String[]{"Hello","Java"};
		assertArrayEquals(expectedResult, actualResult);

	}

	@Test
	void str_length_greater_than_zero() {
		assertTrue("Hello".length() > 0);
		assertTrue("ASDF".length() > 0);
		assertTrue("A".length() > 0);
		// assertTrue("".length() > 0); //
		assertFalse("".length() > 0);
	}

	@Nested
	@DisplayName("For large strings")
	class LargeStringTests {

		@BeforeEach
		void setToALargeString() {
			str = "Telling the community about yourself helps other members connect with you on the topics you're most interested in.";
		}

		@Test
		void test() {

		}

	}

	@Test
	public void testAppend() throws Throwable {
		StringBuffer testObject = new StringBuffer("a");
		testObject.append("b");
		assertEquals("ab", testObject.toString());
	}

	@ParameterizedTest
	@ValueSource(strings = { "AABB", "BCC", "ANB", "V" })
	void length_greater_than_zero_using_parameterized_test(String str) {
		assertTrue(str.length() > 0);
	}

	@ParameterizedTest
	@ValueSource(strings = { "", "", "", "" })
	void length_zero_using_parameterized_test(String str) {
		assertFalse((str.length() > 0));
	}

	@ParameterizedTest(name = "{0} toUpperCase is {1}")
	@CsvSource(value = { "abcd, ABCD", "abc, ABC", "'',''", "giffgaff, GIFFGAFF" })
	void uppercase_test(String word, String capitalizedWord) {
		assertEquals(capitalizedWord, word.toUpperCase());
	}

	@ParameterizedTest(name = "{0} length is {1}")
	@CsvSource(value = { "nttdata, 7", "abc, 3", "'',0", "giffgaff, 8" })
	void str_length_test(String word, int expectedLength) {
		assertEquals(expectedLength, word.length());
	}

}
