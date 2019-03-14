package com.sortingalgorithm.util.generator;

import com.sortingalgorithm.util.randomization.ByteDefaultRandomization;

public class ByteArrayGenerator<T extends Byte> implements Generator<Byte> {
	@Override
	public Byte[] generateArray(int size) {
		T[] integers = (T[]) new Object[size];
		for(int i = 0; i < size; i++){
			integers[i] = (T) new ByteDefaultRandomization().getRandomElement();
		}
		return integers;
	}
}
