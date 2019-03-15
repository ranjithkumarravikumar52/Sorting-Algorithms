package com.sortingalgorithm.service.randomization;

import java.util.Random;

public class BooleanDefaultRandomization implements DefaultRandomization<Boolean> {
	@Override
	public Boolean getRandomElement() {
		return new Random().nextBoolean();
	}
	//
	// @Override
	// public Boolean getRandomElement(Boolean minRange, Boolean maxRange) {
	// 	return null;
	// }
}
