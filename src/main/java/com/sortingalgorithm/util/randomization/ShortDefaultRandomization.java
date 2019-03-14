package com.sortingalgorithm.util.randomization;

import java.util.Random;

public class ShortDefaultRandomization implements DefaultRandomization<Short> {
	@Override
	public Short getRandomElement() {
		return (short) new Random().nextInt();
	}
}
