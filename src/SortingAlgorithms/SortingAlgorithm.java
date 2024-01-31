package SortingAlgorithms;

import java.util.Arrays;

public class SortingAlgorithm {

    public static void main(String[] args) {
        // Selection Sort
        int[] selectionSortArray = {4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768};
        SortingAlgorithms.SelectionSort selectionSortObj = new SortingAlgorithms.SelectionSort();

        System.out.println("Original array:");
        printArray(selectionSortArray);

        // Make a copy of the original array
//        Arrays Arr;
        int[] unsortedArray = java.util.Arrays.copyOf(selectionSortArray, selectionSortArray.length);
        selectionSortObj.sort(selectionSortArray);
        System.out.println("Selection Sort: Sorted array");
        printArray(selectionSortArray);

        System.out.println("Unsorted array (after sorting):");
        printArray(unsortedArray);

        // Counting Sort
        int[] countingSortArray = {4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768};
        int[] countingSortOutput = countSort(countingSortArray);
        System.out.println("Counting Sort: Sorted array");
        printArray(countingSortOutput);

        // Heap Sort
        int[] heapSortArray = {4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768};
        SortingAlgorithms.HeapSort heapSortObj = new SortingAlgorithms.HeapSort();
        heapSortObj.sort(heapSortArray);
        System.out.println("Heap Sort: Sorted array");
        printArray(heapSortArray);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static int[] countSort(int[] array) {
        // Your counting sort implementation here
        // Make sure to return the sorted array
        return array;
    }

    // SelectionSort and HeapSort classes and methods go here*/


