package com.example.project;
/*
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AutoTypingText extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        String text = "This is a sample auto-typing text.";
        Label label = new Label();
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.show();

        // set up timeline for the auto-typing effect
        Timeline timeline = new Timeline();
        for (int i = 0; i < text.length(); i++) {
            final int index = i;
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(i * 0.2), e -> {
                        label.setText(text.substring(0, index + 1));
                    },
                            new KeyValue(label.opacityProperty(), 1))
            );
        }
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

 */


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AutoTypingText extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        String text1 = "This is a sample auto-typing text.";
        String text2 = "This is the second string.";
        Label label = new Label();
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.show();

        // set up timeline for the auto-typing effect
        Timeline timeline = new Timeline();

        // print the first string
        for (int i = 0; i < text1.length(); i++) {
            final int index = i;
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(i * 0.2), e -> {
                        label.setText(text1.substring(0, index + 1));
                    }, new KeyValue(label.opacityProperty(), 1))
            );
        }

        // remove the first string
        for (int i = text1.length(); i >= 0; i--) {
            final int index = i;
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(text1.length() * 0.2 + (text1.length() - i) * 0.1), e -> {
                        label.setText(text1.substring(0, index));
                    }, new KeyValue(label.opacityProperty(), 1))
            );
        }

        // print the second string
        for (int i = 0; i < text2.length(); i++) {
            final int index = i;
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(text1.length() * 0.2 + text1.length() * 0.1 + i * 0.2), e -> {
                        label.setText(text2.substring(0, index + 1));
                    }, new KeyValue(label.opacityProperty(), 1))
            );
        }

        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
