package com.sortingalgorithm.servicelayer.sortalgorithms;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class InsertionSortTest {

	@Test
	public void sort() {
		SortAlgorithm<Integer> sortAlgorithm = new InsertionSort<>();
		assertArrayEquals(new Integer[]{1,2,3,3,4}, sortAlgorithm.sort(new Integer[]{3,3,4,2,1}));
		assertArrayEquals(new Integer[]{}, sortAlgorithm.sort(new Integer[]{}));
		assertArrayEquals(null, sortAlgorithm.sort(null));
	}
}