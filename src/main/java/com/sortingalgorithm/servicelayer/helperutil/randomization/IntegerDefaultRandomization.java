package com.sortingalgorithm.servicelayer.helperutil.randomization;

import java.util.Random;

public class IntegerDefaultRandomization implements DefaultRandomization<Integer> {

    /**
     * @return gives a random value of default possible values in 2^32 elements
     */
    @Override
    public Integer getRandomElement() {
        return new Random().nextInt();
    }

    /**
     * @return gives a random value of default possible values in minRange(inclusive), maxRange(exclusive)
     */
    // @Override
    // public Integer getRandomElement(Integer minRange, Integer maxRange) {
    //     return (new Random().nextInt(maxRange - minRange) + minRange);
    // }
}
