package util.swapelements;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntSwappableTest{

    private IntSwappableImplements intSwappableImplements;
    private int[] checkArray = {1,3,2};

    @Before
    public void setup(){
        intSwappableImplements = new IntSwappableImplements();
    }

    @Test
    public void swap() {
        intSwappableImplements.swap(checkArray, 1,2);
        assertArrayEquals(new int[]{1,2,3}, checkArray);
    }
}

class IntSwappableImplements implements IntSwappable{

    @Override
    public boolean swap(int[] array, int firstIndex, int secondIndex) {
        if (firstIndex == secondIndex) {
            return false;
        }

        Integer temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
        return true;
    }
}