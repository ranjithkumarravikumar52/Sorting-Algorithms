package com.sortingalgorithm.util.generator;

import com.sortingalgorithm.util.randomization.CharacterDefaultRandomization;

public class CharacterArrayGenerator<T extends Character> implements Generator<Character> {
	@Override
	public T[] generateArray(int size) {
		T[] elements = (T[]) new Object[size];
		for(int i = 0; i < size; i++){
			elements[i] = (T) new CharacterDefaultRandomization().getRandomElement();
		}
		return elements;
	}
}
