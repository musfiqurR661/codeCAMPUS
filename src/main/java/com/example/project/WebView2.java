package com.example.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WebView2 implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    void goback(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("contest.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

    }
    @FXML
    private javafx.scene.web.WebView webpage2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(ContestController.ContestControllerCounter);
        if(ContestController.ContestControllerCounter==1){
            WebEngine webEngine = webpage2.getEngine();
            webEngine.load("https://www.codeforces.com");
        }
        else if (ContestController.ContestControllerCounter==2) {
            WebEngine webEngine = webpage2.getEngine();
            webEngine.load(("https://www.codechef.com"));
        }
        else if (ContestController.ContestControllerCounter==3) {
            WebEngine webEngine = webpage2.getEngine();
            webEngine.load(("https://vjudge.net/"));
        }

    }

    /*xxxx*

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;

    public class Start extends Application {

        @Override
        public void start(Stage stage) throws Exception {
            Parent root= FXMLLoader.load(getClass().getResource("LogInPage.fxml"));

            //Image image = new Image("G:\\codeCAMPUSTrail\\src\\logo.png");

            stage.getIcons().add(new Image(com.example.project.Start.class.getResourceAsStream("logo.png")));
            stage.setTitle("codeCAMPUS");

            Scene scene=new Scene(root);
            stage.setScene(scene);


            stage.show();
        }
        public static void main(String[] args) {
            launch(args);
//        //--------------Chat system-------------------------//
//
//        Server.main(new String[]{"m"});



        }

//
//        //**** ............ All static variable ........................***///
//        public static String currentUserName;
//        public static String currentUserUsername;
//        public static String currentUserType;
//        public static int counterForMenuOpenClose = 0;
//        public static int counterForShowingPostTypeWise = 0;
//        /**
//         *  All -> 0
//         *  Announcement -> 1
//         *  Contest Announcement -> 2
//         *  Query -> 3
//         */
//
//        //public static ArrayList<String> allPost = new ArrayList<>();
//        //**** ............ ...................... ........................***///
//
//        //--------------Chat system-------------------------//
//
//        public static int chattingCounter = 1;
//
//        public static ArrayList<User> loggedInUser = new ArrayList<>();
//        public static ArrayList<User> users = new ArrayList<User>();
//
//
//    }


}
