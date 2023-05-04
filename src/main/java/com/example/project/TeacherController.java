package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {

    @FXML
    private ScrollPane scrollablePaneforNewsfeed;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<String> allTeachers = new ArrayList<>();

        ///*** ...................  Database to ArrayList ...........................*****////////
        // Connect to the database
        String url = "jdbc:mysql://127.0.0.1/musfiq";
        String user = "root";
        String password = "";
        System.out.println("Connecting database...");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // Execute a SELECT query
            String teacherName = "SELECT fullName FROM useraccounts";
            PreparedStatement stmt = conn.prepareStatement(teacherName);
            ResultSet rs = stmt.executeQuery();

            String isTeacher = "SELECT userType FROM useraccounts";
            PreparedStatement stmt1 = conn.prepareStatement(isTeacher);
            ResultSet rs1 = stmt1.executeQuery();

            String mail = "SELECT email FROM useraccounts";
            PreparedStatement stmt2 = conn.prepareStatement(mail);
            ResultSet rs2 = stmt2.executeQuery();

            // Iterate over the ResultSet
            while (rs.next() && rs1.next() && rs2.next()) {
                if(((rs1.getString("userType")).compareTo("Teacher")) == 0){

                    String mailValue = rs2.getString("email");
                    String value = rs.getString("fullName");
                    allTeachers.add(value + "<split>" + mailValue);
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        ///*** ...................  .................. ...........................*****////////
        // Create a VBox to hold the teacherList items
        VBox teacherList = new VBox();
        teacherList.setPrefSize(600, Region.USE_COMPUTED_SIZE);
        teacherList.setSpacing(5);
        teacherList.setPadding(new Insets(10));

        // Add some teacherList items
        for (int i = 0; i < allTeachers.size(); i++) {

            String[] string = allTeachers.get(i).split("<split>");
            Label studentName = new Label();
            studentName.setPrefSize(310, Region.USE_COMPUTED_SIZE);
            studentName.setText((i+1) + ". " + string[0]);
            studentName.setBackground(Background.fill(Color.WHITE));
            Font font1 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 13);
            studentName.setFont(font1);

            Label mailLabel = new Label();
            mailLabel.setPrefSize(290, Region.USE_COMPUTED_SIZE);
            mailLabel.setText(string[1]);
            mailLabel.setTextAlignment(TextAlignment.RIGHT);
            mailLabel.setBackground(Background.fill(Color.WHITE));
            Font font2 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 13);
            mailLabel.setFont(font2);

            HBox hBox = new HBox();
            hBox.getChildren().add(studentName);
            hBox.getChildren().add(mailLabel);

            teacherList.getChildren().add(hBox);
        }

        // Create a ScrollPane to hold the teacherList
        scrollablePaneforNewsfeed.setContent(teacherList);
        scrollablePaneforNewsfeed.setFitToWidth(true);

        ///*** ...................  .................. ...........................*****////////
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

    public void LogOut(ActionEvent actionEvent) {
    }
}
