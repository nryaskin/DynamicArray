package DynamicArrayOfInt;

import Comparator.SimpleComparator;

/**
 * Created by Никита on 04.11.2016.
 */
public class DynamicArrayOfInt {

    private final static int MINIMAL_SIZE_OF_DYNAMIC_ARRAY = 16;

    int[] array;
    int count;

    public DynamicArrayOfInt(){
        array = new int[MINIMAL_SIZE_OF_DYNAMIC_ARRAY];
        count = 0;
    }

    public int size(){
        return count;
    }

    public void add(int element) {
        if(count == array.length){
            resize();
        }

        array[count] = element;
        count++;
    }

    private void resize(){

            int[] tmpArray = new int[array.length*2];
            for (int i = 0; i < array.length; i++)
                tmpArray[i] = array[i];
            array = tmpArray;
    }

    public int get(int index) {
        if(index >= count)
            throw new IndexOutOfBoundsException();
        return array[index];
    }

    public void insert(int index, int element) {
        if(index > count)
            throw new IndexOutOfBoundsException();
        if(count == array.length){
            resize();
        }
        for(int i = count; i > index; i--){
            array[i] = array[i-1];
        }
        array[index] = element;
        count++;
    }

    public int remove(int index) {
        if(index >= count)
            throw new IndexOutOfBoundsException();
        int e = array[index];
        for(int i = index; i < count; i++)
            array[i] = array[i+1];
        count--;
        return e;
    }

    private void clear(){
        array = new int[MINIMAL_SIZE_OF_DYNAMIC_ARRAY];
        count = 0;
    }


    public Integer[] toArray(Integer[] integers) {
        if(integers == null)
            throw new NullPointerException();
        if(integers.length != count){
            integers = new Integer[count];
        }
        for(int i = 0; i< count; i++){
            integers[i] = array[i];
        }
        return integers;
    }

    public void sort(SimpleComparator comparator) {
        quickSort(0, count - 1, comparator);
    }

    private void quickSort(int lowerIndex, int higherIndex, SimpleComparator comparator){
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];

        while (i <= j) {
            while (comparator.compare(array[i],pivot) < 0/*array[i] < pivot*/) {
                i++;
            }
            while (comparator.compare(array[j],pivot) > 0/*array[j] > pivot*/) {
                j--;
            }
            if (i <= j) {
                exchangeElements(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j, comparator);
        if (i < higherIndex)
            quickSort(i, higherIndex,comparator);
    }

    private void exchangeElements(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
