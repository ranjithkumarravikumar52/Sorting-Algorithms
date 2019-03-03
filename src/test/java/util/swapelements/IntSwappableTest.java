package util.swapelements;

import com.sortingalgorithm.util.swapelements.ObjectSwappable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class IntSwappableTest{

    private IntSwappableImplements intSwappableImplements;
    private Integer[] checkArray = {1,3,2};

    @Before
    public void setup(){
        intSwappableImplements = new IntSwappableImplements();
    }

    @Test
    public void swap() {
        intSwappableImplements.swap(checkArray, 1,2);
        assertArrayEquals(new Integer[]{1,2,3}, checkArray);
    }
}

class IntSwappableImplements implements ObjectSwappable<Integer> {

    @Override
    public boolean swap(Integer[] array, int firstIndex, int secondIndex) {
        if (firstIndex == secondIndex) {
            return false;
        }

        Integer temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
        return true;
    }
}