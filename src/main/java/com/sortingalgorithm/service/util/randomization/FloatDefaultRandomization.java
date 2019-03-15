package com.sortingalgorithm.service.util.randomization;

import java.util.Random;

public class FloatDefaultRandomization implements DefaultRandomization<Float> {
	@Override
	public Float getRandomElement() {
		return new Random().nextFloat();
	}
}
