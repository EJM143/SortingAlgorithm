package SortingAlgorithms;

public class InsertionSort implements SortingAlgoInterface {
    /**
     * Sorts the array using the insertion sort algorithm
     * @param array     array to be sorted
     */
    public void sort(int[]array) {
        int current;
        int j;
        for(int i = 1; i < array.length; i++) {
            current = array[i];
            for(j = i; j > 0 && current < array[j-1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = current;
        }
    }
    */
    /**
     * Gets the name of the sorting algorithm
     * @return      name of the sorting algorithm
     */
    /*@Override
    public String getName() {
        return "InsertSort";
    }
}


