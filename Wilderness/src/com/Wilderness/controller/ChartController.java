package com.Wilderness.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.Wilderness.model.Station;
import com.mysql.jdbc.PreparedStatement;

import application.WildernessDBConfig;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class ChartController {

    @FXML
    private LineChart<String, Double> RainfallLineChart;
    @FXML
    private LineChart<String, Double> WindSpeedLineChart;
    @FXML
    private LineChart<String, Double> PressureLineChart;
    @FXML
    private LineChart<String, Double> TemperatureLineChart;

    
    private Station selectedStation;
    
    public ChartController() {
    	
    }
    
    public void initialize(Station station) {
    	selectedStation = station;
    	ResultSet rs;
    	XYChart.Series<String, Double> series = new XYChart.Series<>();
    	try {
			PreparedStatement rainfall = (PreparedStatement) WildernessDBConfig.getConnection().prepareStatement("select date, rainfall from station_detail where stationID = ?");
			rainfall.setString(1,selectedStation.getStationID());
			rs = rainfall.executeQuery();
			while(rs.next()) {
				series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getDouble(2)));
			}
			RainfallLineChart.getData().add(series);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ResultSet rs2;
    	XYChart.Series<String, Double> series2 = new XYChart.Series<>();
    	try {
    		PreparedStatement windspeed = (PreparedStatement)WildernessDBConfig.getConnection().prepareStatement("select date, wind_speed from station_detail where stationID = ?");
    		windspeed.setString(1, selectedStation.getStationID());
    		rs2 = windspeed.executeQuery();
    		while(rs2.next()){
    			series2.getData().add(new XYChart.Data<>(rs2.getString(1),rs2.getDouble(2)));
    		}
    		WindSpeedLineChart.getData().add(series2);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	ResultSet rs3;
    	XYChart.Series<String,Double> series3 = new XYChart.Series<>();
    	try {
    		PreparedStatement pressure = (PreparedStatement)WildernessDBConfig.getConnection().prepareStatement("select date, barometric_pressure from station_detail where stationID = ?");
    		pressure.setString(1, selectedStation.getStationID());
    		rs3 = pressure.executeQuery();
    	
    	while(rs3.next()) {
    		series3.getData().add(new XYChart.Data<>(rs3.getString(1),rs3.getDouble(2)));
    	}
    	PressureLineChart.getData().add(series3);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	ResultSet rs4;
    	XYChart.Series<String, Double> series4 = new XYChart.Series<>();
    	try {
    		PreparedStatement temperature = (PreparedStatement) WildernessDBConfig.getConnection().prepareStatement("select date, air_temp from station_detail where stationID = ?");
    		temperature.setString(1, selectedStation.getStationID());
    		rs4 = temperature.executeQuery();
    	
    	while(rs4.next()) {
    		series4.getData().add(new XYChart.Data<>(rs4.getString(1),rs4.getDouble(2)));
    	}
    	TemperatureLineChart.getData().add(series4);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }


}