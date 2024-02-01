import SortingAlgorithms.*;
import org.junit.jupiter.api.Test;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.List;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class JUnitTest {


    public static void testAnySort(SortingAlgoInterface obj) {

        // int[] list = makeList();



        int[][] arrays = new TestData.Arrays().getAllArrays();
        String[] arrayType = TestData.Arrays.getArrayOrderingStrategy();
        double [] arrayLengths = new double[arrays.length/5];
        for (int i = 0; i < arrayLengths.length; i++) {
            arrayLengths[i] = arrays[i*5].length;
        }

        double [] randomArrayTimes = new double[arrays.length/5];
        double [] halfSortedArrayTimes = new double[arrays.length/5];
        double [] threeQuarterArrayTimes = new double[arrays.length/5];
        double [] sortedArrayTimes = new double[arrays.length/5];
        double [] reverseSortedArrayTimes = new double[arrays.length/5];

        for (int j = 0; j < arrays.length; j++) {
            System.out.println();
            System.out.println(" \t \t" + obj.getName() + " Array Size = "
                    + arrays[j].length +" Array Type: "+ arrayType[j%arrayType.length] + " \t \t");
            System.out.println("----------------------------------------------------------------------");
            //Prints the first 10 of unsorted list to console
            for (int i = 0; i < 10 && i < arrays[j].length; i++) {
                System.out.print(arrays[j][i] + " ");
            }
            System.out.println();
            long start = System.currentTimeMillis();
            obj.sort(arrays[j]);

//            System.out.println("[");
//            for (int k = 0; k < 4; k++) {
//                System.out.println(arrays[j][k]);
//            }
//            System.out.println("...]");


            long end = System.currentTimeMillis();
            // Checking if sorting really worked
            for (int i = 1; i < arrays[j].length; i++) {
                if (!(arrays[j][i - 1] <= arrays[j][i])) {
                    System.out.println(i + ":" + arrays[j][i] + "," + (i - 1) + ":" + arrays[j][i - 1]);
                    assertTrue(false);
                }

            }
            System.out.println("Sorting took: " + (end-start) + " milliseconds");
            System.out.println("======================================================================");

            int caseNumber = j % 5;


                switch (caseNumber) {
                    case 0 -> randomArrayTimes[j/5] = end-start;
                    case 1 -> halfSortedArrayTimes[j/5] = end-start;
                    case 2 -> threeQuarterArrayTimes[j/5] = end-start;
                    case 3 -> sortedArrayTimes[j/5] = end-start;
                    case 4 -> reverseSortedArrayTimes[j/5] = end-start;

                }

        }
        // Create Chart
        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", arrayLengths, randomArrayTimes);

        // Show it
        new SwingWrapper(chart).displayChart();

    }

    @Test
    void testBubbleSort() {
        BubbleSort obj = new BubbleSort();
        testAnySort(obj);
    }
    @Test
    void testBucketSort() {
       BucketSort obj = new BucketSort();
        testAnySort(obj);
     }

    @Test
    void testCountSort() {
        CountSort obj = new CountSort();
        testAnySort(obj);
    }

    @Test
    void testInsertionSort() {
        InsertionSort obj = new InsertionSort();
        testAnySort(obj);
    }

    @Test
    void testMergeSort() {
        MergeSort obj = new MergeSort();
        testAnySort(obj);
    }

    @Test
    void testRadixSort() {
        RadixSort obj = new RadixSort();
        testAnySort(obj);
    }

    @Test
    void testShellSort() {
        ShellSort obj = new ShellSort();
        testAnySort(obj);
    }

    @Test
    void testHeapSort() {
        HeapSort obj = new HeapSort();
        testAnySort(obj);
    }

    @Test
    void testSelectionSort() {
        SelectionSort obj = new SelectionSort();
        testAnySort(obj);
    }
   /* @Test
   void testQuicksort() {
        Quicksort obj = new Quicksort();
        testAnySort(obj);
    }

    */
}



