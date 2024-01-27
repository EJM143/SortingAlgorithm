
package SortingAlgorithms;

/**
 * Quicksort algorithms with various pivot options
 */
public class Quicksort {
    //select pivot (1 of 3 options)
    //partition
    //sort

    public static void sort_partial(int[] arr, int startIndex, int endIndex) {
        if (arr != null && arr.length > 1 &&
                startIndex >= 0 && startIndex < arr.length && startIndex <= endIndex &&
                endIndex < arr.length) {
            sort_firstPivot(arr, startIndex, startIndex, endIndex);
        }
    }
    public static void sort_firstPivot(int[] arr) {
        if (arr != null && arr.length > 1) {
            sort_firstPivot(arr, 0, 0, arr.length - 1);
        }
    }

    private static void sort_firstPivot(int[] arr, int pivotIndex, int first, int last) {
        //base case: first >= last (one or zero items can't be split)
        //recursive case: put pivot in place and call recursively
        //if more than 2 items, do the thing
        if (first < last) {
            pivotIndex = partition(arr, pivotIndex, first, last);
            sort_firstPivot(arr, first, first, pivotIndex -1);
            sort_firstPivot(arr, pivotIndex + 1, pivotIndex + 1, last);
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
    public void sort_randomPivot(int[] arr) {}
    public void sort_medianOf3Pivot(int[] arr) {}
    public static void swap(int[] arr, int index1, int index2) {
        int item1 = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = item1;
    }
}

