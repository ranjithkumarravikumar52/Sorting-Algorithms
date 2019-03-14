package com.sortingalgorithm.util.generator;

import com.sortingalgorithm.util.randomization.DoubleDefaultRandomization;

public class DoubleArrayGenerator implements Generator<Double> {
	@Override
	public Double[] generateArray(int size) {
		Double[] elements =  new Double[size];
		for(int i = 0; i < size; i++){
			elements[i] = new DoubleDefaultRandomization().getRandomElement();
		}
		return elements;
	}
}
