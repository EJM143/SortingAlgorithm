package SortingAlgorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Class implementation to sort an array of integers using SortingAlgorithms.BucketSort
 *
 * @author KRB
 * @version 1.3
 */
public class BucketSort implements SortingAlgoInterface {
    /**
     * Method to sort a given array of integers
     * @param array Desired array of integers to sort
     */
    @Override
    public void sort(int[] array) {
        if (array.length == 0) {
            System.out.println("No elements in the array to sort!");
            return;
        }

        int size = array.length;
        int maxValue = 40000;

        //TODO: Too many buckets thus inefficient???
        List<Integer>[] buckets = new ArrayList[maxValue + 1];
        for (int i =0; i < maxValue + 1 ; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < size; i++){
            int value = array[i];
            buckets[value].add(value);
        }

        for (List<Integer> bucket : buckets) {
            //TODO: Okay to use another algo to sort the bucket????
        }
    }

    /**
     * Method to return the name of the sorting algorithm
     * @return String name
     */
    @Override
    public String getName() {
        return "SortingAlgorithms.BucketSort";
    }

    /**
     * SortingAlgorithms.BucketSort.Quicksort algorithms with various pivot options
     */
    public static class Quicksort implements SortingAlgoInterface {
        //select pivot (1 of 3 options)
        //partition
        //sort

        /**
         *
         * @param arr
         */
        @Override
        public void sort(int[] arr) {
            if (arr != null && arr.length > 1) {
                sort_firstPivot(arr, 0, 0, arr.length - 1);
            }
        }

        private static void sort_firstPivot(int[] arr, int pivotIndex, int first, int last) {
            //base case: first >= last (one or zero items can't be split)
            //recursive case: put pivot in place and call recursively
            //if two items only, sort and exit
            if (last - first == 1) {
                if (arr[last] < arr[first]) {
                    swap(arr, first, last);
                }
                return;
            }
            //if more than 2 items, do the thing
            if (first < last) {
                pivotIndex = partition(arr, pivotIndex, 0, arr.length - 1);
                sort_firstPivot(arr, first, first, pivotIndex -1);
                sort_firstPivot(arr, pivotIndex + 1, pivotIndex + 1, last);
            }
        }


        private static int partition(int[] arr, int pivotIndex, int first, int last) {
    //        //swap pivot with last
    //        int pivot = arr[pivotIndex];
    //        arr[pivotIndex] = arr[last];
    //        arr[last] = pivot;
    //        //go from left and right, swap as needed
    //        int left = first;
    //        int right = last - 1;
    //        while (left < right) {
    //            if (arr[left] > pivot && arr[right] < pivot) {
    //                int leftVal = arr[left];
    //                arr[left] = arr[right];
    //                arr[right] = leftVal;
    //            }
    //            if (arr[left] <= pivot) left++;
    //            if (arr[right] >= pivot) right--;
    //        }
    //        //place pivot at left( right + 1)
    //        arr[last] = arr[left];
    //        arr[left] = pivot;
    //        //return new pivot index
    //        return last;
            swap(arr, pivotIndex, last);
            int leftIndex = first;
            int rightIndex = last - 1;
            while (leftIndex < rightIndex) {
                while (leftIndex < last && arr[leftIndex] <= arr[last]) {
                    leftIndex++;
                }
                while (rightIndex > leftIndex && arr[rightIndex] > arr[last]) {
                    rightIndex--;
                }
                if (leftIndex < rightIndex) {
                    swap(arr, leftIndex, rightIndex);
                    leftIndex++;
                    rightIndex--;
                }
            }
            swap(arr, last, leftIndex);
            return leftIndex;
        }
        public void sort_randomPivot(int[] arr) {}
        public void sort_medianOf3Pivot(int[] arr) {}
        public static void swap(int[] arr, int index1, int index2) {
            int item1 = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = item1;
        }

     {

        }

        @Override
        public String getName() {
            return "Quick Sort";
        }
    }
}
