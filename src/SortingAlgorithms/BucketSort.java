package SortingAlgorithms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Class implementation to sort an array of integers using BucketSort
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
        int numOfBuckets = (int)Math.sqrt(size);

        List<Integer>[] buckets = new ArrayList[numOfBuckets];
        for (int i =0; i < numOfBuckets ; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < size; i++){
            int bucketIndex = Math.min((int)((double)array[i] / maxValue * numOfBuckets), numOfBuckets - 1);
            buckets[bucketIndex].add(array[i]);
        }

        //TODO: Ok to use Collections.sort or any other sort methods implemented?
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        int originalIndex = 0;
        for(List<Integer> bucket : buckets) {
            for(int element : bucket) {
                array[originalIndex] = element;
                originalIndex++;
            }
        }
    }

    /**
     * Method to return the name of the sorting algorithm
     * @return String name
     */
    @Override
    public String getName() {
        return "Bucket Sort";
    }
}

