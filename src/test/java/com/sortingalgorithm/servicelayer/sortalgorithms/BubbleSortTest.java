package com.sortingalgorithm.servicelayer.sortalgorithms;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortTest {

	@Test
	public void sort() {
		SortAlgorithm<Integer> bubbleSort = new BubbleSort<>();
		assertArrayEquals(new Integer[]{1,2,3,3,4}, bubbleSort.sort(new Integer[]{3,3,4,2,1}));
		assertArrayEquals(new Integer[]{}, bubbleSort.sort(new Integer[]{}));
		assertArrayEquals(null, bubbleSort.sort(null));
	}
}