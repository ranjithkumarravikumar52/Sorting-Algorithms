package com.sortingalgorithm.util.generator;

import com.sortingalgorithm.util.randomization.FloatDefaultRandomization;

public class FloatArrayGenerator<T extends Float> implements Generator<Float> {
	@Override
	public T[] generateArray(int size) {
		T[] elements = (T[]) new Object[size];
		for(int i = 0; i < size; i++){
			elements[i] = (T) new FloatDefaultRandomization().getRandomElement();
		}
		return elements;
	}
}
