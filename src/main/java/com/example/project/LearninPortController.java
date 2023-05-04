
package com.example.project;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LearninPortController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //menuVBoxInLearningPortal.setVisible(false);
//
//        menuVBoxInLearningPortal.setPrefSize(25, 650);
//        AnchorPaneOnVBoxInLearningPortal.setPrefSize(25, 25);
//        menuButtonInLearningPortal.setPrefSize(25, 25);
//        menuButtonInLearningPortal.setLayoutX(0);
//
//        contestButtonInLearningPortal.setPrefSize(25, 125);
//        learningPoralButtonInLearningPortal.setPrefSize(25, 125);
//        newsFeedButtonInLearningPortal.setPrefSize(25, 125);
//        studentsButtonInLearningPortal.setPrefSize(25, 125);
//        teacherButtonInLearningPortal.setPrefSize(25, 125);
//
//        resizableAnchorPaneInLearningPortal.setPrefSize(1055, 650);
//        resizableAnchorPaneInLearningPortal.setLayoutX(25);
//        resizableAnchorPaneInLearningPortalonAnotherPane.setPrefSize(1055, 165);
//        resizableAnchorPaneInLearningPortalonAnotherPane.setLayoutX(25);
//        hBox1InLearningPortal.setLayoutX(115);
//        hBox2InLearningPortal.setLayoutX(115);
//        hBox3InLearningPortal.setLayoutX(115);
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
    void gotoContestPage(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("contest.fxml"));
            Scene scene = new Scene(root);
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


    ////** Learning portal all webview action event**////

    public static int webviewControlCounter = 0;

    @FXML
    void gotoW3school(ActionEvent event) throws IOException {
        webviewControlCounter = 1;
        clickEvent(event);

    }
    @FXML
    void gotoStackOverflow(ActionEvent event) throws IOException {
        webviewControlCounter = 2;
        clickEvent(event);
    }

    @FXML
    void gotoCPAlgorithm(ActionEvent event) throws IOException {

        webviewControlCounter = 3;
        clickEvent(event);

    }

    @FXML
    void gotoCodeforwin(ActionEvent event) throws IOException {
        webviewControlCounter = 4;
        clickEvent(event);

    }

    @FXML
    void gotoProgramiz(ActionEvent event) throws IOException {
        webviewControlCounter = 5;
        clickEvent(event);

    }

    @FXML
    void gotoGeekForGeeks(ActionEvent event) throws IOException {
        webviewControlCounter = 6;
        clickEvent(event);

    }


    @FXML
    void gotoYoutube(ActionEvent event) throws IOException {
        webviewControlCounter = 7;
        clickEvent(event);
    }

    @FXML
    void gotoHakerrank(ActionEvent event) throws IOException {
        webviewControlCounter = 8;
        clickEvent(event);
    }
    @FXML
    void gotoCodewars(ActionEvent event) throws IOException {
        webviewControlCounter = 9;
        clickEvent(event);
    }
    @FXML
    void gotoCodeorg(ActionEvent event) throws IOException {
        webviewControlCounter = 10;
        clickEvent(event);
    }

    @FXML
    void gotoTutorialpoints(ActionEvent event) throws IOException {
        webviewControlCounter = 11;
        clickEvent(event);
    }

    @FXML
    void gotoGitHub(ActionEvent event) throws IOException {
        webviewControlCounter = 12;
        clickEvent(event);

    }

    @FXML
    void gotoGDB(ActionEvent event) throws IOException {
        webviewControlCounter = 13;
        clickEvent(event);
    }

    @FXML
    void gotoFreeCodeCamp(ActionEvent event) throws IOException {
        webviewControlCounter = 14;
        clickEvent(event);
    }

    @FXML
    void gotoCoderByte(ActionEvent event) throws IOException {
        webviewControlCounter = 15;
        clickEvent(event);
    }

    @FXML
    void gotoTopCoder(ActionEvent event) throws IOException {
        webviewControlCounter = 16;
        clickEvent(event);
    }

    @FXML
    void gotoLightOj(ActionEvent event) throws IOException {
        webviewControlCounter = 17;
        clickEvent(event);
    }

    @FXML
    void gotoGuru99(ActionEvent event) throws IOException {
        webviewControlCounter = 18;
        clickEvent(event);
    }
    private Parent root;
    private Stage stage;
    private Scene scene;
    public void nextScene(ActionEvent e) throws IOException {
        root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NextScene.fxml")));
        scene=new Scene(root);
        stage=(Stage)((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    void clickEvent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("webview.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }


    ////**--------------------------------------------------------------------------------------**////


    ////** FxId for menu open and close **////

    @FXML
    private HBox hBox1InLearningPortal;

    @FXML
    private HBox hBox2InLearningPortal;

    @FXML
    private HBox hBox3InLearningPortal;

    @FXML
    private VBox menuVBoxInLearningPortal;

    @FXML
    private AnchorPane resizableAnchorPaneInLearningPortal;

    @FXML
    private AnchorPane resizableAnchorPaneInLearningPortalonAnotherPane;

    @FXML
    private AnchorPane AnchorPaneOnVBoxInLearningPortal;
    @FXML
    private Button contestButtonInLearningPortal;
    @FXML
    private Button learningPoralButtonInLearningPortal;

    @FXML
    private Button menuButtonInLearningPortal;
    @FXML
    private Button newsFeedButtonInLearningPortal;
    @FXML
    private Button studentsButtonInLearningPortal;

    @FXML
    private Button teacherButtonInLearningPortal;

    ////**-------------------------------------------------------------------------------------------**////


    ////** Action event for menu open and close **////


    @FXML
    void menuOpenCloseEvent(ActionEvent event) {

        // Already close, work for open

        if(Start.counterForMenuOpenClose == 0) {
            menuVBoxInLearningPortal.setPrefSize(115, 650);
            AnchorPaneOnVBoxInLearningPortal.setPrefSize(115, 25);
            menuButtonInLearningPortal.setPrefSize(46.5, 25);
            menuButtonInLearningPortal.setLayoutX(68.5);


            contestButtonInLearningPortal.setPrefSize(115, 125);
            learningPoralButtonInLearningPortal.setPrefSize(115, 125);
            newsFeedButtonInLearningPortal.setPrefSize(115, 125);
            studentsButtonInLearningPortal.setPrefSize(115, 125);
            teacherButtonInLearningPortal.setPrefSize(115, 125);

            resizableAnchorPaneInLearningPortal.setPrefSize(965, 650);
            resizableAnchorPaneInLearningPortal.setLayoutX(115);
            resizableAnchorPaneInLearningPortalonAnotherPane.setPrefSize(965, 165);
            resizableAnchorPaneInLearningPortalonAnotherPane.setLayoutX(115);
            hBox1InLearningPortal.setLayoutX(55);
            hBox2InLearningPortal.setLayoutX(55);
            hBox3InLearningPortal.setLayoutX(55);

            Start.counterForMenuOpenClose = 1;
        }
        // Already open, work for close
        else if (Start.counterForMenuOpenClose == 1) {
            menuVBoxInLearningPortal.setPrefSize(25, 650);
            AnchorPaneOnVBoxInLearningPortal.setPrefSize(25, 25);
            menuButtonInLearningPortal.setPrefSize(25, 25);
            menuButtonInLearningPortal.setLayoutX(0);

            contestButtonInLearningPortal.setPrefSize(25, 125);
            learningPoralButtonInLearningPortal.setPrefSize(25, 125);
            newsFeedButtonInLearningPortal.setPrefSize(25, 125);
            studentsButtonInLearningPortal.setPrefSize(25, 125);
            teacherButtonInLearningPortal.setPrefSize(25, 125);

            resizableAnchorPaneInLearningPortal.setPrefSize(1055, 650);
            resizableAnchorPaneInLearningPortal.setLayoutX(25);
            resizableAnchorPaneInLearningPortalonAnotherPane.setPrefSize(1055, 165);
            resizableAnchorPaneInLearningPortalonAnotherPane.setLayoutX(25);
            hBox1InLearningPortal.setLayoutX(115);
            hBox2InLearningPortal.setLayoutX(115);
            hBox3InLearningPortal.setLayoutX(115);

            Start.counterForMenuOpenClose = 0;
        }
    }

    //method for website





}
