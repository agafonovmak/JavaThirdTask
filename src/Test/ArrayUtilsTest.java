package Test;

import Homework.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Maxim on 08.11.2016.
 */
public class ArrayUtilsTest {
    @Test
    public void compareIgnoreOrder() throws Exception {
        int[] first = new int[]{1,2,3,4,5};
        int[] second = new int[]{5,3,2,1,4};

        assertTrue(ArrayUtils.compareIgnoreOrder(first,second));
    }

    @Test
    public void changeSize() throws Exception {
        int[] original = new int[]{1,2,3,4,5};
        int[] shortened = new int[]{1,2,3};

        assertTrue(Arrays.equals(ArrayUtils.changeSize(original, 3),
                shortened));
    }

    @Test
    public void shuffle() throws Exception {
        int[] array = new int[]{1,2,3,4,5};

        assertEquals(ArrayUtils.shuffle(array), 5);
    }

}