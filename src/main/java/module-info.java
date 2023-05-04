module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.web;
    requires javafx.swing;
    requires AnimateFX;
    requires javafx.graphics;
    requires MaterialFX;


    opens com.example.project to javafx.fxml;
    exports com.example.project;

}