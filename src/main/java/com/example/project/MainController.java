package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private Button loginFx;

    @FXML
    private Button signUpFx;

    @FXML
    void gotoLogInPage(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    void gotoSignInPage(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
