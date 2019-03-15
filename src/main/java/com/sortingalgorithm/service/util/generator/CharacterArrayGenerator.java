package com.sortingalgorithm.service.util.generator;

import com.sortingalgorithm.service.util.randomization.CharacterDefaultRandomization;

public class CharacterArrayGenerator implements Generator<Character> {
	@Override
	public Character[] generateArray(int size) {
		Character[] elements = new Character[size];
		for(int i = 0; i < size; i++){
			elements[i] = new CharacterDefaultRandomization().getRandomElement();
		}
		return elements;
	}
}
