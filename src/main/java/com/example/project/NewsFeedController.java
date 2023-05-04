package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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

import static com.example.project.Start.*;

public class NewsFeedController implements Initializable {
    ///*****...................... FX ID .........................*****/////

    @FXML
    private ScrollPane scrollablePaneforNewsfeed;
    @FXML
    private ScrollPane mainAnchorPaneInNewsfeed;

    ///*****........... ...........................................*****/////

    ///***........ Action Event For Showing Post Type Wise .............**///////
    @FXML
    void allPostActionEvent(ActionEvent event) {
        counterForShowingPostTypeWise = 0;
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
    void announcementActionEvent(ActionEvent event) {
        counterForShowingPostTypeWise = 1;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("NewsfeedForAnnouncement.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void contestAnnouncementActionEvent(ActionEvent event) {
        counterForShowingPostTypeWise = 2;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("NewsfeedForContestAnnouncement.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void queryActionEvent(ActionEvent event) {
        counterForShowingPostTypeWise = 3;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("NewsfeedForQuery.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    ///*****........... ...........................................*****/////

    @Override
    public void initialize(URL url1, ResourceBundle resourceBundle) {

        ArrayList<String> allPost = new ArrayList<>();

        ///*** ...................  Database to ArrayList ...........................*****////////
        // Connect to the database
        String url = "jdbc:mysql://127.0.0.1/musfiq";
        String user = "root";
        String password = "";
        System.out.println("Connecting database...");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // Execute a SELECT query
            String post = "SELECT post FROM allpost";
            PreparedStatement stmt = conn.prepareStatement(post);
            ResultSet rs = stmt.executeQuery();

            // Iterate over the ResultSet
            while (rs.next()) {
                String value = rs.getString("post");
                allPost.add(value);
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        ///*** ...................  .................. ...........................*****////////
        //System.out.println(allPost);
        ///*** ...................  ArrayList to newsfeedVBox ...........................*****////////

        // Create a VBox to hold the newsfeedVBox items
        VBox newsfeedVBox = new VBox();
        newsfeedVBox.setPrefSize(600,Region.USE_COMPUTED_SIZE);
        newsfeedVBox.setSpacing(10);
        newsfeedVBox.setPadding(new Insets(10));



        // Add some newsfeedVBox items
        for (int i = 0; i < allPost.size(); i++) {
            /**
             *  Name -> 0
             *  Post -> 1
             *  Link -> 2
             *  PostType -> 3
             */
            String[] postProperties = allPost.get(i).split("<separatorForUsername,Post,Link&PostType>");
            /**
             *  All -> 0
             *  Announcement -> 1
             *  Contest Announcement -> 2
             *  Query -> 3
             */
            if ((counterForShowingPostTypeWise == 1) && (!(postProperties[3].compareTo("Announcement") == 0))) {
                continue;
            } else if ((counterForShowingPostTypeWise == 2) && (!(postProperties[3].compareTo("ContestAnnouncement") == 0))) {
                continue;
            } else if ((counterForShowingPostTypeWise == 3) && (!(postProperties[3].compareTo("Query") == 0))) {
                continue;
            }

            VBox vBox = new VBox();
            vBox.setPrefSize(600, Region.USE_COMPUTED_SIZE);
            //vBox.maxHeight(Region.USE_COMPUTED_SIZE);

            Label name = new Label();
            name.setPrefSize(600, Region.USE_COMPUTED_SIZE);
            name.setText(postProperties[0]);
            name.setBackground(Background.fill(Color.WHITE));
            Font font1 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 12);
            name.setFont(font1);

            AnchorPane space = new AnchorPane();
            space.setPrefSize(600, 3);
            space.setBackground(Background.fill(Color.WHITE));

            Label mainPost = new Label();
            mainPost.setPrefSize(600, Region.USE_COMPUTED_SIZE);
            //mainPost.maxHeight(Region.USE_COMPUTED_SIZE);
            mainPost.setWrapText(true);
            mainPost.setText(postProperties[1]);
            mainPost.setBackground(Background.fill(Color.WHITE));
            Font font2 = Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 14);
            name.setFont(font1);

            vBox.getChildren().add(name);
            vBox.getChildren().add(space);
            vBox.getChildren().add(mainPost);

            if(!(postProperties[2].compareTo("null")==0)) {

                AnchorPane space1 = new AnchorPane();
                space1.setPrefSize(600, 2);
                space1.setBackground(Background.fill(Color.WHITE));

                //Button link = new Button();
                Label link = new Label();
                link.setPrefSize(600, Region.USE_COMPUTED_SIZE);
                link.setWrapText(true);
                link.setText(postProperties[2]);
                link.setTextAlignment(TextAlignment.LEFT);
                link.setBackground(Background.fill(Color.WHITE));
                Font font = Font.font("Arial", FontWeight.NORMAL, FontPosture.ITALIC, 12);
                link.setFont(font);
                link.setTextFill(Color.BLUE);

                vBox.getChildren().add(space1);
                vBox.getChildren().add(link);
            }

            // answer about query.............................................

            if(postProperties[3].compareTo("Query") == 0) {

                AnchorPane space2 = new AnchorPane();
                space2.setPrefSize(600, 3);
                //space2.setBackground(Background.fill(Color.WHITE));

                HBox hBox = new HBox();
                hBox.setPrefSize(600, 20);

                TextField space3 = new TextField();
                space3.setPrefSize(520, 20);
                space3.setBackground(Background.fill(Color.WHITE));

                Button answer = new Button();
                answer.setPrefSize(80, 20);
                answer.setText("Answer");
                Font font3 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 12);
                answer.setFont(font3);

                hBox.getChildren().add(space3);
                hBox.getChildren().add(answer);


                vBox.getChildren().add(space2);
                vBox.getChildren().add(hBox);
            }

            newsfeedVBox.getChildren().add(vBox);
        }

        // Create a ScrollPane to hold the newsfeedVBox
        scrollablePaneforNewsfeed.setContent(newsfeedVBox);
        scrollablePaneforNewsfeed.setFitToWidth(true);



        ///*** ...................  .................. ...........................*****////////
    }


    @FXML
    void creatPostButtonActionEvent(ActionEvent event) {
        String nextScene = null;
        if(currentUserType.compareTo("Student") == 0) {
            nextScene = "CreatPostPageForStudent.fxml";
        }
        else if (currentUserType.compareTo("Teacher") == 0) {
            nextScene = "CreatPostPageForTeacher.fxml";
        }
        try {
            Parent root = FXMLLoader.load(getClass().getResource(nextScene));
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

    public void LogOut(ActionEvent actionEvent) {

    }
}
