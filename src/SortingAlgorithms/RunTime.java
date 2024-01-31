package SortingAlgorithms;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to calculate the Run-Time of a sorting algorithm using different arrays
 *
 * @author KRB/CSB302
 * @version 1.0
 */
public class RunTime {
    private static int[][] arrays;
    private static List<Pair<Long, Integer>> randomArrayValues;
    private static List<Pair<Long, Integer>> halfSortedArrayValues;
    private static List<Pair<Long, Integer>> threeQuarterSortedValues;
    private static List<Pair<Long, Integer>> sortedArrayValues;
    private static List<Pair<Long, Integer>> reverseArrayValues;
    private SortingAlgoInterface sortMethod;

    /**
     * Constructor initializes various arraylists to hold data
     * @param sortMethod the sorting algorithm to use (must implement SortingAlgoInterface)
     */
    public RunTime(SortingAlgoInterface sortMethod) {
        randomArrayValues = new ArrayList<>();
        halfSortedArrayValues = new ArrayList<>();
        threeQuarterSortedValues = new ArrayList<>();
        sortedArrayValues = new ArrayList<>();
        reverseArrayValues  = new ArrayList<>();
        arrays = new TestData.Arrays().getAllArrays();
        this.sortMethod = sortMethod;
        this.runAlgo();
    }

    /**
     * Main program for this class
     * @param args command line arguments
     */
    public static void main(String[] args) {
//        for (Pair<Long, Integer> pair : myRT.getRandomArrayValues()) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
//        for (Pair<Long, Integer> pair : myRT.getHalfSortedArrayValues()) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
    }

    /**
     * Calculates runtime for all array sizes and types for this algorithm
     */
    public void runAlgo() {
        for(int index = 0; index < arrays.length; index++) {
            int arraySize = arrays[index].length;
            long start = System.nanoTime();
            sortMethod.sort(arrays[index]);
            long end = System.nanoTime();
            long timeTaken = (end - start) / 1000;
            int caseNumber = index % 5;

            try {
                switch (caseNumber) {
                    case 0 -> randomArrayValues.add(new Pair<>(timeTaken, arraySize));
                    case 1 -> halfSortedArrayValues.add(new Pair<>(timeTaken, arraySize));
                    case 2 -> threeQuarterSortedValues.add(new Pair<>(timeTaken, arraySize));
                    case 3 -> sortedArrayValues.add(new Pair<>(timeTaken, arraySize));
                    case 4 -> reverseArrayValues.add(new Pair<>(timeTaken, arraySize));
                    default -> throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * returns List of random array results
     * @return List of (Time, Size) results of random arrays
     */
    public List<Pair<Long, Integer>> getRandomArrayValues(){
        return randomArrayValues;
    }

    /**
     * returns List of half sorted array results
     * @return List of (Time, Size) results of half sorted arrays
     */
    public List<Pair<Long, Integer>> getHalfSortedArrayValues() {
        return halfSortedArrayValues;
    }

    /**
     * returns List of 75% sorted array results
     * @return List of (Time, Size) results of 75% sorted arrays
     */
    public List<Pair<Long, Integer>> getThreeQuarterSortedValues(){
        return threeQuarterSortedValues;
    }

    /**
     * returns List of 100% sorted array results
     * @return List of (Time, Size) results of 100% sorted arrays
     */
    public List<Pair<Long, Integer>> getSortedArrayValues(){
        return sortedArrayValues;
    }

    /**
     * returns List of reverse sorted array results
     * @return List of (Time, Size) results of reverse sorted arrays
     */
    public List<Pair<Long, Integer>> getReverseArrayValues() {
        return reverseArrayValues;
    }
}