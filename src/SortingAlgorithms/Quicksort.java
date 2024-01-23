
package SortingAlgorithms;
public class Quicksort {
    //select pivot (1 of 3 options)
    //partition
    //sort
    public static void sort_firstPivot(int[] arr) {
        if (arr != null && arr.length > 1) {
            sort_firstPivot(arr, 0, 0, arr.length - 1);
        }
    }

    private static void sort_firstPivot(int[] arr, int pivotIndex, int first, int last) {
        //base case: first >= last (one or zero items can't be split)
        //recursive case: put pivot in place and call recursively
        if (first < last) {
            pivotIndex = partition(arr, pivotIndex, 0, arr.length - 1);
            sort_firstPivot(arr, pivotIndex, first, pivotIndex -1);
            sort_firstPivot(arr, pivotIndex, pivotIndex + 1, last);
        }
    }


    private static int partition(int[] arr, int pivotIndex, int first, int last) {
//        //swap pivot with last
//        int pivot = arr[pivotIndex];
//        arr[pivotIndex] = arr[last];
//        arr[last] = pivot;
//        //go from left and right, swap as needed
//        int left = first;
//        int right = last - 1;
//        while (left < right) {
//            if (arr[left] > pivot && arr[right] < pivot) {
//                int leftVal = arr[left];
//                arr[left] = arr[right];
//                arr[right] = leftVal;
//            }
//            if (arr[left] <= pivot) left++;
//            if (arr[right] >= pivot) right--;
//        }
//        //place pivot at left( right + 1)
//        arr[last] = arr[left];
//        arr[left] = pivot;
//        //return new pivot index
//        return last;
        swap(arr, pivotIndex, last);
        int leftIndex = first;
        int rightIndex = last - 1;
        while (leftIndex < rightIndex) {
            while (leftIndex < last && arr[leftIndex] < arr[last]) {
                leftIndex++;
            }
            while (rightIndex > leftIndex && arr[rightIndex] > arr[last]) {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                swap(arr, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        swap(arr, last, leftIndex);
        return leftIndex;
    }
    public void sort_randomPivot(int[] arr) {}
    public void sort_medianOf3Pivot(int[] arr) {}
    public static void swap(int[] arr, int index1, int index2) {
        int item1 = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = item1;
    }
}

