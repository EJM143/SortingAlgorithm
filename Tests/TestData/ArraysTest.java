package TestData;

import SortingAlgorithms.Quicksort;
import SortingAlgorithms.Quicksort_MedianOf3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysTest {
    @Test
    void getArrays() {
        Arrays a = new Arrays();
        int[][] arrs = a.getAllArrays();
        //first array and getRandomOrdered of length 4 should be the same data
        assertNotEquals(arrs[0], a.getRandomOrdered(4));
        //first array and getRandomOrdered of length 4 should be different addresses to prevent changes to both
        assertArrayEquals(arrs[0], a.getRandomOrdered(4));
        //index 4 should be the reverse order of index 0
        int[] b = arrs[3].clone();


        for (int i = 0; i < b.length / 2; i++) {
            Quicksort.swap(b, i, b.length - 1 - i);
        }
        System.out.println(java.util.Arrays.toString(b));
        System.out.println(java.util.Arrays.toString(arrs[4]));
        assertArrayEquals(b, arrs[4]);
//        System.out.println(java.util.Arrays.deepToString(arrs));
    }

    @Test
    void lengthToIndex() {
        assertEquals(Arrays.lengthToIndex(4), 0);
        assertEquals(Arrays.lengthToIndex(8), 5);
        assertEquals(Arrays.lengthToIndex(16), 10);
        assertEquals(Arrays.lengthToIndex(32), 15);
        assertEquals(Arrays.lengthToIndex(64), 20);
        assertEquals(Arrays.lengthToIndex(Arrays.MAX_SIZE), 65);
    }

    @Test
    public void entryToLength() {
        assertEquals(Arrays.entryToLength(-9), 4);
        assertEquals(Arrays.entryToLength(3), 4);
        assertEquals(Arrays.entryToLength(4), 4);
        assertEquals(Arrays.entryToLength(5), 8);
        assertEquals(Arrays.entryToLength(8), 8);
        assertEquals(Arrays.entryToLength(9), 16);
        assertEquals(Arrays.entryToLength(16), 16);
        assertEquals(Arrays.entryToLength(17), 32);
        assertEquals(Arrays.entryToLength(32), 32);
        assertEquals(Arrays.entryToLength(Arrays.MAX_SIZE - 19), Arrays.MAX_SIZE);
        assertEquals(Arrays.entryToLength(Arrays.MAX_SIZE), Arrays.MAX_SIZE);
        assertEquals(Arrays.entryToLength(Arrays.MAX_SIZE + 19), Arrays.MAX_SIZE);

        Arrays b = new Arrays();
        assertArrayEquals(b.getAllArrays(), b.getAllArrays());

        int[] test1 = b.getRandomOrdered(32000);
        int[] test2 = b.getRandomOrdered(32000);
        assertArrayEquals(test1, test2);

        Quicksort_MedianOf3.quicksort(test1);
//        assertArrayEquals(test2, test1);
        for (int num = 0; num <= 10; num++) {
            System.out.println(test2[num]);
            System.out.println(test1[num]);
        }

        System.out.println(java.util.Arrays.toString(b.getHalfSorted(16)));
        System.out.println(java.util.Arrays.toString(b.getThreeQuartersSorted(16)));
        System.out.println(java.util.Arrays.toString(b.getSorted(16)));
        System.out.println(java.util.Arrays.toString(b.getReverseSorted(16)));
    }
}

