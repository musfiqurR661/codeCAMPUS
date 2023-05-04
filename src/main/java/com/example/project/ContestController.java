package com.example.project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ContestController implements Initializable{
    @FXML
    private AnchorPane backButtonInContestPage;

    @FXML
    void gotoHomePage(ActionEvent event) {
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

    // codeforces
    public static int ContestControllerCounter = 0;

    @FXML
    void gotoCodeforces(ActionEvent event) throws IOException {
        ContestControllerCounter = 1;
        clickEvent(event);
    }

    @FXML
    void gotoCodeChef(ActionEvent event) throws IOException {
        ContestControllerCounter = 2;
        clickEvent(event);
    }

    @FXML
    void gotoVJudge(ActionEvent event) throws IOException {
        ContestControllerCounter = 3;
        clickEvent(event);
    }

    void clickEvent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("webview2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    void LogOut(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Start1.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //go back
    public void goBack(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.fxml")));
        scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    //Next Page
    public void nextScene(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NextScene.fxml")));
        scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
// ranking code
    @FXML
    private TableColumn<Ranking, String> rank;
    @FXML
    private TableColumn<Ranking, String> userName;
    @FXML
    private TableColumn<Ranking, String> numContest;
    @FXML
    private TableColumn<Ranking, String> rating;


    @FXML
    private TableView<Ranking> rankTable;

    ObservableList<Ranking> list = FXCollections.observableArrayList(
            new Ranking("01","vox_r (Max: Candidate Master)","31","1940"),
            new Ranking("02","Mahinr10 (Max: Expertr)","87","1726"),
            new Ranking("03","rocky8086 (Max: Expert)","44","1615"),
            new Ranking("04","mbhuiyan071 (Max: Specialist)","44","1479"),
            new Ranking("05","abiramee (Max: Specialist)","110","1431"),
            new Ranking("06","TarekHasan011 (Max: Specialist)","12","1414"),
            new Ranking("07","Taniv (Max: Specialist)","150","1410"),
            new Ranking("08","raidenblackout (Max: Specialist)","117","1406"),
            new Ranking("09","MFarhan (Max: Specialist)","129","1406"),
            new Ranking("10","spark_sam (Max: Specialist)","135","1402"),
            new Ranking("11","ranadepto (Max: Specialist)","145","1402"),
            new Ranking("12","Shofiq (Max: Pupil)","49","1384"),
            new Ranking("13","farjana185jahin (Max: Pupil)","1","1382"),
            new Ranking("14","zeyoFoyez (Max: Pupil)","37","1259"),
            new Ranking("15","ynnuSunny (Max: Pupil)","107","1213"),
            new Ranking("16","B4TMAN (Max: Pupil)","77","1086"),
            new Ranking("17","tarek200","38","1078"),
            new Ranking("18","F_O_Y_E_Z","159","1065"),
            new Ranking("19","Kazi_Fahmi","31","1015"),
            new Ranking("20","monserali704","8","1001"),
            new Ranking("21","Arnob_was_here","25","1000"),
            new Ranking("22","yeasirar","21","995"),
            new Ranking("23","rakib151p","45","976"),
            new Ranking("24","FatinShadab","4","862"),
            new Ranking("25","Tashin.Parvez","12","837"),
            new Ranking("26","Maharab_Hossain_Opi","3","715"),
            new Ranking("27","tasnintanisha","3","700"),
            new Ranking("28","mnoman338","7","693"),
            new Ranking("29","tamim_66","8","592"),
            new Ranking("30","sifat6472","1","386")
    );
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rank.setCellValueFactory(new PropertyValueFactory<Ranking, String>("rank"));
        userName.setCellValueFactory(new PropertyValueFactory<Ranking, String>("userName"));
        numContest.setCellValueFactory(new PropertyValueFactory<Ranking, String>("numContest"));
        rating.setCellValueFactory(new PropertyValueFactory<Ranking, String>("rating"));
        rankTable.setItems(list);
    }

}

