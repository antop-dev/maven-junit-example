package com.wordpress.technologyconversations.tddtest;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * https://technologyconversations.com/2013/12/20/test-driven-development-tdd-example-walkthrough/
 */
public class StringCalculatorTest {

//	@Test(expected = RuntimeException.class)
//	public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
//		StringCalculator.add("1,2,3");
//	}

	@Test
	public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
		StringCalculator.add("1,2");
		assertTrue(true);
	}

	@Test(expected = NumberFormatException.class)
	public final void whenNonNumberIsUsedThenExceptionIsThrown() {
		StringCalculator.add("1,X");
	}

	@Test
	public final void whenEmptyStringIsUsedThenReturnValueIsZero() {
		assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
		assertEquals(3, StringCalculator.add("3"));
	}

	@Test
	public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
		assertEquals(3 + 6, StringCalculator.add("3,6"));
	}

	@Test
	public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
		assertEquals(3 + 6 + 15 + 18 + 46 + 33, StringCalculator.add("3,6,15,18,46,33"));
	}

	@Test
	public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
		assertEquals(3 + 6 + 15, StringCalculator.add("3,6n15"));
	}

	@Test
	public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
		assertEquals(3 + 6 + 15, StringCalculator.add("//;n3;6;15"));
	}

	@Test(expected = RuntimeException.class)
	public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
		StringCalculator.add("3,-6,15,18,46,33");
	}

	@Test
	public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
		RuntimeException exception = null;
		try {
			StringCalculator.add("3,-6,15,-18,46,33");
		} catch (RuntimeException e) {
			exception = e;
		}
		Assert.assertNotNull(exception);
		assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
	}

	@Test
	public final void whenOneOrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSum() {
		assertEquals(3 + 1000 + 6, StringCalculator.add("3,1000,1001,6,1234"));
	}

	@Test
	@Ignore
	public final void whenAnyLengthDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
		// TODO Your share
		assertEquals(1 + 2 + 3, StringCalculator.add("//[—]\n1—2—3"));
	}

	@Test
	@Ignore
	public final void whenMultipleDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
		// TODO Your share
		assertEquals(1 + 2 + 3, StringCalculator.add("//[-][%]\n1-2%3"));
	}

}
