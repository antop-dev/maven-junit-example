package com.pragprog.utj2;

class Largest {

	public static int largest(int... list) {
		if (list.length == 0) {
			throw new RuntimeException("Empty list");
		}

		int max = Integer.MIN_VALUE;
		for (int i : list) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

}
