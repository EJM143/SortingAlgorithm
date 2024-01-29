package SortingAlgorithms;
import java.io.*;

public class SelectionSort implements SortingAlgoInterface {
    @Override
    public void sort(int arr[]) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < arr.length - 1; i++) {
            // Find the minimum element in unsorted array
            int smallest = i;
            //Iterate through unsorted part of the array to find smallest element
            for (int j = i + 1; j < arr.length; j++)
                if (arr[smallest] > arr[j]) {
                    //Update smallest index if a smaller element is found
                    smallest = j;
                }
                    // Swap the found minimum element with the first element

                int temp = arr[smallest];
                arr[smallest] = arr[i];
                arr[i] = temp;

        }
    }

    @Override
    public String getName() {
        return "Selection Sort";
    }
}