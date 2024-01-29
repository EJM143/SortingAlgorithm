package SortingAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class QuicksortTest {

    @Test
    public void test_sort_firstPivot() {
        //should not have issues if given null
        int[] arr = null;
        Quicksort obj = new Quicksort();
        obj.sort(arr);
        assertNull(arr);

        //should not change anything or have issues for 0 length arr
        arr = new int[0];
        obj.sort(arr);
        assertArrayEquals(new int[0], arr);

        //should not change or have issues with 1 length arr
        arr = new int[]{9};
        obj.sort(arr);
        assertArrayEquals(new int[]{9}, arr);

        //should not alter sorted arr
        arr = new int[]{6,9};
        obj.sort(arr);
        assertArrayEquals(new int[]{6, 9}, arr);

        //should sort two item array
        arr = new int[]{9,6};
        obj.sort(arr);
        assertArrayEquals(new int[]{6, 9}, arr);

        //should sort unsorted arr
        arr = new int[]{9,6, 3, 1, 7};
        obj.sort(arr);
        assertArrayEquals(new int[]{1, 3, 6, 7, 9}, arr);

        //should sort unsorted arr
        arr = new int[]{1,6, 3, 7, 9};
        obj.sort(arr);
        assertArrayEquals(new int[]{1, 3, 6, 7, 9}, arr);
    }

    @Test
    public void test_partition() {

    }
}