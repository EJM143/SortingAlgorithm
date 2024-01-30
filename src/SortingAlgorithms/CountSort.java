package SortingAlgorithms;
import java.util.Arrays;

public class CountSort implements SortingAlgoInterface {
    @Override
    public void sort(int[] inputArray) {
        //size of the input array
        int N = inputArray.length;
        //Maximum value in the input array
        int M = 0;

        for (int i = 0; i < N; i++) {
            M = Math.max(M, inputArray[i]);
        }

        //array to store the count of each element in the input array
        int[] countArray = new int[M + 1];

        //Count occurrences of each element in the input array
        for (int i = 0; i < N; i++) {
            countArray[inputArray[i]]++;
        }

        //Modify countArray to store the cumulative count of elements
        for (int i = 1; i <= M; i++) {
            countArray[i] += countArray[i - 1];
        }

        //create output array
        int[] outputArray = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]]--;
        }
        for (int i = 0; i < N; i++) {
            inputArray[i] = outputArray[i];
        }
        return ;

    }

    @Override
    public String getName() {
        return "CountSort";
    }
}
