package SortingAlgorithms;

/**
 * Class implementation to sort an array of integers using ShellSort
 *
 * @author KRB
 * @version 1.1
 */
public class ShellSort implements SortingAlgoInterface {
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

        for (int distance = size/2; 0 < distance; distance = distance/2) {
            for (int i = distance; i < size; i++) {
                int helper = array[i];
                int j = -1;
                for (j = i; distance <= j && helper < array[j - distance]; j = j - distance) {
                    array[j] = array[j - distance];
                }
                array[j] = helper;
            }
        }
    }

    /**
     * Method to return the name of the sorting algorithm
     * @return String name
     */
    @Override
    public String getName() {
        return "ShellSort";
    }
}




