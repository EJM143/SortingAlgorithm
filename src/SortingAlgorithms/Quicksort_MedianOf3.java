package SortingAlgorithms;

/**
 * Quicksort algorithm with median of 3 pivot
 */
public class Quicksort_MedianOf3 implements SortingAlgoInterface {
        //precondition: first and last is a range of at least 3 items in the proper order
        public static int selectPivot(int[] arr, int first, int last) {
            //sort among themselves, then choose middle value (return mid index)
            int mid = first + (last - first) / 2;
            //if first > mid, swap, if new mid > last, swap, if new first > new mid, swap
            if (arr[first] > arr[mid]) swap(arr, first, mid);
            if (arr[mid] > arr[last]) swap(arr, mid, last);
            if (arr[first] > arr[mid]) swap(arr, first, mid);
            return mid;
        }
    //select 1: return first
    //select random: return random between first, last inclusive

        @Override
        public String getName() {
            return "QuickSort, First Index Pivot";
        }

        @Override
        public void sort(int[] arr) {
            quicksort(arr);
        }

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

        //precondition: arr is not null, original range had at least 3 items, in acceptable index range for arr
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
                    sort(arr, selectPivot(arr, first, pivotIndex - 1), first, pivotIndex - 1);
                    sort(arr, selectPivot(arr, pivotIndex + 1, last), pivotIndex + 1, last);
                }
            }
        }

        //TODO: add: do not process first and last or pivot
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
