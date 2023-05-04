
//3rd c
package com.example.project;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.project.Start.*;
import static javafx.util.Duration.*;
//import static com.example.project.Main;
public class HomePageController implements Initializable {
    @FXML
    private Button contest;

    @FXML
    private Button chat;
    @FXML
    private Button learPort;

    @FXML
    private Label moto;

    @FXML
    private Button newsFeed;

    @FXML
    private Button student;

    @FXML
    private Button teachers;

    private String typingText = "Welcome to codeCAMPUS.";
    private int currentIndex = 0;
    private boolean isWelcomeDisplayed = true;

    @FXML
    void gotoContestPage(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("contest.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("tarek.css");
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void gotoLearningPortal(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("LearningPort.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void gotoNewsFeed(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("newsFeed01.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void gotoStudentsPortal(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Student.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void gotoTeachersPortal(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Teacher.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
//********************chat page************************///


    @FXML
    void openChatSystem(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("chat_gui.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
      // com.example.project.Main.main(new String[] {});

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Timeline timeline = new Timeline(new KeyFrame(millis(300), event -> {
            if (isWelcomeDisplayed) {
                if (currentIndex <= typingText.length()) {
                    moto.setText(typingText.substring(0, currentIndex));
                    currentIndex++;
                } else {
                    isWelcomeDisplayed = false;
                    currentIndex = 0;
                }
            } else {
                typingText = "Build & Run your destination.";
                if (currentIndex <= typingText.length()) {
                    moto.setText(typingText.substring(0, currentIndex));
                    currentIndex++;
                } else {
                    currentIndex = 0;
                }
            }
        }));

        System.out.println(currentUserName);

        System.out.println(currentUserType);


        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @FXML
    void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void gotoRoom(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load((getClass().getResource("Room.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void LogOut(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}