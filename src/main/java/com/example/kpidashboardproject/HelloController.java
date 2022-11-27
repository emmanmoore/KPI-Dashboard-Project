package com.example.kpidashboardproject;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class HelloController {

    /*
        Code block declaring all FXML variables corresponding to each FXML control component
        present in the view
     */

    @FXML
    private LineChart<Number, Number> ACPSLineChart;


    @FXML
    private LineChart<Number, Number> ALCRLineChart;

    @FXML
    private LineChart<Number, Number> ATMLineChart;

    @FXML
    private LineChart<Number, Number> HomesSoldLineChart;

    @FXML
    private LineChart<Number, Number> LCLineChart;

    // Integer Array containing the month numbers, corresponding to each month Jan-Dec, respectively.
    private final int[] MonthNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    /*
        Integer Array containing the monthly Average Commission per Sale, corresponding to each month,
        Jan-Dec respectively.
   */
    private final int[] CommissionPerSale = {16703, 21086, 20506, 20204, 24003, 25690, 14380, 17840, 15469, 14897,
                                       20870, 21304};

    /*
       Double Array Containing the Monthly Appointment to Listing conversion rates, corresponding to each month,
       Jan-Dec respectively.
    */
    private final double[] ConversionRate = {0.8, 0.9, 1.4, 0.8, 1.1, 0.7, 0.6, 0.3, 0.8, 0.6, 1.2, 0.9};

    /*
       Integer Array Containing the Percent of Homes Sold from Inventory, corresponding to each month,
       Jan-Dec respectively.
    */
    private final int [] SoldHomesPerInventory = {37, 24,27, 33, 34, 29, 21, 26, 31, 34, 28, 33};

    /*
       Integer Array Containing the Average Time on Market, corresponding to each month,
       Jan-Dec respectively.
    */
    private final int [] AverageListingTimeOnMarket = {76, 77, 63, 78, 69, 81, 64, 77, 65, 78, 81, 83};

    /*
       Integer Array Containing the Monthly Number of Listings Closed, corresponding to each month,
       Jan-Dec respectively.
    */
    private final int [] ListingsClosed = {196, 76, 97, 128, 135, 112, 86, 93, 81, 73, 94, 108};



    /*
        Default initialize method called when the FXML loader application is invoked in the
        application java class (driver code) which does the following:
            1. Create individual Series objects (XYChart.Series Class) for each LineChart present in the FXML.
            2. Populating each Series Objects with data points from their respective arrays.
            3. Add/Assign the Series to the Chart.
     */
    public void initialize(){
        // Declare and initialize an XYChartSeries object for the Average Commission Per Sale LineChart
        XYChart.Series<Number, Number> acpsSeries = new XYChart.Series<>();

        // Hide the legend for the specified Chart
        ACPSLineChart.setLegendVisible(false);

        /*
           Iterate through both the monthNumber array and commission per sale array to populate
           the individual data points of the series corresponding to the Average Commission Per Sale lineChart
         */
        for (int i = 0; i < MonthNum.length; i++){
            acpsSeries.getData().add(new XYChart.Data<>(MonthNum[i], CommissionPerSale[i]));
        }
        // Assign the Series to the Average Commission Rate Per Sale Line Chart
        ACPSLineChart.getData().add(acpsSeries);

        // Declare and initialize an XYChartSeries object for the Appointment to Listing Conversion Rate
        XYChart.Series<Number, Number> alcrSeries = new XYChart.Series<>();

        // Hide the legend for the specified Chart
        ALCRLineChart.setLegendVisible(false);

        /*
           Iterate through both the monthNumber array and Appointment to Listing Conversion rate array to populate
           the individual data points of the series corresponding to the Appointment to listing conversion
           rate lineChart
         */
        for (int i = 0; i < MonthNum.length; i++){
            alcrSeries.getData().add(new XYChart.Data<>(MonthNum[i], ConversionRate[i]));
        }
        // Assign the Series to the Appointment to Listing Conversion Rate Chart
        ALCRLineChart.getData().add(alcrSeries);


        // Declare and initialize an XYChartSeries object for the Percent of Homes Sold from inventory
        XYChart.Series<Number, Number> homesSoldSeries = new XYChart.Series<>();

        // Hide the legend for the specified Chart
        HomesSoldLineChart.setLegendVisible(false);

        /*
           Iterate through both the monthNumber array and Homes Sold Per Inventory array to populate
           the individual data points of the series corresponding to the Homes Sold LineChart
         */
        for (int i = 0; i < MonthNum.length; i++){
            homesSoldSeries.getData().add(new XYChart.Data<>(MonthNum[i], SoldHomesPerInventory[i]));
        }
        // Assign the Series to the Homes Sold Line Chart
        HomesSoldLineChart.getData().add(homesSoldSeries);

        // Declare and initialize an XYChartSeries object for the Average Time on Market
        XYChart.Series<Number, Number> avgTimeOnMarketSeries = new XYChart.Series<>();

        // Hide the legend for the specified Chart
        ATMLineChart.setLegendVisible(false);

        /*
           Iterate through both the monthNumber array and Average Time on Market Array to populate
           the individual data points of the series corresponding to the ATM LineChart
         */
        for (int i = 0; i < MonthNum.length; i++){
            avgTimeOnMarketSeries.getData().add(new XYChart.Data<>(MonthNum[i], AverageListingTimeOnMarket[i]));
        }
        // Assign the Series to the Average Time on Market Line Chart
        ATMLineChart.getData().add(avgTimeOnMarketSeries);

        // Declare and initialize an XYChartSeries object for the Monthly Number of Listings Closed
        XYChart.Series<Number, Number> listingsClosedSeries = new XYChart.Series<>();

        // Hide the legend for the specified Chart
        LCLineChart.setLegendVisible(false);

        /*
           Iterate through both the monthNumber array and Monthly Number of Listings Closed Array to populate
           the individual data points of the series corresponding to the Listings Closed Line Chart
         */
        for (int i = 0; i < MonthNum.length; i++){
            listingsClosedSeries.getData().add(new XYChart.Data<>(MonthNum[i], ListingsClosed[i]));
        }
        // Assign the Series to the Monthly listings Closed Line Chart
        LCLineChart.getData().add(listingsClosedSeries);
    }
}
