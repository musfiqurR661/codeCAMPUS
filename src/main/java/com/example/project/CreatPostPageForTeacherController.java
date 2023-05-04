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
import javafx.scene.layout.Background;
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

//import static com.example.project.Start.allPost;
import static com.example.project.Start.counterForShowingPostTypeWise;
import static com.example.project.Start.currentUserName;

public class CreatPostPageForTeacherController implements Initializable {

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
        newsfeedVBox.setPrefSize(600, Region.USE_COMPUTED_SIZE);
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

            Label mainPost = new Label();
            mainPost.setPrefSize(600, Region.USE_COMPUTED_SIZE);
            //mainPost.maxHeight(Region.USE_COMPUTED_SIZE);
            mainPost.setWrapText(true);
            mainPost.setText(postProperties[1]);
            mainPost.setBackground(Background.fill(Color.WHITE));
            Font font2 = Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 14);
            name.setFont(font1);

            vBox.getChildren().add(name);
            vBox.getChildren().add(mainPost);

            if(!(postProperties[2].compareTo("null")==0)) {
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
                vBox.getChildren().add(link);
            }

            newsfeedVBox.getChildren().add(vBox);
        }

        // Create a ScrollPane to hold the newsfeedVBox
        scrollablePaneforCreatPostPageForTeacher.setContent(newsfeedVBox);
        scrollablePaneforCreatPostPageForTeacher.setFitToWidth(true);

        ///*** ...................  .................. ...........................*****////////
    }

    ////*****................................****////

    @FXML
    private RadioButton postTypeAnnouncement;

    @FXML
    private RadioButton postTypeContestAnnouncement;

    @FXML
    private ScrollPane scrollablePaneforCreatPostPageForTeacher;

    @FXML
    private TextArea textAreaForCreatingPostForTeacher;

    @FXML
    private TextArea textAreaForSharingLinkForTeacher;

    @FXML
    private ToggleGroup postTypeGroup;

    @FXML
    void initialize() {
        postTypeGroup = new ToggleGroup();
        postTypeAnnouncement.setToggleGroup(postTypeGroup);
        postTypeContestAnnouncement.setToggleGroup(postTypeGroup);
    }


    ////*****................................****////

    ////********* Creat Post  ......................................................................****///////

    @FXML
    void creatPostActionEvent(ActionEvent event) {

        //------------------Handel post type ------------------//
        String postType = null;
        if (postTypeAnnouncement.isSelected()) {
            postType = "Announcement";
        } else if (postTypeContestAnnouncement.isSelected()) {
            postType = "ContestAnnouncement";
        }
        //
        String post = currentUserName + "<separatorForUsername,Post,Link&PostType>" + textAreaForCreatingPostForTeacher.getText()
                + "<separatorForUsername,Post,Link&PostType>"+ textAreaForSharingLinkForTeacher.getText()
                + "<separatorForUsername,Post,Link&PostType>" + postType;
        //

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
        try {
            con = DriverManager.getConnection(url, username, password);

            pst = con.prepareStatement("INSERT INTO allpost(post) VALUES(?)");
            pst.setString(1, post);
            pst.execute();
        } catch (Exception e) {
            e.getStackTrace();
        }
        //




        try {
            Parent root = FXMLLoader.load(getClass().getResource("newsFeed01.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //////*****........................................*****///////

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
    void gotoContestPage(ActionEvent event) {

    }

    @FXML
    void gotoHomePage(ActionEvent event) {

    }

    @FXML
    void gotoLearningPortal(ActionEvent event) {

    }
    @FXML
    void gotoStudentsPortal(ActionEvent event) {

    }

    @FXML
    void gotoTeachersPortal(ActionEvent event) {

    }


}
