package SortingAlgorithms;

public class Quicksort_FirstPivot implements SortingAlgoInterface {
        private static int selectPivot(int[] arr, int first, int last) {
            return first;
        }
        //select 1: return first
        //select random: return random between first, last inclusive
        //select median of 3: if >= 3, do the thing, else sort and return 0

        @Override
        public String getName() {
            return "QuickSort, First Index Pivot";
        }

        @Override
        public void sort(int[] arr) {
            quicksort(arr);
        }

        public static void quicksort(int[] arr) {
            if (arr != null && arr.length > 1) {
                int last = arr.length - 1;
                sort(arr, selectPivot(arr, 0, last), 0, last);
            }
        }

        public static void sort_partial(int[] arr, int startIndex, int endIndex) {
            if (arr != null && arr.length > 1 &&
                    startIndex >= 0 && startIndex < arr.length && startIndex <= endIndex &&
                    endIndex < arr.length) {
                sort(arr, selectPivot(arr, startIndex, endIndex), startIndex, endIndex);
            }
        }

        public static void sort(int[] arr, int pivotIndex, int first, int last) {
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

