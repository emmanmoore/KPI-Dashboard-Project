package com.example.kpidashboardproject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

import javafx.fxml.FXML;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class HelloController {
    /*
        FXML defined Variable Declarations
     */
    @FXML
    private LineChart<?, ?> ACPSLineChart;

    @FXML
    private NumberAxis ACPSLineChartX;

    @FXML
    private NumberAxis ACPSLineChartY;

    @FXML
    private Rectangle ACPSRectangle;

    @FXML
    private LineChart<?, ?> ALCRLineChart;

    @FXML
    private NumberAxis ALCRLineChartX;

    @FXML
    private NumberAxis ALCRLineChartY;

    @FXML
    private Rectangle ALCRRectangle;

    @FXML
    private Rectangle ASFRectangle;

    @FXML
    private LineChart<?, ?> ATMLineChart;

    @FXML
    private NumberAxis ATMLineChartX;

    @FXML
    private NumberAxis ATMLineChartY;

    @FXML
    private Rectangle ATMRectangle;

    @FXML
    private Rectangle BackgroundGray;

    @FXML
    private BorderPane BorderPane;

    @FXML
    private Pane CenterPane;

    @FXML
    private Text DashboardTitleText;

    @FXML
    private LineChart<?, ?> HomesSoldLineChart;

    @FXML
    private NumberAxis HomesSoldLineChartX;

    @FXML
    private NumberAxis HomesSoldLineChartY;

    @FXML
    private Rectangle HomesSoldRectangle;

    @FXML
    private Rectangle HomesSoldRectangle1;

    @FXML
    private Rectangle KPIDashTeal;

    @FXML
    private Text KPITitleText;

    @FXML
    private LineChart<?, ?> LCLineChart;

    @FXML
    private NumberAxis LCLineChartX;

    @FXML
    private NumberAxis LCLineChartY;

    @FXML
    private Rectangle LCRectangle;

    @FXML
    private Rectangle RealEstateTeal;

    @FXML
    private Text RealEstateTitleText;

    @FXML
    private SplitPane TopSplitPane;

    @FXML
    private AnchorPane TopSplitPaneLeftAnchor;

    @FXML
    private AnchorPane TopSplitPaneRightAnchor;

    /*
        Defining the x and y axes
     */
    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();

    /*
        Setting the labels for the axes
     */

//    LineChart<Number,Number lineChart = new LineChart<Number,Number>(xAxis,yAxis);
//
//    XYChart.Series series = new XYChart.Series();
//    series.setName("data");
//    for(int i = 0; i<xArray.length; i++) {
//        series.getData().add(new XYChart.Data(xArray[i], yArray[i]);
//    }
//    lineChart.getData().add(series);


    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();

    private BigDecimal Percentage = new BigDecimal(0.e15);

    int[] MonthNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    //will correlate with numberaxis for each graph to show data over course of 12 months

    double[] ConversionRate = {0.8, 0.9, 1.4, 0.8, 1.1, 0.7, 0.6, 0.3, 0.8, 0.6, 1.2, 0.9};

    int[] CommissionPerSale = {16703, 21086, 20506, 20204, 24003, 25690, 14380, 17840, 15469, 14897,
    20870, 21304};

    int[] SoldHomesPerInventory = {37, 24,27, 33, 34, 29, 21, 26, 31, 34, 28, 33};

    int[] listingsClosed = {196, 76, 97, 128, 135, 112, 86, 93, 81, 73, 94, 108};




    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}



//comments
//import java.util.ArrayList;
//        import java.util.Calendar;
//        import java.util.Collection;
//
//        import javafx.application.Application;
//        import javafx.collections.FXCollections;
//        import javafx.collections.ObservableList;
//        import javafx.scene.Scene;
//        import javafx.scene.chart.LineChart;
//        import javafx.scene.chart.NumberAxis;
//        import javafx.scene.chart.XYChart;
//        import javafx.stage.Stage;
//
//public class GraphingImplementation  extends Application
//{
//    @Override
//    public void start(Stage stage)
//    {
//        // close the initial stage.
//        stage.close();
//
//        // The size of the array
//        int seriesSize = 50000;
//
//        // Build the graphs
//        LineChart<Number, Number> graph1 = new LineChart<Number, Number>(new NumberAxis(), new NumberAxis());
//        LineChart<Number, Number> graph2 = new LineChart<Number, Number>(new NumberAxis(), new NumberAxis());
//
//        // Deactivate features that cause slow down
//        graph1.setCreateSymbols(false);
//        graph1.setAnimated(false);
//        graph2.setCreateSymbols(false);
//        graph2.setAnimated(false);
//
//        // Create value array to graph.
//        int value[] = new int[seriesSize];
//        for(int i = 0; i<seriesSize; i++)
//            value[i] = i;
//
//
//
//        //**********************************************************
//        // METHOD #1 - Creation of collection to populate series
//        //**********************************************************
//        // TIME COMPLEXITY - O{n}
//        //**********************************************************
//        // Mark the starting time of graphing method #1
//        long startTime = Calendar.getInstance().getTimeInMillis();
//        // Create the collection
//        Collection<XYChart.Data<Number, Number>> collection = new ArrayList<XYChart.Data<Number, Number>>();
//        // Add all values into the collection
//        for (int val : value)
//            collection.add(new XYChart.Data<Number, Number>(val,val));
//        // Create the data using the collection
//        ObservableList<XYChart.Data<Number, Number>> list = FXCollections.observableArrayList(collection);
//        // create a series from the list
//        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>(list);
//        // Add the series to the graph
//        graph1.getData().add(series);
//        // Mark the stopping time of graphing method #1
//        long stopTime = Calendar.getInstance().getTimeInMillis();
//        // Print the run time for method #1
//        System.out.println((stopTime - startTime) + " Milliseconds");
//
//
//
//        // build the first scene
//        Scene scene1 = new Scene(graph1, 640, 480);
//        // create and populate the first stage
//        Stage stage1 = new Stage();
//        stage1.setScene(scene1);
//        // show the first stage
//        stage1.show();
//
//
//
//
//        //**********************************************************
//        // METHOD #2 - Direct creation of a series
//        //**********************************************************
//        // TIME COMPLEXITY - O{n^2}
//        //**********************************************************
//        // Mark the starting time of graphing method #2
//        startTime = Calendar.getInstance().getTimeInMillis();
//        // Create the XYChart Series
//        XYChart.Series<Number, Number> series2 = new XYChart.Series<Number, Number>();
//        // add all values to the series
//        for (long val : value)
//            series2.getData().add(new XYChart.Data<Number, Number>(val, val));
//        // add the series to the graph
//        graph2.getData().add(series2);
//        // Mark the stopping time of graphing method #2
//        stopTime = Calendar.getInstance().getTimeInMillis();
//        // Print the run time for method #2
//        System.out.println((stopTime - startTime) + " Milliseconds");
//
//
//
//        // build the second scene
//        Scene scene2 = new Scene(graph2, 640, 480);
//        // create and populate the second stage
//        Stage stage2 = new Stage();
//        stage2.setScene(scene2);
//        // show the second stage
//        stage2.show();
//    }
//
//    public static void main(String[] args)
//    {
//        launch(args);
//    }
//
//}
