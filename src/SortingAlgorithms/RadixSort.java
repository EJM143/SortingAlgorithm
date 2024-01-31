package SortingAlgorithms;
import java.util.Arrays;

public class RadixSort implements SortingAlgoInterface{
    /**
     * A function to get the maximum value in the array
     * @param array   input array
     * @param n       size of the array
     * @return        maximum value in the array
     */
    static int getMax(int array[], int n) {
        int mx = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > mx)
                mx = array[i];
        }
        return mx;
    }
    /**
     * A function to perform counting sort of the array
     * base to the digit with the exp
     * @param array       input array
     * @param n         size of the array
     * @param expo       current digit position
     */
    static void cSort(int[]array, int n, int expo) {
        int[]output = new int[n];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++) {
            count[(array[i] / expo) % 10]++;
        }
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (i = n - 1; i >= 0; i--) {
            output[count[(array[i] / expo) % 10] - 1] = array[i];
            count[(array[i] / expo) % 10]--;
        }
        for (i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    /**
     * The main sorting function that sorts the array
     * using Radix Sort
     * @param array     array to be sorted
     */
    @Override
    public void sort(int array[]) {
        int n = array.length;
        int m = getMax(array, n);
        for (int exp = 1; m / exp > 0; exp *= 10) {
            cSort(array, n, exp);
        }
    }

    /**
     * Gets the name of the sorting algorithm
     * @return      name of the sorting algorithm
     */

    @Override

    public String getName() {
        return "Radix Sort";
    }
}


