package com.Wilderness.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import application.Main;
import application.WildernessDBConfig;

import com.Wilderness.model.Station;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Wilderness.model.DateUtil;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    @FXML
    private Button selectNewDateButton;
    @FXML
    private TextField InsertDateTextField;
    
    final String DEGREES = "\u2103";


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
        StationTable.setItems(getStationList());
        selectNewDateButton.setText("Search");
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
     * Imports data from the station table in the database, populates the station list and the station detail.
     * Called during initialization.
     * @return stationList
     */
    public ObservableList<Station> getStationList() {
    	ObservableList<Station> stationList = FXCollections.observableArrayList();
    	PreparedStatement insertStatement;
    	PreparedStatement insertStationDetails;
    	ResultSet rs,rs2;
    	try {
    	insertStatement = (PreparedStatement) WildernessDBConfig.getConnection().prepareStatement("select location, station_id from station");
    	rs = insertStatement.executeQuery();
    	while(rs.next()) {
        	insertStationDetails = WildernessDBConfig.getConnection().prepareStatement("select wind_speed, air_temp, barometric_pressure, rainfall, date from station_detail where stationID = "+(rs.getString("station_id")+" limit 1"));
        	rs2 = insertStationDetails.executeQuery();
        	while(rs2.next()) {
    		stationList.add(new Station(rs.getString("location").toString(), rs.getString("station_id").toString(), rs2.getString("air_temp").toString(), rs2.getString("barometric_pressure").toString(), rs2.getString("rainfall").toString(), rs2.getString("wind_speed").toString(), rs2.getString("date").toString()));
        	}
        	}

    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return stationList;
    	
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
            StationIDLabel.setText(station.getStationID());
            TempLabel.setText(station.getTemp()+DEGREES);
            PrecipitationLabel.setText(station.getPrecipitation()+"cm");
            WindSpeedLabel.setText(station.getWindSpeed()+"Km/h");
            PressureLabel.setText(station.getPressure()+"InHg");
            selectedDateLabel.setText(station.getSelectedDate());
        } else {
            // Station is null, remove all the text.
            StationLabel.setText("");
            StationIDLabel.setText("");
            TempLabel.setText("");
            PrecipitationLabel.setText("");
            WindSpeedLabel.setText("");
            PressureLabel.setText("");
//           Precipitation1Label.setText("");
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
    /** Changes the station details screen to display data by day it was collected.
     * @param event
     */
    @FXML
    private void handleNewDate(ActionEvent event) {
//    	String newDate = InsertDateTextField.getText();
    	Station selectedStation = StationTable.getSelectionModel().getSelectedItem();
    	PreparedStatement insertData;
    	ResultSet rs;
    	try {
    		insertData = (PreparedStatement) WildernessDBConfig.getConnection().prepareStatement("select wind_speed, air_temp, barometric_pressure, rainfall, date from station_detail where date = ? and stationID = ?");
    		insertData.setString(1, InsertDateTextField.getText());
    		insertData.setString(2, selectedStation.getStationID());
    		rs = insertData.executeQuery();
    		if(rs.next()) {
    			Station tempStation = new Station(selectedStation.getStation(), selectedStation.getStationID(),rs.getString("air_temp").toString(),
    	                rs.getString("rainfall").toString(),
    	                rs.getString("wind_speed").toString(),
    	                rs.getString("barometric_pressure").toString(),
    	                rs.getString("date").toString());
    			selectedStation = tempStation;
    			StationLabel.setText(selectedStation.getStation());
                StationIDLabel.setText(selectedStation.getStationID());
                TempLabel.setText(selectedStation.getTemp()+DEGREES);
                PrecipitationLabel.setText(selectedStation.getPrecipitation()+"cm");
                WindSpeedLabel.setText(selectedStation.getWindSpeed()+"Km/h");
                PressureLabel.setText(selectedStation.getPressure()+"InHg");
                selectedDateLabel.setText(selectedStation.getSelectedDate());
    			
               
    			
    		}
    		else {
        		selectedDateLabel.setText("Invalid Date");

    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		selectedDateLabel.setText("Invalid Date");
    	}

    }
    public void changeSceneToGraphData(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/com/Wilderness/view/RainfallChart.fxml"));
    	Parent anchorParent = loader.load();
    	Scene anchorScene = new Scene(anchorParent);
    	ChartController controller = loader.getController();
    	controller.initialize(StationTable.getSelectionModel().getSelectedItem());
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(anchorScene);
    	window.show();
    }
    
}