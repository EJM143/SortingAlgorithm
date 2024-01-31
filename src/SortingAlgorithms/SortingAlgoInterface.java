package SortingAlgorithms;

/** Interface that all sorting algorithms should implement for group operations */
public interface SortingAlgoInterface {
    /**
     * Sorts the given array in non-decreasing (increasing or equal) order
     * @param array the array of integers to sort
     */
    public void sort(int[] array);

    /**
     * Returns the name of the sorting algorithm
     * @return name of the sorting algorithm
     */
    public String getName();
}
