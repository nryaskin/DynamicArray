package DynamicArrayOfIntTests;

import Comparator.AscendingIntComparator;
import Comparator.DescendingIntComparator;
import Comparator.SimpleComparator;
import DynamicArrayOfInt.DynamicArrayOfInt;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

/**
 * Created by Никита on 04.11.2016.
 */
public class DynamicArrayOfIntTest {

    DynamicArrayOfInt dynamicArrayOfInt;
    ArrayList<Integer> arrayList;
    Random rand;
    @Before
    public void dynamicArrayOfIntTest(){
        rand = new Random();
        dynamicArrayOfInt = new DynamicArrayOfInt();
        arrayList = new ArrayList<Integer>();
        for(int i = 0; i < 500000; i++) {
            int number = rand.nextInt();
            arrayList.add(number);
            dynamicArrayOfInt.add(number);

        }
    }


    @Test
    public void dynamicArrayOfIntAddFiveHundredThousandElementsTest(){
        for(int i = 0; i < 500000; i++)
        dynamicArrayOfInt.add(i);
    }

    @Test
    public void dynamicArrayOfIntGetElementWithIndexThree(){
        assertEquals("array[3] must be 3", (int)arrayList.get(3), dynamicArrayOfInt.get(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void dynamicArrayOfIntGetThrowingIndexOutOfBoundExceptionTest(){
        dynamicArrayOfInt.get(500000);
    }

    @Test
    public void dynamicArrayOfIntInsertTest(){
        dynamicArrayOfInt.insert(4,3);
        assertEquals("array[4] must be 3",3, dynamicArrayOfInt.get(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void dynamicArrayOfIntInsertThrowingIndexOutOfBoundExceptionTest(){
        dynamicArrayOfInt.insert(500001, 590);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void dynamicArrayOfIntDeleteThrowingIndexOutOfBoundExceptionTest(){
        dynamicArrayOfInt.remove(500000);
    }

    @Test
    public void dynamicArrayOfIntDeleteFromFifthPositionTest(){
        assertEquals("dynamicArrayOfInt.remove(5) should be 5 ", (int)arrayList.remove(5), dynamicArrayOfInt.remove(5));
    }

    @Test
    public void dynamicArrayOfIntToArrayTest(){
        Integer[] outputArray = dynamicArrayOfInt.toArray(new Integer[dynamicArrayOfInt.size()]);
        assertArrayEquals(arrayList.toArray(new Integer[arrayList.size()]), outputArray);
    }

    @Test
    public void dynamicArrayOfIntAscSortTest(){
        dynamicArrayOfInt.sort(new AscendingIntComparator());
        Collections.sort(arrayList);
        Integer[] expectedArray = arrayList.toArray(new Integer[arrayList.size()]);
        assertArrayEquals(expectedArray, dynamicArrayOfInt.toArray(new Integer[dynamicArrayOfInt.size()]));
    }
    @Test
    public void dynamicArrayOfIntDescSortTest(){
        dynamicArrayOfInt.sort(new DescendingIntComparator());
        Comparator<Integer> descComparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        Collections.sort(arrayList, descComparator);
        Integer[] expectedArray = arrayList.toArray(new Integer[arrayList.size()]);
        assertArrayEquals(expectedArray, dynamicArrayOfInt.toArray(new Integer[dynamicArrayOfInt.size()]));
    }

}
