package Comparator;

/**
 * Created by Никита on 05.11.2016.
 */
public class AscendingIntComparator extends SimpleComparator{

    public int compare(int a, int b) {
        //return a - b;
        if(a > b)
            return 1;
        if(a < b)
            return -1;
            return 0;
    }
}
