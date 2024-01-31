package TestData;

import SortingAlgorithms.*;
import java.util.Random;

/** Represents a class that produces arrays of integers to test sorting algorithms on */
public class Arrays {
    /** Maximum length of int arrays to test sorting algorithms on */
    public final static int MAX_SIZE = 32768;
    /** Minimum length of arrays to test sorting algorithms on */
    public final static int MIN_SIZE = 4;
    /** Upper bound on integers to include in the arrays (not included) */
    public final static int MAX_INT = 40001;
    /** Lower bound on integers to include in the arrays (included) */
    public final static int MIN_INT = 0;
    /** Amount to increase the length of the arrays by between sizes */
    private final static int SIZE_FACTOR = 2;
    /** Number of arrays to create total */
    private final static int NUM_ARRAYS = 70;
    /** array to hold all the int arrays in */
    private final int[][] arrays;

    //user must use constructor to make arrays exist: Arrays x = new Arrays(); x.getAllArrays();
    //Produce arrays of test data
    //14 lengths (powers of 2)
    //5 sorts: random, 50%, 75%, ordered, reverse ordered
    /** Constructs an Arrays object which creates all the arrays, fills with ints, and sorts according to scheme */
    public Arrays() {
        arrays = new int[NUM_ARRAYS][];
        int index = 0;
        Random random = new Random();
        for (int length = MIN_SIZE; length <= MAX_SIZE; length *= SIZE_FACTOR) {
            arrays[index] = random.ints(length, MIN_INT, MAX_INT).toArray(); //random
            //50%
            arrays[index + 1] = arrays[index].clone();
            Quicksort_MedianOf3.sort_partial(arrays[index + 1], 0, (arrays[index + 1].length - 1) / 2);
            //sort 75%
            arrays[index + 2] = arrays[index + 1].clone();
            Quicksort_MedianOf3.sort_partial(arrays[index + 2], 0, (arrays[index + 1].length) / 4 * 3 - 1);
            //sort 100%
            arrays[index + 3] = arrays[index + 2].clone();
            Quicksort_MedianOf3.quicksort(arrays[index + 3]);
            //reverse ordered array
            arrays[index + 4] = new int[length];
            for (int in = 0; in < length; in++) {
                arrays[index + 4][in] = arrays[index + 3][length - 1 - in];
            }

            //next batch of 5 arrays
            index += 5;
        }
    }

    /**
     * Converts requested length of array to position of array to access
     * @param length how long the array should be (validated already)
     * @return position of the unsorted array of the given length
    */
    public static int lengthToIndex(int length) {
        int goToLength = 0;
        for (int count = 4; count < length; count *= 2) {
            goToLength += 5;
        }
        return goToLength;
    }

    /**
     * Converts requested length to existing array size in range
     * @param entry entered length to be converted
     * @return length of array at least as large as entry but no more than MAX_SIZE
     */
    public static int entryToLength(int entry) {
        int boundary = 4;
        if (entry <= MAX_SIZE) {
            while (entry > boundary) {
                boundary *= 2;
            }
            entry = boundary;
        } else {
            entry = MAX_SIZE;
        }
        return entry;
    }

    /**
     * Returns an array of all 70 arrays, in this order:
     * smallest (unsorted 50% 75% sorted reverse) to largest (unsorted 50% 75% sorted reverse)
     * @return an array of all 70 arrays
     */
     public int[][] getAllArrays() {
        return arrays.clone();
    }


    /**
     * Returns an array of descriptions of order scheme for iteration display
     * @return array of descriptions of ordering strategy
     */
    public static String[] getArrayOrderingStrategy(){
        return new String[] {
            "Random numbers",
            "Sorted 50%",
            "Sorted 75%",
            "Sorted 100%",
            "Reverse Sorted",
        };
    }

    /**
     * Returns a randomly ordered array of given length rounded up to next available size
     * @param length desired length, if not available, rounds up to next available size
     * @return a copy of the randomly ordered array of given length or rounded up
     */
    public int[] getRandomOrdered(int length) {
        return arrays[lengthToIndex(entryToLength(length))].clone();
    }

    /**
     * Returns a 50% sorted array of given length rounded up to next available size
     * @param length desired length, if not available, rounds up to next available size
     * @return a copy of the half sorted array of given length or rounded up
     */
    public int[] getHalfSorted(int length) {
        return arrays[lengthToIndex(entryToLength(length)) + 1].clone();

    }

    /**
     * Returns a 75% sorted array of given length rounded up to next available size
     * @param length desired length, if not available, rounds up to next available size
     * @return a copy of the 75% sorted array of given length or rounded up
     */
    public int[] getThreeQuartersSorted(int length) {
        return arrays[lengthToIndex(entryToLength(length)) + 2].clone();
    }

    /**
     * Returns a sorted array of given length rounded up to next available size
     * @param length desired length, if not available, rounds up to next available size
     * @return a copy of the sorted array of given length or rounded up
     */
    public int[] getSorted(int length) {
        return arrays[lengthToIndex(entryToLength(length)) + 3].clone();
    }

    /**
     * Returns a reverse sorted array of given length rounded up to next available size
     * @param length desired length, if not available, rounds up to next available size
     * @return a copy of the reverse sorted array of given length or rounded up
     */
    public int[] getReverseSorted(int length) {
        return arrays[lengthToIndex(entryToLength(length)) + 4].clone();
    }

}
