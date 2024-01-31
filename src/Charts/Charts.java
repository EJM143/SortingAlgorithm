package Charts;

import SortingAlgorithms.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Charts extends Application {
    private static RunTime bubbleRT = new RunTime(new BubbleSort());
    private static RunTime bucketRT = new RunTime(new BucketSort());
    private static RunTime countRT = new RunTime(new CountSort());
    private static RunTime heapRT = new RunTime(new HeapSort());
    private static RunTime insertionRT = new RunTime(new InsertionSort());
    private static RunTime mergeRT = new RunTime(new MergeSort());
    private static RunTime quickRT = new RunTime(new Quicksort());
    private static RunTime quick1stRT = new RunTime(new Quicksort_FirstPivot());
    private static RunTime quickMedianOf3RT = new RunTime(new Quicksort_MedianOf3());
    private static RunTime quickRandomRT = new RunTime(new Quicksort_RandomPivot());
    private static RunTime radixRT = new RunTime(new RadixSort());
    private static RunTime selectionRT = new RunTime(new SelectionSort());
    private static RunTime shellRT = new RunTime(new ShellSort());

    public static void main(String[] args) {
        bubbleRT.allLists();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("Hello JavaFX");
    }
}
