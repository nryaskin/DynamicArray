package Comparator;

/**
 * Created by Никита on 05.11.2016.
 */
public class DescendingIntComparator extends SimpleComparator {
    public int compare(int a, int b) {
        //return b - a;
        if(b > a)
            return 1;
        if(b < a)
            return -1;
        return 0;
    }
}
