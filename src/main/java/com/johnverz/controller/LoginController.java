package com.johnverz.controller;

import com.johnverz.Main;
import com.johnverz.db.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    DatabaseConnection db;

    @FXML
    TextField textUsername;

    @FXML
    PasswordField textPassword;

    @FXML
    Label loginError;

    public void initialize(){
        db =  new DatabaseConnection();
    }
    public void onLogin(){
        loginError.setVisible(false); //hides error
        if(db.authenticate(textUsername.getText(), textPassword.getText())){
            Main.welcome(); //change screen
        }else{
            loginError.setVisible(true); //show error
        }
    }
}
