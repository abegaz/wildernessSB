package com.Wilderness.controller;

import com.Wilderness.model.DateUtil;
import com.Wilderness.model.Station;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StationEditDialogController {

    @FXML
    private TextField StationField;
    @FXML
    private TextField TempField;
    @FXML
    private TextField PrecipitationField;
    @FXML
    private TextField Precipitation1Field;
    @FXML
    private TextField HumidityField;
    @FXML
    private TextField selectedDateField;


    private Stage dialogStage;
    private Station station;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the station to be edited in the dialog.
     * 
     * @param station
     */
    public void setStation(Station station) {
        this.station = station;

        StationField.setText(station.getStation());
        TempField.setText(station.getTemp());
        PrecipitationField.setText(station.getPrecipitation());
        Precipitation1Field.setText(Integer.toString(station.getPrecipitation1()));
        selectedDateField.setText(DateUtil.format(station.getselectedDate()));
        selectedDateField.setPromptText("dd.mm.yyyy");
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            station.setStation(StationField.getText());
            station.setTemp(TempField.getText());
            station.setPrecipitation(PrecipitationField.getText());
            station.setPrecipitation1(Integer.parseInt(Precipitation1Field.getText()));
            station.setselectedDate(DateUtil.parse(selectedDateField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (StationField.getText() == null || StationField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (TempField.getText() == null || TempField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }
        if (PrecipitationField.getText() == null || PrecipitationField.getText().length() == 0) {
            errorMessage += "No valid Precipitation!\n"; 
        }

        if (Precipitation1Field.getText() == null || Precipitation1Field.getText().length() == 0) {
            errorMessage += "No valid postal code!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(Precipitation1Field.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n"; 
            }
        }

        if (HumidityField.getText() == null || HumidityField.getText().length() == 0) {
            errorMessage += "No valid Humidity!\n"; 
        }

        if (selectedDateField.getText() == null || selectedDateField.getText().length() == 0) {
            errorMessage += "No valid selectedDate!\n";
        } else {
            if (!DateUtil.validDate(selectedDateField.getText())) {
                errorMessage += "No valid . Use the format dd.mm.yyyy!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}