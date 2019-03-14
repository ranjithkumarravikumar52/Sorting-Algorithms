package com.sortingalgorithm.util.generator;

import com.sortingalgorithm.util.randomization.ShortDefaultRandomization;

public class ShortArrayGenerator implements Generator<Short> {
	@Override
	public Short[] generateArray(int size) {
		Short[] elements = new Short[size];
		for(int i = 0; i < size; i++){
			elements[i] = new ShortDefaultRandomization().getRandomElement();
		}
		return elements;
	}
}
