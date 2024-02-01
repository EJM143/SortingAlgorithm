package SortingAlgorithms;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

    public static void main(String[]args) {
        RadixSort obj = new RadixSort();
        testAnySort(obj);

        MergeSort obj1 = new MergeSort();
        testAnySort(obj1);

        InsertionSort obj3 = new InsertionSort();
        testAnySort(obj3);

        SelectionSort obj4 = new SelectionSort();
        testAnySort(obj4);

        HeapSort obj5 = new HeapSort();
        testAnySort(obj5);

       // Quicksort obj6 = new Quicksort();
       // testAnySort(obj6);

        BubbleSort obj7 = new BubbleSort();
        testAnySort(obj7);

        CountSort obj8 = new CountSort();
        testAnySort(obj8);

        ShellSort obj9 = new ShellSort();
        testAnySort(obj9);

       // BucketSort obj2 = new BucketSort();
       // testAnySort(obj2);


    }
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
            long start = System.nanoTime();
            obj.sort(arrays[j]);
            long end = System.nanoTime();
            // Checking if sorting really worked
            for (int i = 1; i < arrays[j].length; i++) {
                if (!(arrays[j][i - 1] <= arrays[j][i])) {
                    System.out.println(i + ":" + arrays[j][i] + "," + (i - 1) + ":" + arrays[j][i - 1]);
                    assertTrue(false);
                }

            }
            System.out.println("Sorting took: " + (end-start)/1000 + " microseconds");
            System.out.println("======================================================================");

            int caseNumber = j % 5;


            switch (caseNumber) {
                case 0 -> randomArrayTimes[j/5] = (end-start)*1000;
                case 1 -> halfSortedArrayTimes[j/5] = (end-start)*1000;
                case 2 -> threeQuarterArrayTimes[j/5] = (end-start)*1000;
                case 3 -> sortedArrayTimes[j/5] = (end-start)*1000;
                case 4 -> reverseSortedArrayTimes[j/5] = (end-start)*1000;

            }

        }
        // Create Chart
        XYChart chart = QuickChart.getChart(obj.getName() + "Array Type: Random", "X", "Y", "y(x)", arrayLengths, randomArrayTimes);

        // Show 50% Sorted Array
        new SwingWrapper(chart).displayChart();

        chart = QuickChart.getChart(obj.getName() + "Array Type: 50% Sorted", "X", "Y", "y(x)", arrayLengths, halfSortedArrayTimes);


        // Show 75% Sorted Array
        new SwingWrapper(chart).displayChart();

        chart = QuickChart.getChart(obj.getName() + "Array Type: 75% Sorted", "X", "Y", "y(x)", arrayLengths, threeQuarterArrayTimes);

        // Show Sorted Array
        new SwingWrapper(chart).displayChart();

        chart = QuickChart.getChart(obj.getName() + "Array Type: Sorted Array", "X", "Y", "y(x)", arrayLengths, sortedArrayTimes);

        // Show Reversed Sorted Array
        new SwingWrapper(chart).displayChart();

        chart = QuickChart.getChart(obj.getName() + "Array Type: Reversed Sorted Array", "X", "Y", "y(x)", arrayLengths, reverseSortedArrayTimes);

        // Show chart
        new SwingWrapper(chart).displayChart();

    }

}
