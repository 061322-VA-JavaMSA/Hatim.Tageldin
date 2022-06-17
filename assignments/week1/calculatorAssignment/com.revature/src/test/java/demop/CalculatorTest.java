package demop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.DivideBy0Exception;
import exceptions.Number13Exception;

public class CalculatorTest {

	private static Calculator sut;

	/*
	 * JUnit 5 - @BeforeAll - @BeforeEach - @AfterAll - @AfterEach
	 * 
	 * - @Test - @Ignore - @Order
	 */

	// Used to set up the test
	@BeforeAll
	public static void setUp() {
		sut = new Calculator();
	}

	@AfterAll
	public static void tearDown() {
		System.out.println("Tear down behavior.");
	}

	@BeforeEach
	public void before() {
		System.out.println("@Before each behavior");
	}

	@Test
	public void addOneAndTwo() {
		int expected = 3;
		int actual = sut.add(1, 2);

		assertEquals(expected, actual);
	}

	@Test
	public void addEightAndFive() {
		assertThrows(Number13Exception.class, () -> sut.add(8, 5));
	}

	@Test
	public void addZeroAndThirteen() {
		assertThrows(Number13Exception.class, () -> sut.add(0, 13));
	}

	@Test
	public void subTenAndFive() {
		int expected = 5;
		int actual = sut.subtract(10, 5);

		assertEquals(expected, actual);
	}

	@Test
	public void divideFiveAndZero() {	
		assertThrows(DivideBy0Exception.class, () -> sut.divide(5, 0));
	}

	@Test
	public void divFiveAndTwo() {
		float expected = 2.5f;
		float actual = sut.divide(5, 2);

		assertEquals(expected, actual);
	}

	@Test
	public void addOneAndTwelveArray() {
		int expected = 13;
		int[] arr = new int[2];
		arr[0] = 1;
		arr[1] = 12;
		int actual = sut.sumOfAnArray(arr);

		assertEquals(expected, actual);
	}
}
