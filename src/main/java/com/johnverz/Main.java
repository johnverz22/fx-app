package com.johnverz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

public class Main extends Application {

    static Stage mainStage;

    public static void main(String[] args) {
        //System.out.println(BCrypt.hashpw("admin", BCrypt.gensalt(12)));
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        mainStage.setScene(new Scene(root, 600,400));
        mainStage.setTitle("Login");
        mainStage.show();
    }

    public static void welcome(){
        Parent root = null;
        try {
            root = FXMLLoader.load(Main.class.getResource("/fxml/dashboard.fxml"));
            mainStage.setScene(new Scene(root, 600,400));
            mainStage.setTitle("Dashboard");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}