package com.sortingalgorithm.service.generator;

import com.sortingalgorithm.service.randomization.LongDefaultRandomization;

public class LongArrayGenerator implements Generator<Long> {
	@Override
	public Long[] generateArray(int size) {
		Long[] elements = new Long[size];
		for(int i = 0; i < size; i++){
			elements[i] = new LongDefaultRandomization().getRandomElement();
		}
		return elements;
	}
}
