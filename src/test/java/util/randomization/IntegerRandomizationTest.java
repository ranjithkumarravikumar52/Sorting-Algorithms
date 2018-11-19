package util.randomization;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class IntegerRandomizationTest {

    private static List<Integer> randomIntegerList = new ArrayList<>(100);
    private int min;
    private int max;

    /**
     * minRange(inclusive), maxRange(exclusive)
     */
    private List<Integer> simulate(int min, int max) {
        for (int i = 0; i < 100; i++) {
            randomIntegerList.add(new IntegerRandomization().getRandomElement(min, max));
        }
        return randomIntegerList;
    }

    /**
     * minRange(inclusive), maxRange(exclusive)
     */
    @Test
    public void getRandomElement_Default_Positive() {
        Integer randomElement = new IntegerRandomization().getRandomElement();
        min = -2_147_483_648;
        max = 2_147_483_647;
        assertTrue("Randomly generated integer must be in the range [-2_147_483_648, 2_147_483_647]," +
                        " but generated random integer value is: " + randomElement,
                randomElement < max && randomElement >= min);
    }

    /**
     * minRange(inclusive), maxRange(exclusive)
     */
    @Test
    public void getRandomElement_Default_Negative() {
        Long randomElement = 1234567890123456789L;
        min = -2_147_483_648;
        max = 2_147_483_647;
        assertFalse("Randomly generated integer must be in the range [-2_147_483_648, 2_147_483_647]," +
                        " but generated random integer value is: " + randomElement,
                randomElement < max && randomElement >= min);
    }

    /**
     * minRange(inclusive), maxRange(exclusive)
     */
    @Test
    public void getRandomElement_Default_CheckNull() {
        Integer randomElement = new IntegerRandomization().getRandomElement();
        assertNotNull("Randomly generated integer should never be null", randomElement);
    }

    /**
     * minRange(inclusive), maxRange(exclusive)
     */
    @Test
    public void getRandomElement_UserDefinedRange_WithInRange() {
        min = 10;
        max = 20;
        Integer randomElement = new IntegerRandomization().getRandomElement(min, max);
        boolean condition = randomElement < max && randomElement >= min;
        assertTrue(new StringBuilder()
                        .append("Randomly generated integer must be in the range of [")
                        .append(min)
                        .append(", ")
                        .append(max)
                        .append("]")
                        .append(" but generated random integer value is: ")
                        .append(randomElement)
                        .toString(),
                condition);
    }

    /**
     * minRange(inclusive), maxRange(exclusive)
     */
    @Test
    public void getRandomElement_UserDefinedRange_CheckMax() {
        min = 1;
        max = 3;
        List<Integer> randomIntegerList = simulate(min, max);
        boolean condition = (max - 1 == Collections.max(randomIntegerList));
        assertTrue(new StringBuilder()
                        .append("Randomly generated integers must have a max value of")
                        .append(max - 1)
                        .toString(),
                condition);
    }

    /**
     * minRange(inclusive), maxRange(exclusive)
     */
    @Test
    public void getRandomElement_UserDefinedRange_CheckMin() {
        min = -1;
        max = 3;
        List<Integer> randomIntegerList = simulate(min, max);
        boolean condition = (min == Collections.min(randomIntegerList));
        assertTrue(new StringBuilder()
                        .append("Randomly generated integers must have a min value of")
                        .append(min)
                        .toString(),
                condition);
    }

    @Test
    public void getRandomElement_UserDefinedRange_CheckNull() {
        min = -10;
        max = 100;
        List<Integer> randomIntegerList = simulate(min, max);
        boolean containsNull = randomIntegerList.contains(null);
        assertFalse(new StringBuilder()
                        .append("Randomly generated integers must never have null")
                        .append(min)
                        .toString(),
                containsNull);
    }

}