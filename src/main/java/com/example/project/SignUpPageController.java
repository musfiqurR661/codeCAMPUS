package com.example.project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Objects;

public class SignUpPageController {
    @FXML
    private PasswordField cpasswordbox;

    @FXML
    private TextField emailbox;

    @FXML
    private Button loginButtonInSignUpPage;

    @FXML
    private TextField namebox;

    @FXML
    private PasswordField passwordbox;

    @FXML
    private Button signUp;

    @FXML
    private TextField usernamebox;

    //----------teachers& student radio button----------//
    @FXML
    private RadioButton studentsRadioButton;

    @FXML
    private RadioButton teachersRadioButton;

    @FXML
    private ToggleGroup userTypeGroup;

    @FXML
    void initialize() {
        userTypeGroup = new ToggleGroup();
        studentsRadioButton.setToggleGroup(userTypeGroup);
        teachersRadioButton.setToggleGroup(userTypeGroup);
    }

    @FXML
    void goToLoginPage(ActionEvent event) throws Exception {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LogInPage.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void signUpClicked(ActionEvent event) {
        String url = "jdbc:mysql://127.0.0.1/musfiq";
        String username = "root";
        String password = "";
        System.out.println("Connecting database...");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        Connection con;
        PreparedStatement pst;

        String user_Fullname = namebox.getText();
        String user_email = emailbox.getText();
        String User_username = usernamebox.getText();
        String user_password = passwordbox.getText();
        String c_Password = cpasswordbox.getText();


        //------------------Handel Teachers or a Students ------------------//
        String userType = null;
        if (studentsRadioButton.isSelected()) {
            userType = "Student";
        } else if (teachersRadioButton.isSelected()) {
            userType = "Teacher";
        }

        if (user_Fullname != null && user_email != null && User_username != null && user_password.equals(c_Password) && userType != null) {
            try {
                con = DriverManager.getConnection(url, username, password);

                pst = con.prepareStatement("INSERT INTO useraccounts(fullName,email,username,password,userType) VALUES(?,?,?,?,?)");
                pst.setString(1, user_Fullname);
                pst.setString(2, user_email);
                pst.setString(3, User_username);
                pst.setString(4, user_password);
                pst.setString(5, userType);
                pst.execute();

                System.out.println("Insert successful");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Welcome");
                alert.setHeaderText("Login Successful");
                alert.setContentText("Sign up Successful");
                alert.showAndWait();

            } catch (Exception e) {
                e.getStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Please enter all data correctly");
            alert.showAndWait();
        }

    }
}
