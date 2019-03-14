package com.sortingalgorithm.util.generator;

import com.sortingalgorithm.util.randomization.ShortDefaultRandomization;

public class ShortArrayGenerator<T extends Short> implements Generator<Short> {
	@Override
	public Short[] generateArray(int size) {
		T[] elements = (T[]) new Object[size];
		for(int i = 0; i < size; i++){
			elements[i] = (T) new ShortDefaultRandomization().getRandomElement();
		}
		return elements;
	}
}
