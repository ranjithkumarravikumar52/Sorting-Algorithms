package com.sortingalgorithm.servicelayer.helperutil.generator;

import com.sortingalgorithm.servicelayer.helperutil.randomization.ShortDefaultRandomization;

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
