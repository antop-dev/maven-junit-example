package com.pragprog.utj2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestTest {

	@Test
	public void findTheLargestNumberInTheArray() {
		assertEquals(9, Largest.largest(new int[]{7, 8, 9}));
		assertEquals(9, Largest.largest(new int[]{8, 9, 7}));
		assertEquals(9, Largest.largest(new int[]{9, 7, 8}));
		assertEquals(2, Largest.largest(new int[]{1, 2}));
		assertEquals(1, Largest.largest(new int[]{1}));
		assertEquals(-7, Largest.largest(new int[]{-9, -8, -7}));
	}

	@Test(expected = RuntimeException.class)
	public void ifTheArrayIsEmptyAnErrorOccurs() {
		Largest.largest(new int[0]);
	}

}
