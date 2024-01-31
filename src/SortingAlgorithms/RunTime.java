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

    public static void main(String[] args) {
//        for (Pair<Long, Integer> pair : myRT.getRandomArrayValues()) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
//        for (Pair<Long, Integer> pair : myRT.getHalfSortedArrayValues()) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
    }
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

    public List<Pair<Long, Integer>> getRandomArrayValues(){
        return randomArrayValues;
    }

    public List<Pair<Long, Integer>> getHalfSortedArrayValues() {
        return halfSortedArrayValues;
    }

    public List<Pair<Long, Integer>> getThreeQuarterSortedValues(){
        return threeQuarterSortedValues;
    }

    public List<Pair<Long, Integer>> getSortedArrayValues(){
        return sortedArrayValues;
    }

    public List<Pair<Long, Integer>> getReverseArrayValues() {
        return reverseArrayValues;
    }
}
