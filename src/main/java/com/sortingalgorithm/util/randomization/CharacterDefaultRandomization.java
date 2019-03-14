package com.sortingalgorithm.util.randomization;

import java.util.Random;

public class CharacterDefaultRandomization implements DefaultRandomization<Character> {
	/**
	 *
	 * @return any char in the range of [a-z]
	 */
	@Override
	public Character getRandomElement() {
		Random random = new Random();
		return (Character) (char) (97 + random.nextInt(26));
	}
}
