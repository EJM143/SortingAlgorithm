package SortingAlgorithms;

public class MergeSort implements SortingAlgoInterface {
    /**
     * Merges two sorted arrays into a single sorted arrays
     * @param array     array to be merged
     * @param left      left sub-array
     * @param right     right sub-array
     */
    private static void merge(int[] array, int[] left, int[] right) {
        int index      = 0;
        int leftIndex  = 0;
        int rightIndex = 0;
        while(leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                array[index++] = left[leftIndex++];
            } else {
                array[index++] = right[rightIndex++];
            }
        }
        while(leftIndex < left.length){
            array[index++] = left[leftIndex++];
        }
        while(rightIndex < right.length){
            array[index++] = right[rightIndex++];
        }
    }
    /**
     * Retrieves the first half of the array
     * @param array     input array
     * @return          first half of the array
     */
    private  static int[] getFirstHalf(int [] array){
        int[] result = new int[array.length/2];
        for(int i = 0; i < result.length;i++) {
            result[i] = array[i];
        }
        return result;
    }
    /**
     * Retrieves the second half of the array
     * @param array     input array
     * @return          second half of the array
     */
    private  static int[] getSecondHalf(int [] array) {
        int[] result = new int[array.length/2 + array.length % 2];
        int start = array.length / 2;
        for(int i = 0; i < result.length;i++) {
            result[i] = array[i + start];
        }
        return result;
    }
    /**
     * Main sorting function that recursively sorts
     * the array using merge sort
     * @param array     array to be sorted
     */
    @Override
    public void sort(int[] array) {
        if (array.length > 1) {
            int[] left = getFirstHalf(array);
            int[] right = getSecondHalf(array);
            sort(left);
            sort(right);
            merge(array, left, right);
        }
    }
    /**
     * Get the name of the sorting algorithm
     * @return      name of the sorting algorithm
     */
    @Override
    public String getName() {
        return "MergeSort";
    }
}
