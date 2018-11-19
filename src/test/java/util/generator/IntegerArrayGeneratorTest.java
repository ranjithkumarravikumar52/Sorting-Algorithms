package util.generator;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class IntegerArrayGeneratorTest {
    private Generator<Integer> integerGenerator;
    private int minRange;
    private int maxRange;
    private int size;

    @Before
    public void setup() {
        integerGenerator = new IntegerArrayGenerator();
    }

    @Test
    public void generateDefaultIntegerArray_Positive() {
        Integer[] integers = integerGenerator.generateArray();
        assertEquals("Integer array(default) generated differs in length", integers.length, 10); //checking default size
    }

    @Test
    public void generateDefaultIntegerArray_TwoArraysNotEqual() {
        Integer[] integers1 = integerGenerator.generateArray();
        Integer[] integers2 = integerGenerator.generateArray();
        assertFalse("Integer arrays(default) are equal!", Arrays.equals(integers1, integers2));
    }

    @Test
    public void generateDefaultIntegerArray_CheckNull() {
        Integer[] integers = integerGenerator.generateArray();
        assertFalse("Integer array(default) generated contains a null value", Arrays.asList(integers).contains(null));
    }

    @Test
    public void generateUserDefinedIntegerArray_Positive() {
        minRange = -10;
        maxRange = 10;
        size = 100;
        try {
            Integer[] integers = integerGenerator.generateArray(size, minRange, maxRange);
            assertEquals("Integer array(user-generated) generated differs in length", size, integers.length);
            List<Integer> integerList = Arrays.asList(integers);
            Integer min = Collections.min(integerList);
            Integer max = Collections.max(integerList);
            assertEquals("minRange should be equal to the min(Inclusive) in the Integer array(user-generated)", (int) min, minRange);
            assertEquals("maxRange should be equal to the max(Exclusive) in the Integer array(user-generated)", (int) max, maxRange - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void generateUserDefinedIntegerArray_Negative() {
        minRange = -10;
        maxRange = 10;
        size = 100;
        try {
            Integer[] integers1 = integerGenerator.generateArray(size, minRange, maxRange);
            Integer[] integers2 = integerGenerator.generateArray(size, minRange, maxRange);
            assertFalse("Integer arrays(default) are equal!", Arrays.equals(integers1, integers2));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void generateUserDefinedIntegerArray_CheckNull() {
        minRange = -10;
        maxRange = 10;
        size = 100;
        try {
            Integer[] integers = integerGenerator.generateArray(size, minRange, maxRange);
            List<Integer> integerList = Arrays.asList(integers);
            assertTrue("Integer array(user-generated) generated contains null", !integerList.contains(null));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}