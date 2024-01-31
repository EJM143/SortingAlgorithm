package SortingAlgorithms;

/**
 * Quicksort algorithm with median of 3 pivot
 */
public class Quicksort_MedianOf3 implements SortingAlgoInterface {
    //precondition: first and last is a range of at least 3 items in the proper order
    /**
     * Sorts among three elements and returns the index of the median value as the pivot
     * @param first the first index of the portion to sort, and the first element
     * @param last the last index of the portion to sort, and the last element
     * @return index of the pivot
     */
    public static int selectPivot(int[] arr, int first, int last) {
        //if first < 0...?
        //sort among themselves, then choose middle value (return mid index)
        int mid = first + (last - first) / 2;
        //if first > mid, swap, if new mid > last, swap, if new first > new mid, swap
        if (arr[first] > arr[mid]) swap(arr, first, mid);
        if (arr[mid] > arr[last]) swap(arr, mid, last);
        if (arr[first] > arr[mid]) swap(arr, first, mid);
        return mid;
    }
    @Override
    public String getName() {
        return "QuickSort, Median of 3 Pivot";
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
        if (arr != null) {
            if (arr.length < 3) {
                Quicksort_FirstPivot.quicksort(arr);
            } else {
                int last = arr.length - 1;
                sort(arr, selectPivot(arr, 0, last), 0, last);
            }
        }
    }

    /**
     * Leverages quicksort algorithm to sort only part of an array. Does nothing if array is null, or bad indexes given
     * @param arr the array to be partially sorted, should not be null
     * @param startIndex first index of the portion to be sorted, should be 0 <= start <= end <= arr.length
     * @param endIndex last index of the portion to be sorted
     */
    public static void sort_partial(int[] arr, int startIndex, int endIndex) {
        //if arr is null and longer than 1 element
            //if end - start is less than 3 elements, quicksortPartial()
            //else if valid indexes, sort recursively
        if (arr != null && arr.length > 1)
            if (endIndex - startIndex < 2) {Quicksort_FirstPivot.sort_partial(arr, startIndex, endIndex);}
            else if (startIndex >= 0 && startIndex < arr.length && startIndex <= endIndex &&
                endIndex < arr.length) {
            sort(arr, selectPivot(arr, startIndex, endIndex), startIndex, endIndex);
        }
    }

    //precondition: arr is not null, range in acceptable index range for arr
    /**
     * Recursively sorts the array
     * @param arr the array to be sorted
     * @param pivotIndex index of the pivot
     * @param first first index of the portion to be sorted
     * @param last last index of the portion to be sorted
     */
    private static void sort(int[] arr, int pivotIndex, int first, int last) {
        //if first >= last, end
        //if last - first < 2, sort
        //else, partition, then sort left and right halves

        //base case: first >= last (one or zero items can't be split)
        //recursive case: put pivot in place and call recursively
        //if more than 2 items, do the thing
        if (first < last) {
            if (last - first < 2) {
                Quicksort_FirstPivot.sort(arr, pivotIndex, first, last);
            } else {
                pivotIndex = partition(arr, pivotIndex, first, last);
                //what if pivot index - 1 < 0? then don't do left half
                //what if first to last is fewer than 3 items? then don't use selectPivot
                int lastLeft = pivotIndex - 1;
                if (lastLeft >= 0)  {
                    int pivotLeft = first;
                    if (lastLeft - pivotLeft >= 2) {
                        pivotLeft = selectPivot(arr, first, lastLeft);
                    }
                    sort(arr, pivotLeft, first, lastLeft);
                }
                //sort right half
                sort(arr, selectPivot(arr, pivotIndex + 1, last), pivotIndex + 1, last);
            }
        }
    }

    //TODO: add: do not process first and last or pivot
    /**
     * Places the pivot into its final spot and smaller items to the left and larger items to the right
     * @param arr   the array to be sorted
     * @param pivotIndex    index of the pivot
     * @param first first index of the portion to be sorted
     * @param last  last index of the portion to be sorted
     * @return the index of the pivot that is now in its final position
     */
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
