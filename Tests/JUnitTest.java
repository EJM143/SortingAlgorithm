import SortingAlgorithms.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class JUnitTest {


    void testAnySort(SortingAlgoInterface obj) {

        // int[] list = makeList();

        int[][] arrays = new TestData.Arrays().getAllArrays();
        String[] arrayType = TestData.Arrays.getArrayOrderingStrategy();
        int index = 0;
        for (int j = 0; j < arrays.length; j++, index++) {
            System.out.println();
            System.out.println(" \t \t" + obj.getName() + " Array Size = "
                    + arrays[j].length +" Array Type: "+arrayType[index%arrayType.length] + " \t \t");
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
        }
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
//    @Test
//    void testQuicksort() {
//        Quicksort obj = new Quicksort();
//        testAnySort(obj);
//    }
}



