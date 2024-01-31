import SortingAlgorithms.*;
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

    public RunTime() {
        randomArrayValues = new ArrayList<>();
        halfSortedArrayValues = new ArrayList<>();
        threeQuarterSortedValues = new ArrayList<>();
        sortedArrayValues = new ArrayList<>();
        reverseArrayValues  = new ArrayList<>();
        arrays = new TestData.Arrays().getAllArrays();
    }

    public static void runAlgo(SortingAlgoInterface sortMethod) {
        for(int index = 0; index < arrays.length; index++) {
            int arraySize = arrays[index].length;
            long start = System.currentTimeMillis();
            sortMethod.sort(arrays[index]);
            long end = System.currentTimeMillis();
            long timeTaken = end - start;
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
}
