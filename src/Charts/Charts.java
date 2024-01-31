package Charts;

import SortingAlgorithms.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.List;

/**
 * Class to draw out Line Graphs using the Run-Times of Sorting Methods
 *
 * @author KRB/CSB302
 * @version 1.2
 */
public class Charts extends Application {
    private static final RunTime bubbleRT = new RunTime(new BubbleSort());
    private static final RunTime bucketRT = new RunTime(new BucketSort());
    private static final RunTime countRT = new RunTime(new CountSort());
    private static final RunTime heapRT = new RunTime(new HeapSort());
    private static final RunTime insertionRT = new RunTime(new InsertionSort());
    private static final RunTime mergeRT = new RunTime(new MergeSort());
//    private static final RunTime quickRT = new RunTime(new Quicksort());
//    private static final RunTime quick1stRT = new RunTime(new Quicksort_FirstPivot());
//    private static final RunTime quickMedianOf3RT = new RunTime(new Quicksort_MedianOf3());
//    private static final RunTime quickRandomRT = new RunTime(new Quicksort_RandomPivot());
    private static final RunTime radixRT = new RunTime(new RadixSort());
    private static final RunTime selectionRT = new RunTime(new SelectionSort());
    private static final RunTime shellRT = new RunTime(new ShellSort());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        String[] arrayTypes = {"Random Array", "50% Sorted Array", "75% Sorted Array", "Sorted Array", "Reverse Sorted Array"};
        LineChart<Number, Number> c1 = createLineChart(bubbleRT.getRandomArrayValues(), arrayTypes[0]);
        LineChart<Number, Number> c2 = createLineChart(bubbleRT.getHalfSortedArrayValues(), arrayTypes[1]);
        LineChart<Number, Number> c3 = createLineChart(bubbleRT.getThreeQuarterSortedValues(), arrayTypes[2]);
        LineChart<Number, Number> c4 = createLineChart(bubbleRT.getSortedArrayValues(), arrayTypes[3]);
        LineChart<Number, Number> c5 = createLineChart(bubbleRT.getReverseArrayValues(), arrayTypes[4]);
        FlowPane root = new FlowPane();
        root.getChildren().addAll(c1, c2, c3, c4, c5);
        Scene scene  = new Scene(root,2000,800);

        stage.setTitle("Line Chart");
        stage.setScene(scene);
        stage.show();
    }

    private LineChart<Number, Number> createLineChart(List<Pair<Long, Integer>> list, String arrayType){
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Size of data input");
        yAxis.setLabel("Time taken");
        //creating the chart
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle(arrayType);
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Run-Time of Sorting");
        for(Pair<Long, Integer> pair : list){
            series.getData().add(new XYChart.Data(pair.getValue(), pair.getKey()));
        }
        lineChart.getData().add(series);
        return lineChart;
    }
}
