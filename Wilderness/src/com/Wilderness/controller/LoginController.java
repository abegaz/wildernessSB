package com.Wilderness.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
	// All objects used in the Login side of the split pane.
	@FXML TextField txtUserNameLogin;
	@FXML TextField txtPasswordLogin;
	@FXML Label lblUserNameFeedbackLogin; // Displays any user name errors when logging in.
	@FXML Label lblPasswordFeedbackLogin; // Displays any password errors when logging in.
	@FXML Button btnLogin;
	// All objects used in the Register side of the split pane.
	@FXML Button btnRegisterNewUser;
	@FXML TextField txtAdminIDRegister;
	@FXML TextField txtUserNameRegister;
	@FXML TextField txtPasswordRegister;
	@FXML Label lblAdminIDFeedbackRegister; // Displays any Admin ID errors when registering.
	@FXML Label lblUserNameFeedbackRegister; // Displays any user name errors when registering.
	@FXML Label lblPasswordFeedbackRegister; //Displays any password errors when registering.
	
}
