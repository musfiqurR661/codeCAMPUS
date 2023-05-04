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

public class StudentController implements Initializable {

    @FXML
    private ScrollPane scrollablePaneforNewsfeed;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<String> allStudents = new ArrayList<>();

        ///*** ...................  Database to ArrayList ...........................*****////////
        // Connect to the database
        String url = "jdbc:mysql://127.0.0.1/musfiq";
        String user = "root";
        String password = "";
        System.out.println("Connecting database...");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // Execute a SELECT query
            String studentName = "SELECT fullName FROM useraccounts";
            PreparedStatement stmt = conn.prepareStatement(studentName);
            ResultSet rs = stmt.executeQuery();

            String isStudent = "SELECT userType FROM useraccounts";
            PreparedStatement stmt1 = conn.prepareStatement(isStudent);
            ResultSet rs1 = stmt1.executeQuery();

            String mail = "SELECT email FROM useraccounts";
            PreparedStatement stmt2 = conn.prepareStatement(mail);
            ResultSet rs2 = stmt2.executeQuery();

            // Iterate over the ResultSet
            while (rs.next() && rs1.next() && rs2.next()) {
                if(((rs1.getString("userType")).compareTo("Student")) == 0){

                    String mailValue = rs2.getString("email");
                    String value = rs.getString("fullName");
                    allStudents.add(value + "<split>" + mailValue);
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        ///*** ...................  .................. ...........................*****////////
        // Create a VBox to hold the studentList items
        VBox studentList = new VBox();
        studentList.setPrefSize(600, Region.USE_COMPUTED_SIZE);
        studentList.setSpacing(5);
        studentList.setPadding(new Insets(10));

        // Add some studentList items
        for (int i = 0; i < allStudents.size(); i++) {

            String[] string = allStudents.get(i).split("<split>");
            Label teacherName = new Label();
            teacherName.setPrefSize(310, Region.USE_COMPUTED_SIZE);
            teacherName.setText((i+1) + ". " + string[0]);
            teacherName.setBackground(Background.fill(Color.WHITE));
            Font font1 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 13);
            teacherName.setFont(font1);

            Label mailLabel = new Label();
            mailLabel.setPrefSize(290, Region.USE_COMPUTED_SIZE);
            mailLabel.setText(string[1]);
            mailLabel.setTextAlignment(TextAlignment.RIGHT);
            mailLabel.setBackground(Background.fill(Color.WHITE));
            Font font2 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 13);
            mailLabel.setFont(font2);

            HBox hBox = new HBox();
            hBox.getChildren().add(teacherName);
            hBox.getChildren().add(mailLabel);

            studentList.getChildren().add(hBox);
        }

        // Create a ScrollPane to hold the studentList
        scrollablePaneforNewsfeed.setContent(studentList);
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
