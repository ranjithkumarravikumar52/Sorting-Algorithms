package com.sortingalgorithm.util.generator;

import com.sortingalgorithm.util.randomization.FloatDefaultRandomization;

public class FloatArrayGenerator implements Generator<Float> {
	@Override
	public Float[] generateArray(int size) {
		Float[] elements =  new Float[size];
		for(int i = 0; i < size; i++){
			elements[i] = new FloatDefaultRandomization().getRandomElement();
		}
		return elements;
	}
}
