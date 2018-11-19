package util.generator;

import util.randomization.IntegerRandomization;

public class IntegerArrayGenerator extends Generator<Integer> {

    /**
     * Default size of this method generates an array of size 10 elements
     * @return
     */
    @Override
    protected Integer[] generateArray() {
        Integer[] integers = new Integer[10];
        for(Integer i: integers){
            i = new IntegerRandomization().getRandomElement();
        }
        return integers;
    }

    /**
     * Default size of this method generates an array of "size" elements in [minRange, maxRange]
     * @return
     */
    @Override
    protected Integer[] generateArray(int size, Integer minRange, Integer maxRange) {
        Integer[] integers = new Integer[size];
        for(Integer i: integers){
            i = new IntegerRandomization().getRandomElement(minRange, maxRange);
        }
        return integers;
    }
}
