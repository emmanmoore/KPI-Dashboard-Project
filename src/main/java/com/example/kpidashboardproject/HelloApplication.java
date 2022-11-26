package com.example.kpidashboardproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root =
                FXMLLoader.load(getClass().getResource("KPIDashboard.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("KPIDashboard.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1327, 741);

        Scene scene = new Scene(root); // Attach Scene graph to the new Scene whose root node is specified above
        stage.setScene(scene); // Attach the scene to the Stage (Application Window)
        stage.setTitle("KPI Dashboard Application!"); // Set the Title to be displayed in the Window's title bar
        stage.show(); // Display the 
    }

    public static void main(String[] args) {
        launch(args);
    }
}
