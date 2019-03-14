package com.sortingalgorithm.util.generator;

import com.sortingalgorithm.util.randomization.BooleanDefaultRandomization;

public class BooleanArrayGenerator<T extends Boolean> implements Generator<Boolean> {
	@Override
	public T[] generateArray(int size) {
		T[] elements = (T[]) new Object[size];
		for(int i = 0; i < size; i++){
			elements[i] = (T) new BooleanDefaultRandomization().getRandomElement();
		}
		return elements;
	}
}
