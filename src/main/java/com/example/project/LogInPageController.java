

package com.example.project;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.*;

import static com.example.project.Start.*;

public class LogInPageController {

    @FXML
    private TextField inputbox;

    @FXML
    private Button login;

    @FXML
    private PasswordField passwordbox;

    @FXML
    void goToSignUpPage(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    ////** Action event for going to home page from login page---------------------------------**////
    @FXML
    void loginClickedByMouseClicked(MouseEvent event) {
        loginEventMethod(event);

    }

    @FXML
    void loginClickedByEnterKeyInPasswordeField(KeyEvent event) {
        passwordbox.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                loginEventMethod(e);
            }
        });
    }

    @FXML
    void loginClickedByEnterKeyInUsernameField(KeyEvent event) {
        inputbox.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                loginEventMethod(e);
            }
        });
    }

    // Method for going to home page from login page
    void loginEventMethod(Event event) {


        String input = inputbox.getText();
        String pas = passwordbox.getText();

        currentUserUsername = input;

        System.out.println(input);
        System.out.println(pas);


        String url = "jdbc:mysql://127.0.0.1/musfiq";
        String username = "root";
        String password = "";
        System.out.println("Connecting database...");



        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");

            // Query the database to retrieve the full name of the user
            currentUserName = "SELECT fullName FROM useraccounts WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(currentUserName);
            statement.setString(1, currentUserUsername);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                currentUserName = rs.getString("fullName");
            }

            currentUserType = "SELECT userType FROM useraccounts WHERE username = ?";
            PreparedStatement statement1 = connection.prepareStatement(currentUserType);
            statement1.setString(1, currentUserUsername);
            ResultSet rs1 = statement1.executeQuery();
            if (rs1.next()) {
                currentUserType= rs1.getString("userType");
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        try {
            String chk1 = "Select * from useraccounts where email=?";
            String chk2 = "Select * from useraccounts where username=?";
            Connection con;
            PreparedStatement pst1, pst2;
            con = DriverManager.getConnection(url, username, password);
            pst1 = con.prepareStatement(chk1);
            pst2 = con.prepareStatement(chk2);
            pst1.setString(1, input);
            pst2.setString(1, input);
            ResultSet rs1;
            ResultSet rs2;
            rs1 = pst1.executeQuery();
            rs2 = pst2.executeQuery();
            if (rs1.next()) {
                String pass = rs1.getString("password");
                if (pas.equals(pass)) {
                    try {
                        Parent root = FXMLLoader.load((getClass().getResource("HomePage.fxml")));
                        Scene scene = new Scene(root);
                        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                        stage.setScene(scene);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Wrong password");
                    alert.setContentText("Please enter your password correctly!");
                    alert.showAndWait();
                }
            } else if (rs2.next()) {
                String pass = rs2.getString("password");
                if (pas.equals(pass)) {
                    try {
                        Parent root = FXMLLoader.load((getClass().getResource("HomePage.fxml")));
                        Scene scene = new Scene(root);
                        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                        stage.setScene(scene);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Wrong password");
                    alert.setContentText("Please enter your password correctly!");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Wrong email/password");
                alert.setContentText("Please enter your email and password correctly!");
                alert.showAndWait();
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        //--------------Chat system-------------------------//
//
//        Server.main(new String[]{"m"});




    }
    ////**----------------------------------------------------------------------------------------------------**////

}

/*

//---------new-----------//



import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.*;

public class LogInPageController {

    @FXML
    private TextField inputbox;

    @FXML
    private Button login;

    @FXML
    private PasswordField passwordbox;

    private String fullName;

    @FXML
    void goToSignUpPage(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    ////** Action event for going to home page from login page---------------------------------**////
 /*   @FXML
    void loginClickedByMouseClicked(MouseEvent event) {
        loginEventMethod(event);
    }

    @FXML
    void loginClickedByEnterKeyInPasswordeField(KeyEvent event) {
        passwordbox.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                loginEventMethod(e);
            }
        });
    }

    @FXML
    void loginClickedByEnterKeyInUsernameField(KeyEvent event) {
        inputbox.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                loginEventMethod(e);
            }
        });
    }

    // Method for going to home page from login page
    void loginEventMethod(Event event) {
        String input = inputbox.getText();
        String pas = passwordbox.getText();

        String url = "jdbc:mysql://127.0.0.1/musfiq";
        String username = "root";
        String password = "";

        System.out.println("Connecting database...");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");

            String query = "SELECT * FROM useraccounts WHERE email=? OR username=?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, input);
            statement.setString(2, input);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String pass = rs.getString("password");

                if (pas.equals(pass)) {
                    // User is authenticated, retrieve the full name
                    fullName = rs.getString("fullName");

                    try {
                        Parent root = FXMLLoader.load((getClass().getResource("HomePage.fxml")));
                        Scene scene = new Scene(root);
                        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                        stage.setScene(scene);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Wrong password");
                    alert.setContentText("Please enter your password correctly!");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Wrong email/username or password");
                alert.setContentText("Please enter your email/username and password correctly!");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
*/


