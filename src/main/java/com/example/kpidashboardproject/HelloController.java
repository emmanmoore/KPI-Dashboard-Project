package com.example.kpidashboardproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    ////////////////////////////////////////////////////
    ////////NOTES ON HOW TO SET UP GRAPHS
    ////////////////////////////////////////////////////
    //defining axes
    //uses NumberAxis class and subclass Axis to represent numerical values
    //from import statement
    //final NumberAxis xAxis = new NumberAxis();
    //final NumberAxis yAxis = new NumberAxis();
    //do we want label for axes to be on graph or in splitscene?
    //if on graph:
    //xAxis.setLabel("Number of Month");
    //^would be separate label

    //from what I'm gathering, all the code below will be duplicated
    //for each of the 5 charts
    //since the x/y axes variables can be the same, but will just need to be updated
    //with new data for each chart
    //THEREFORE
    //in best interest to make series names related to linechart fx:ids for easy tracking

    //creating chart:
    //final LineChart<Number, Number> ConversionRateChart = new LineChart<Number, Number>(xAxis, yAxis);
    //example code sets title for chart separately, but we already set these in scenebuilder

    //define series
    //must create series of data using XYChart.Series class to assign data to chart
    //XYChart.Series ConversionRateSeries = new XYChart.Series();
    //if we want to mark the data separately like in oracle doc,
    // we can use:
    //Series.setName("real estate");
    //otherwise, no need (it also may be confusing since it shows on x axis and x is months

    //populating series with data:
    //ex way: (long way)
    //series.getData().add(new XYChart.Data(1,23));
    //other way:

    //setting arrays - will be different for each graph (except for month)
    //int[] MonthNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    //double[] ConversionRate = {0.8, 0.9, 1.4, 0.8, 1.1, 0.7, 0.6, 0.3, 0.8, 0.6, 1.2, 0.9};

    //for(int num : MonthNum){
        //for(double rate : ConversionRate){
            //ConversionRateSeries.getData().add(new XYChart.Data<Number, Number>(num, rate));
            //the xychart.data goes (horizontal, vertical) so -> (month, y)
        //}
    //}
    //ConversionRateChart.getData().add(ConversionRateSeries);
//            series2.getData().add(new XYChart.Data<Number, Number>(val, val));
//        // add the series to the graph
//        graph2.getData().add(series2);

    ////////////////////////////////
    ////////INITIALIZE
    ///////////////////////////////
    public void initialize() {
        //fx:ids for JAVAFX file:
        //appointment-listing conversion rate: ALCRLineChart
        //average commission per sale: ACPSLineChart
        //average square foot: ASFLineChartY////REMOVED
        //average price per square foot: ASFPriceLineChart///// REMOVED
        //listings closed: LCLineChart
        //average time on market: ATMLineChart
        //percentage of homes sold from inventory: HomesSoldLineChart
        //toggle view button: ToggleViewButton
        //KPI in title "kpi dashboard": KPITitleText
        //dashboard in title "kpi dashboard": DashboardTitleText
        //12 month real estate analysis title: RealEstateTitleText
        //background rectangle for average commission per sale: ACPSRectangle

        //setting axes variables
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        //APPT LISTING CONVERSION RATE LINE CHART
        //creating chart: appt listing to conversion rate
        final LineChart<Number, Number> ALCRLineChart = new LineChart<Number, Number>(xAxis, yAxis);

        //define series: conversion rate
        XYChart.Series ALCRSeries = new XYChart.Series();

        //setting arrays
        int[] MonthNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        double[] ConversionRate = {0.8, 0.9, 1.4, 0.8, 1.1, 0.7, 0.6, 0.3, 0.8, 0.6, 1.2, 0.9};
        //iterating through arrays to make a series
        for(int num : MonthNum){
            for(double rate : ConversionRate){
                ALCRSeries.getData().add(new XYChart.Data<Number, Number>(num, rate));
                //xychart.data(horizontal, vertical)
            }
        }
        ALCRLineChart.getData().add(ConversionRateSeries);

        //AVERAGE COMMISSION PER SALE LINE CHART
        //creating chart
        final LineChart<Number, Number> ACPSLineChart = new LineChart<Number, Number>(xAxis, yAxis);

        //define series: conversion rate
        XYChart.Series ACPSSeries = new XYChart.Series();

        //setting arrays
        int[] MonthNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        int[] CommissionPerSale = {16703, 21086, 20506, 20204, 24003, 25690, 14380, 17840, 15469, 14897,
                20870, 21304};
        //iterating through arrays to make a series
        for(int num : MonthNum){
            for(int com : CommissionPerSale){
                ACPSSeries.getData().add(new XYChart.Data<Number, Number>(num, com));
                //xychart.data(horizontal, vertical)
            }
        }
        ACPSLineChart.getData().add(ACPSSeries);

        //LISTINGS CLOSED LINE CHART
        //creating chart
        final LineChart<Number, Number> LCLineChart = new LineChart<Number, Number>(xAxis, yAxis);

        //define series: conversion rate
        XYChart.Series LCSeries = new XYChart.Series();

        //setting arrays
        int[] MonthNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        int[] listingsClosed = {196, 76, 97, 128, 135, 112, 86, 93, 81, 73, 94, 108};
        //iterating through arrays to make a series
        for(int num : MonthNum){
            for(int listing : listingsClosed){
                LCSeries.getData().add(new XYChart.Data<Number, Number>(num, listing));
                //xychart.data(horizontal, vertical)
            }
        }
        LCLineChart.getData().add(LCSeries);

        //AVERAGE TIME ON MARKET CHART
        //creating chart
        final LineChart<Number, Number> ATMLineChart = new LineChart<Number, Number>(xAxis, yAxis);

        //define series: conversion rate
        XYChart.Series ATMSeries = new XYChart.Series();

        //setting arrays
        int[] MonthNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        int[] AverageListingTimeonMarket = {76, 77, 63, 78, 69, 81, 64, 77, 65, 78, 81, 83};
        //iterating through arrays to make a series
        for(int num : MonthNum){
            for(int time : AverageListingTimeonMarket){
                ATMSeries.getData().add(new XYChart.Data<Number, Number>(num, time));
                //xychart.data(horizontal, vertical)
            }
        }
        ATMLineChart.getData().add(ATMSeries);

        //HOMES SOLD LINE CHART
        //creating chart
        final LineChart<Number, Number> HomesSoldLineChart = new LineChart<Number, Number>(xAxis, yAxis);

        //define series: conversion rate
        XYChart.Series HomesSoldSeries = new XYChart.Series();

        //setting arrays
        int[] MonthNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        int[] SoldHomesPerInventory = {37, 24,27, 33, 34, 29, 21, 26, 31, 34, 28, 33};
        //iterating through arrays to make a series
        for(int num : MonthNum){
            for(int sold : SoldHomesPerInventory){
                HomesSoldSeries.getData().add(new XYChart.Data<Number, Number>(num, sold));
                //xychart.data(horizontal, vertical)
            }
        }
        ATMLineChart.getData().add(HomesSoldSeries);
    }
    ///////////////////////
    ////end initialize
    ///////////////////////
}
//////////////////////////////////////////////////
///////////////////////////////////////////////
//END OF CONTROLLER CLASS
/////////////////////////////////////////////
//
