package ComparatorTests;

import Comparator.AscendingIntComparator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


import static junit.framework.TestCase.assertEquals;
/**
 * Created by Никита on 04.11.2016.
 */
@RunWith(Parameterized.class)
public class SimpleAscendingComparatorTest {

    private int inputFirst;
    private int inputSecond;
    private int expectedResult;


    public SimpleAscendingComparatorTest(int inputFirst, int inputSecond, int expectedResult){
        this.inputFirst = inputFirst;
        this.inputSecond = inputSecond;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection comparatorInput(){
        return Arrays.asList(new Object[][]{
                {20, 20, 0},
                {20, 10, 1},
                {20, 30, -1}
        });
    }

    @Test
    public void simpleAscendingIntComparatorTest(){
        assertEquals(expectedResult, new AscendingIntComparator().compare(inputFirst, inputSecond));
    }
}
