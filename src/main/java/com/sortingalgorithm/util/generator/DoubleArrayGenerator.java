package com.sortingalgorithm.util.generator;

import com.sortingalgorithm.util.randomization.DoubleDefaultRandomization;

public class DoubleArrayGenerator<T extends Double> implements Generator<Double> {
	@Override
	public Double[] generateArray(int size) {
		T[] elements = (T[]) new Object[size];
		for(int i = 0; i < size; i++){
			elements[i] = (T) new DoubleDefaultRandomization().getRandomElement();
		}
		return elements;
	}
}
