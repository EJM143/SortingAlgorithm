package src;

/**
 * Class implementation to sort an array of integers using BubbleSort
 *
 * @author KRB
 * @version 1.1
 */
public class BubbleSort implements SortingAlgoInterface{
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

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int helper = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = helper;
                }
            }
        }
    }

    /**
     * Method to return the name of the sorting algorithm
     * @return String name
     */
    @Override
    public String getName() {
        return "BubbleSort";
    }
}
