package util.generator;

import util.randomization.Randomization;

/**
 * To generate an array of elements of type T
 */
public abstract class Generator<T> {

    private T[] generatedArray;
    protected Randomization<T> randomization;

    protected abstract T[] generateArray();

    protected abstract T[] generateArray(int size, T minRange, T maxRange);

}
