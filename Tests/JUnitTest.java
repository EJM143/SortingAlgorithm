import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnitTest {
    public static boolean contains(int[] data, int target) {
        for (int datum : data) {
            if (datum == target) {
                return true;
            }
        }
        return false;
    }
    static int[] makeList() {
        Random random = new Random();
        int bound = 1000;                //upper bound of values
        int[] list = new int[bound / 2];
        int num;
        for (int i = 0; i < list.length; i++) {
            num = random.nextInt(bound);
            if (!(contains(list, num))) {
                list[i] = num;
            } else {
                i--;
            }
        }
        return list;
    }
    @Test
    void testAnySort(SortingAlgoInterface obj) {

        int[] list = makeList();

        System.out.println();
        System.out.println(" \t \t" + obj.getName() + " \t \t");
        System.out.println("==============================================");
        //Prints the first 10 of unsorted list to console
        for (int i = 0; i < 10; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
        obj.sort(list);
        for (int i = 1; i < list.length; i++) {
            assertTrue(list[i - 1] < list[i]);
        }
        // Prints the first 15 values to console
        for (int i = 0; i < 15; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
        System.out.println("==============================================");
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
}
