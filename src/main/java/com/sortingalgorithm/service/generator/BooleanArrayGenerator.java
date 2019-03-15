package com.sortingalgorithm.service.generator;

import com.sortingalgorithm.service.randomization.BooleanDefaultRandomization;

public class BooleanArrayGenerator implements Generator<Boolean> {
	@Override
	public Boolean[] generateArray(int size) {
		Boolean[] elements = new Boolean[size];
		for(int i = 0; i < size; i++){
			elements[i] = new BooleanDefaultRandomization().getRandomElement();
		}
		return elements;
	}
}
