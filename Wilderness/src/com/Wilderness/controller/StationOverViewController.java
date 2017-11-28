package com.Wilderness.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import application.Main;
import application.WildernessDBConfig;

import com.Wilderness.model.Station;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;

import com.Wilderness.model.DateUtil;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StationOverViewController {
    @FXML
    private TableView<Station> StationTable;
    @FXML
    private TableColumn<Station, String> StationColumn;
    @FXML
    private TableColumn<Station, String> TempColumn;

    @FXML
    private Label StationLabel;
    @FXML
    private Label StationIDLabel;
    @FXML
    private Label TempLabel;
    @FXML
    private Label PrecipitationLabel;
    @FXML
    private Label Precipitation1Label;
    @FXML
    private Label PressureLabel;
    @FXML
    private Label selectedDateLabel;
    @FXML
    private Label WindSpeedLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public StationOverViewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the station table with the two columns.
        StationColumn.setCellValueFactory(cellData -> cellData.getValue().StationProperty());
        TempColumn.setCellValueFactory(cellData -> cellData.getValue().StationIDProperty());
        StationTable.setItems(getStationInfo());
     // Clear station details.
        showStationDetails(null);

        // Listen for selection changes and show the station details when changed.
        StationTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showStationDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        StationTable.setItems(mainApp.getStationData());
    }
    /**
     * Imports data from the station table in the database, populates the station list.
     * Called during initialization.
     * @return stationList
     */
    public ObservableList<Station> getStationList() {
    	ObservableList<Station> stationList = FXCollections.observableArrayList();
    	PreparedStatement insertStatement;
    	ResultSet rs;
    	try {
    	insertStatement = (PreparedStatement) WildernessDBConfig.getConnection().prepareStatement("select location, station_id from station");
    	rs = insertStatement.executeQuery();
    	while(rs.next()) {
    		stationList.add(new Station(rs.getString("location").toString(), rs.getString("station_id").toString()));
    	}

    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return stationList;
    	
    }
    public ObservableList<Station> getStationInfo(){
    	ObservableList<Station> stationInfo = getStationList();
    	PreparedStatement selectInfo;
    	ResultSet rs;
    	try {
    		selectInfo = (PreparedStatement) WildernessDBConfig.getConnection().prepareStatement("select wind_speed, air_temp, ground_temp, barometric_pressure, rainfall from station_detail where stationID = "+stationInfo.;
    		rs = selectInfo.executeQuery();
    		while(rs.next()) {
    			stationInfo.add(new Station(stationInfo.get(1).toString(),stationInfo.get(2).toString(),rs.getString("air_temp").toString(), rs.getString("ground_temp").toString(), rs.getString("barometric_pressure").toString(), rs.getString("rainfall").toString(), rs.getString("wind_speed").toString()));
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return stationInfo;
    }
    
    /**
     * Fills all text fields to show details about the station.
     * If the specified station is null, all text fields are cleared.
     * 
     * @param station the station or null
     */
    private void showStationDetails(Station station) {
        if (station != null) {
            // Fill the labels with info from the station object.
            StationLabel.setText(station.getStation());
            //StationIDLabel.setText(station.getStationID());
//            TempLabel.setText(station.getTemp());
//            PrecipitationLabel.setText(station.getPrecipitation());
//            Precipitation1Label.setText(Integer.toString(station.getPrecipitation1()));
//            PressureLabel.setText(station.getHumidity());
//
//            selectedDateLabel.setText(DateUtil.format(station.getselectedDate()));
        } else {
            // Station is null, remove all the text.
            StationLabel.setText("");
            TempLabel.setText("");
            PrecipitationLabel.setText("");
            Precipitation1Label.setText("");
            Precipitation1Label.setText("");
            selectedDateLabel.setText("");
        }
    }
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteStation() {
    	int selectedIndex = StationTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            StationTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
           // alert.initOwner(mainApp.getPrimaryStage());  primary stage not being shown
            alert.setTitle("No Selection");
            alert.setHeaderText("No station Selected");
            alert.setContentText("Please select a station in the table.");

            alert.showAndWait();
        }
}
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new Station.
     */
    @FXML
    private void handleNewStation() {
        Station tempStation = new Station();
        boolean okClicked = mainApp.showStationEditDialog(tempStation);
        if (okClicked) {
            mainApp.getStationData().add(tempStation);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected Station.
     */
    @FXML
    private void handleEditStation() {
        Station selectedStation = StationTable.getSelectionModel().getSelectedItem();
        if (selectedStation != null) {
            boolean okClicked = mainApp.showStationEditDialog(selectedStation);
            if (okClicked) {
                showStationDetails(selectedStation);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            //alert.initOwner(mainApp.getPrimaryStage()); primary stage not being shown
            alert.setTitle("No Selection");
            alert.setHeaderText("No Station Selected");
            alert.setContentText("Please select a Station in the table.");

            alert.showAndWait();
        }
    }
}