package SortingAlgorithms;

import java.util.Random;

/**
 * Quicksort algorithm using random element as the pivot
 */
public class Quicksort_RandomPivot implements SortingAlgoInterface {
    /**
     * Returns a random index between first and last inclusive to use as the pivot
     * @param first the first index of the portion to sort
     * @param last the last index of the portion to sort
     * @return index of the pivot
     */
    public static int selectPivot(int first, int last) {
        int index = first;
        if (first < last) {
            Random random = new Random();
            index = random.nextInt(first, last + 1);
        }
        return index;
    }

    @Override
    public String getName() {
        return "QuickSort, Random Pivot";
    }

    @Override
    public void sort(int[] arr) {
        quicksort(arr);
    }

    /**
     * Sorts the array
     * @param arr array to be sorted
     */
    public static void quicksort(int[] arr) {
        if (arr != null && arr.length > 1) {
            int last = arr.length - 1;
            sort(arr, selectPivot(0, last), 0, last);
        }
    }

    /**
     * Leverages quicksort algorithm to sort only part of an array. Does nothing if array is null, or bad indexes given
     * @param arr the array to be partially sorted, should not be null
     * @param startIndex first index of the portion to be sorted, should be 0 <= start <= end <= arr.length
     * @param endIndex last index of the portion to be sorted
     */
    public static void sort_partial(int[] arr, int startIndex, int endIndex) {
        if (arr != null && arr.length > 1 &&
                startIndex >= 0 && startIndex < arr.length && startIndex <= endIndex &&
                endIndex < arr.length) {
            sort(arr, selectPivot(startIndex, endIndex), startIndex, endIndex);
        }
    }

    /**
     * Recursively sorts the array
     * @param arr the array to be sorted
     * @param pivotIndex index of the pivot
     * @param first first index of the portion to be sorted
     * @param last last index of the portion to be sorted
     */
    private static void sort(int[] arr, int pivotIndex, int first, int last) {
        //base case: first >= last (one or zero items can't be split)
        //recursive case: put pivot in place and call recursively
        //if more than 2 items, do the thing
        if (first < last) {
            pivotIndex = partition(arr, pivotIndex, first, last);
            sort(arr, selectPivot(first, pivotIndex -1), first, pivotIndex -1);
            sort(arr, selectPivot(pivotIndex + 1, last), pivotIndex + 1, last);
        }
    }


    /**
     * Places the pivot into its final spot and smaller items to the left and larger items to the right
     * @param arr   the array to be sorted
     * @param pivotIndex    index of the pivot
     * @param first first index of the portion to be sorted
     * @param last  last index of the portion to be sorted
     * @return the index of the pivot that is now in its final position
     */
    private static int partition(int[] arr, int pivotIndex, int first, int last) {
        swap(arr, pivotIndex, last);
        int wallIndex = first;
        for (int index = first; index < last; index++) {
            if (arr[index] < arr[last]) {
                swap(arr, index, wallIndex);
                wallIndex++;
            }
        }
        swap(arr, last, wallIndex);
        return wallIndex;
    }

    /**
     * Swaps the positions of the items at the given indexes
     * @param arr   array within which to swap
     * @param index1 index of the first item to swap
     * @param index2 index of the second item to swap
     */
    public static void swap(int[] arr, int index1, int index2) {
        int item1 = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = item1;
    }
}