package com.Wilderness.controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.Wilderness.model.Station;
import com.Wilderness.controller.StationEditDialogController;
import com.Wilderness.controller.StationOverViewController;
import application.WildernessDBConfig;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("WeatherApp");

        initRootLayout();

        showStationOverView();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the Station overview inside the root layout.
     */
    public void showStationOverView() {
        try {
            // Load Station overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/StationOverView.fxml"));
            AnchorPane StationOverView = (AnchorPane) loader.load();

            // Set Station overview into the center of root layout.
            rootLayout.setCenter(StationOverView);
            
         // Give the controller access to the main app.
            StationOverViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    
    private ObservableList<Station> StationData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
        StationData.add(new Station("New York", "1"));
        StationData.add(new Station("Idaho", "2"));
        StationData.add(new Station("Mississippi", "3"));
        StationData.add(new Station("Tennessee", "4"));
        StationData.add(new Station("Washington", "5"));
        StationData.add(new Station("California", "6"));
        StationData.add(new Station("California", "7"));
        StationData.add(new Station("Texas", "8"));
        StationData.add(new Station("Alabama", "9"));
        StationData.add(new Station("Georgia", "10"));
    }

    /**
     * Returns the data as an observable list of Stations. 
     * @return
     */
    public ObservableList<Station> getStationData() {
        return StationData;
    }
    /**
     * Opens a dialog to edit details for the specified Station. If the user
     * clicks OK, the changes are saved into the provided Station object and true
     * is returned.
     * 
     * @param Station the Station object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showStationEditDialog(Station Station) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/com/Wilderness/view/StationEditDialog.fxml"));
            AnchorPane page = FXMLLoader.load(getClass().getResource("/com/Wilderness/view/StationEditDialog.fxml"));
            Parent stationEdit = page;

            // Create the dialog Stage.
            Stage dialogStage = getPrimaryStage();
            dialogStage.setTitle("Edit Station");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(stationEdit);
            dialogStage.setScene(scene);

            // Set the Station into the controller.
            StationEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setStation(Station);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}