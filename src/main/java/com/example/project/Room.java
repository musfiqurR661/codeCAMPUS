//package com.example.project;
//
////import Client.Controller.*;
//import animatefx.animation.FadeIn;
//import javafx.embed.swing.SwingFXUtils;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.geometry.NodeOrientation;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.ImagePattern;
//import javafx.scene.shape.Circle;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.net.Socket;
//import java.net.URL;
//import java.util.ResourceBundle;
//
////import static Client.Controller.users;
//import static com.example.project.Start.*;
//
//
//public class Room extends Thread implements Initializable {
//
//    @FXML
//    public Pane chat;
//    @FXML
//    public TextField msgField;
//    @FXML
//    public TextArea msgRoom;
//
//
//    BufferedReader reader;
//    PrintWriter writer;
//    Socket socket;
//
//
//
//    public void connectSocket() {
//        try {
//            socket = new Socket("localhost", 8800);
//            System.out.println("Socket is connected with server!");
//            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            writer = new PrintWriter(socket.getOutputStream(), true);
//            this.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void run() {
//        try {
//            while (true) {
//                String msg = reader.readLine();
//                String[] tokens = msg.split(" ");
//                String cmd = tokens[0];
//                System.out.println(cmd);
//                StringBuilder fulmsg = new StringBuilder();
//                for(int i = 1; i < tokens.length; i++) {
//                    fulmsg.append(tokens[i]);
//                }
//                System.out.println(fulmsg);
////
//                if (cmd.equalsIgnoreCase(currentUserName + ":")) {
//                    msgRoom.appendText(msg.substring(currentUserName.length() + 2) + "\n");
//                    continue;
//                }
//                else if(fulmsg.toString().equalsIgnoreCase("bye")) {
//                    break;
//                }
//                msgRoom.appendText(msg + "\n");
//            }
//            reader.close();
//            writer.close();
//            socket.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public void handleSendEvent(MouseEvent event) {
//        send();
//        for(User user : users) {
//            System.out.println(user.name);
//        }
//    }
//
//
//    public void send() {
//
//        Start.chattingCounter = 0;
//        System.out.println(Start.chattingCounter);
//
//        String msg = msgField.getText();
//        writer.println(currentUserName + ": " + msg);
//        msgRoom.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
//        msgRoom.appendText("Me: " + msg + "\n");
//        msgField.setText("");
//        if(msg.equalsIgnoreCase("BYE") || (msg.equalsIgnoreCase("logout"))) {
//            System.exit(0);
//        }
//    }
//
//    // Changing profile pic
//
//    public boolean saveControl = false;
//
//    public void sendMessageByKey(KeyEvent event) {
//        if (event.getCode().toString().equals("ENTER")) {
//            send();
//        }
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//        this.connectSocket();
//    }
//
//
//    ///***.....................Noman ...............
//
//    @FXML
//    void gotoHomePage(ActionEvent event) {
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
//            Scene scene = new Scene(root);
//            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
//            stage.setScene(scene);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}


package com.example.project;

import animatefx.animation.FadeIn;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static com.example.project.Start.currentUserName;

public class Room extends Thread implements Initializable {

    @FXML
    public Pane chat;
    @FXML
    public TextField msgField;
    @FXML
    public TextArea msgRoom;


    BufferedReader reader;
    PrintWriter writer;
    Socket socket;

    public void connectSocket() {
        try {
            socket = new Socket("localhost", 8000);
            System.out.println("Socket is connected with server!");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String msg = reader.readLine();
                String[] tokens = msg.split("<separate>");
                String cmd = tokens[0];
                System.out.println(cmd);
                StringBuilder fulmsg = new StringBuilder();
                for(int i = 1; i < tokens.length; i++) {
                    fulmsg.append(tokens[i]);
                }
                System.out.println(fulmsg);
                if (cmd.equalsIgnoreCase(currentUserName)) {
                    continue;
                } else if(fulmsg.toString().equalsIgnoreCase("bye")) {
                    break;
                }
                msgRoom.appendText(tokens[0] +": " + tokens[1]+"\n");
            }
            reader.close();
            writer.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleSendEvent(MouseEvent event) {
        send();
    }

    public void send() {
        String msg = msgField.getText();
        writer.println(currentUserName + "<separate>" + msg);
        msgRoom.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        if (!msg.startsWith(currentUserName + ":")) {
            msgRoom.appendText("Me: " + msg + "\n");
        }
        msgField.setText("");
        if (msg.equalsIgnoreCase("BYE") || (msg.equalsIgnoreCase("logout"))) {
            System.exit(0);
        }

        //............ Message store in database ...............///
        System.out.println(msg);
        if(msg.length() == 0) msg = "<null>";
        System.out.println(msg);
        String message = currentUserName + "<separate>" + msg;

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

            pst = con.prepareStatement("INSERT INTO messages(Message) VALUES(?)");
            pst.setString(1, message);
            pst.execute();
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    public boolean saveControl = false;

    public void sendMessageByKey(KeyEvent event) {
        if (event.getCode().toString().equals("ENTER")) {
            send();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.connectSocket();

        //............ Message retrieve from database ...............///

        // Connect to the database
        String url = "jdbc:mysql://127.0.0.1/musfiq";
        String user = "root";
        String password = "";
        System.out.println("Connecting database...");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // Execute a SELECT query
//            String msg = "SELECT Message FROM messages";
//            PreparedStatement stmt = conn.prepareStatement(msg);

            ResultSet rs = conn.prepareStatement("SELECT Message FROM messages").executeQuery();

            // Iterate over the ResultSet
            while (rs.next()) {
                String[] message = rs.getString("Message").split("<separate>");

                String cmd = message[0];
//                StringBuilder fulmsg = new StringBuilder();
//                for(int i = 1; i < message.length; i++) {
//                    fulmsg.append(message[i]);
//                }
//                System.out.println(fulmsg);
                if (cmd.equalsIgnoreCase(currentUserName)) {
                    if(!(message[1].compareTo("<null>")==0)){
                        msgRoom.appendText("Me" +": " + message[1]+"\n");
                    }
                    else {
                        msgRoom.appendText("Me" +": " +"\n");
                    }
                    continue;
                }
//                else if(fulmsg.toString().equalsIgnoreCase("bye")) {
//                    break;
//                }
                if(!(message[1].compareTo("<null>")==0)) {
                    msgRoom.appendText(message[0] +": " + message[1]+"\n");
                }
                else {
                    msgRoom.appendText(message[0] +": " +"\n");
                }


            }

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

    }

    @FXML
    void gotoHomePage(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
