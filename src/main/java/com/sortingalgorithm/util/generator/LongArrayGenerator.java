package com.sortingalgorithm.util.generator;

import com.sortingalgorithm.util.randomization.LongDefaultRandomization;

public class LongArrayGenerator<T extends Long> implements Generator<Long> {
	@Override
	public Long[] generateArray(int size) {
		T[] elements = (T[]) new Object[size];
		for(int i = 0; i < size; i++){
			elements[i] = (T) new LongDefaultRandomization().getRandomElement();
		}
		return elements;
	}
}
