package com.Wilderness.controller;



import com.Wilderness.model.Employee;
import com.Wilderness.model.User;

import application.WildernessDBConfig;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
	// All objects used in the Login side of the split pane.
	@FXML private TextField txtUserNameLogin;
	@FXML private TextField txtPasswordLogin;
	@FXML private Label lblUserNameFeedbackLogin; // Displays any user name errors when logging in.
	@FXML private Label lblPasswordFeedbackLogin; // Displays any password errors when logging in.
	@FXML private Button btnLogin;
	// All objects used in the Register side of the split pane.
	@FXML private Button btnRegisterNewUser;
	@FXML private TextField txtAdminIDRegister;
	@FXML private TextField txtUserNameRegister;
	@FXML private TextField txtPasswordRegister;
	@FXML private Label lblAdminIDFeedbackRegister; // Displays any Admin ID errors when registering.
	@FXML private Label lblUserNameFeedbackRegister; // Displays any user name errors when registering.
	@FXML private Label lblPasswordFeedbackRegister; //Displays any password errors when registering.
	@FXML private TextField mainTxt; 
	
	//public final void onActionProperty() throws SQLException{
	//	PreparedStatement ps = WildernessDBConfig.getConnection().prepareStatement("SELECT * FROM user WHERE email = ? and password = ?");
	//}
	    public void onLoginButtonPushed(ActionEvent event) {
    	User user = new User(txtUserNameLogin.getText(),txtPasswordLogin.getText());
    	try{
		if(user.validLogin(txtUserNameLogin.getText(), txtPasswordLogin.getText())) {
			//Will add method that loads main page later.
			lblUserNameFeedbackLogin.setText("Login Successful");
//			mainTxt.getScene().getWindow();

		}
			else {
				lblUserNameFeedbackLogin.setText("Incorrect user name or password");
			}
		}
    	catch(Exception a) {
    		lblUserNameFeedbackLogin.setText("Error");
    	}	
    }
	    public void onRegisterButtonPushed(ActionEvent event) {
	    	User user = new User(txtUserNameRegister.getText(), txtPasswordRegister.getText());
	    	Employee empNum = new Employee(txtAdminIDRegister.getText());
	    		try {
	    			if(user.validRegister(empNum, txtUserNameRegister.getText(), txtPasswordRegister.getText()) && Employee.isUniqueEmpNum(txtAdminIDRegister.getText())) {
	    				lblAdminIDFeedbackRegister.setText("Successful registration");
//	    				mainTxt.getScene().getWindow();
	    			}
	    			else if(user.validRegister(empNum, txtUserNameRegister.getText(), txtPasswordRegister.getText()) && !Employee.isUniqueEmpNum(txtAdminIDRegister.getText())){
	    				lblAdminIDFeedbackRegister.setText("Admin ID is incorrect");
	    			}
	    			else if(!user.validRegister(empNum, txtUserNameRegister.getText(), txtPasswordRegister.getText()) && Employee.isUniqueEmpNum(txtAdminIDRegister.getText())) {
	    				lblAdminIDFeedbackRegister.setText("User name or password is already in use");
	    			}
	    			else if(!user.validRegister(empNum, txtUserNameRegister.getText(), txtPasswordRegister.getText()) && !Employee.isUniqueEmpNum(txtAdminIDRegister.getText())) {
	    				lblAdminIDFeedbackRegister.setText("Invalid Admin ID or User name and password are incorrect");
	    			}
	    			else {
	    				lblAdminIDFeedbackRegister.setText("Something is horribly wrong");
	    			}
	    			
	    		}
	    		catch(Exception a) {
	    			a.printStackTrace();
	    			lblAdminIDFeedbackRegister.setText("Error");
	    		}
	    	}


}
