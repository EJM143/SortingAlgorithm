package SortingAlgorithms;

/**
 * Base quicksort class, uses first pivot scheme, see other quicksort algorithms for other options
 */
public class Quicksort implements SortingAlgoInterface {
    //select pivot (1 of 3 options)
    //partition
    //sort
    @Override
    public void sort(int[] arr) {
        quicksort(arr);
    }
    @Override
    public String getName() {
        return "QuickSort, First Index Pivot";
    }

    //select 1: return first
    //select random: return random between first, last inclusive
    //select median of 3: if >= 3, sort, else sort among pivots and return mid
    /**
     * Selects pivot for this quicksort's pivot selection scheme
     * @param arr the array to sort
     * @param first the first index of the portion to sort
     * @param last the last index of the portion to sort
     * @return index of the pivot
     */
    private static int selectPivot(int[] arr, int first, int last) {
        return first;
    }

    /**
     * Sorts the array
     * @param arr array to be sorted
     */
    public static void quicksort(int[] arr) {
        if (arr != null && arr.length > 1) {
            int last = arr.length - 1;
            sort(arr, selectPivot(arr, 0, last), 0, last);
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
            sort(arr, selectPivot(arr, startIndex, endIndex), startIndex, endIndex);
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
            sort(arr, selectPivot(arr, first, pivotIndex -1), first, pivotIndex -1);
            sort(arr, selectPivot(arr, pivotIndex + 1, last), pivotIndex + 1, last);
        }
    }


    private static int partition(int[] arr, int pivotIndex, int first, int last) {
        //swap pivot with last index
        //wall = first
        //for every item including wall up to pivot
        //if less than pivot, swap with wall++
        //else, next item
        //swap pivot and wall
        //return wall
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

    public static void swap(int[] arr, int index1, int index2) {
        int item1 = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = item1;
    }
}



