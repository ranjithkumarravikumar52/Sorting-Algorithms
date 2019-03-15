package com.sortingalgorithm.service.helperutil.generator;

import com.sortingalgorithm.service.helperutil.randomization.ByteDefaultRandomization;

public class ByteArrayGenerator implements Generator<Byte> {
	@Override
	public Byte[] generateArray(int size) {
		Byte[] bytes = new Byte[size];
		for(int i = 0; i < size; i++){
			bytes[i] = new ByteDefaultRandomization().getRandomElement();
		}
		return bytes;
	}
}
