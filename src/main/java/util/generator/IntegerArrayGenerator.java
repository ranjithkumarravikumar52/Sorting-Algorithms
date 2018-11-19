package util.generator;

import util.randomization.IntegerRandomization;

public class IntegerArrayGenerator extends Generator<Integer> {

    /**
     * Default size of this method generates an array of size 10 elements
     * @return newly generated integer array of default range
     */
    @Override
    protected Integer[] generateArray() {
        Integer[] integers = new Integer[10];
        for(int i = 0; i < 10; i++){
            integers[i] = new IntegerRandomization().getRandomElement();
        }
        return integers;
    }

    /**
     * Default size of this method generates an array of "size" elements in minRange(inclusive), maxRange(exclusive)
     * @return newly generated integer array of user defined range
     */
    //TODO LBYL/EAFP/Exception when minRange > maxRange
    @Override
    protected Integer[] generateArray(int size, Integer minRange, Integer maxRange) throws Exception {
        if(minRange <= maxRange){
            Integer[] integers = new Integer[size];
            for(int i = 0; i < size; i++){
                integers[i] = new IntegerRandomization().getRandomElement(minRange, maxRange);
            }
            return integers;
        }else{
            throw new Exception("minRange should be greater than or equal to maxRange");
        }
    }
}
