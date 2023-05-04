package com.example.project;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HelloController implements Initializable {
    @FXML
    private TableView<Announcement> TableView;
    @FXML
    private TableColumn<Announcement, String> CFNAME;
    @FXML
    private TableColumn<Announcement, String> CFDATE;
    @FXML
    private TableColumn<Announcement, String> CCNAME;
    @FXML
    private TableColumn<Announcement,String> CCDATE;
    @FXML
    private TableColumn<Announcement, String> VJNAME;
    @FXML
    private TableColumn<Announcement, String> VJDATE;

    ObservableList<Announcement> list = FXCollections.observableArrayList(
           // new Announcement("CodeCampus contest ","apr")
            new Announcement("Codeforces Round 870(Div.2)","May/04/2023(20:35UTC+6)","Starters 88","03/May/2023(Wed 20:30)","CodeCamous Round 1","May/05/2023"),
            new Announcement("Codeforces Round (Div.1)","May/04/2023(20:35UTC+6)","Starters 89","10/May/2023(Wed 20:30)","CodeCamous Round 2","May/20/2023"),
            new Announcement("Codeforces Round (Div. 2)","May/08/2023(20:35UTC+6)","Starters 90","17/May/2023(Wed 20:30)","CodeCamous Round 3","May/22/2023"),
            new Announcement("Codeforces Round (Div. 1)","May/08/2023(20:35UTC+6)","Starters 91","24/May/2023(Wed 20:30)","CodeCamous Round 4","May/25/2023"),
            new Announcement("Codeforces Round (Div. 2)","May/14/2023(20:35UTC+6)","Starters 92","31/May/2023(Wed 20:30)","",""),
            new Announcement("Codeforces Round (Div. 1)","May/14/2023(20:35UTC+6)","","","","")
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CFNAME.setCellValueFactory(new PropertyValueFactory<Announcement,String>("CFNAME"));
        CFDATE.setCellValueFactory(new PropertyValueFactory<Announcement,String>("CFDATE"));
        CCNAME.setCellValueFactory(new PropertyValueFactory<Announcement,String>("CCNAME"));
        CCDATE.setCellValueFactory(new PropertyValueFactory<Announcement,String>("CCDATE"));
        VJNAME.setCellValueFactory(new PropertyValueFactory<Announcement,String>("VJNAME"));
        VJDATE.setCellValueFactory(new PropertyValueFactory<Announcement,String>("VJDATE"));
        TableView.setItems(list);
    }
    private Parent root;
    private Stage stage;
    private Scene scene;
    public void nextScene(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NextScene.fxml")));
        scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void goBack(ActionEvent e) throws IOException {
        root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("contest.fxml")));
        scene=new Scene(root);
        stage=(Stage)((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
}