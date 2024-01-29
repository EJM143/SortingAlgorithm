import java.util.ArrayList;
import java.util.List;

/**
 * Class implementation to sort an array of integers using BucketSort
 *
 * @author KRB
 * @version 1.3
 */
public class BucketSort implements SortingAlgoInterface{
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
        return "BucketSort";
    }
}
