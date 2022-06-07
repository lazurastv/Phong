module com.example.phong {
    requires javafx.controls;
    requires javafx.fxml;
    requires commons.math3;

    opens com.example.phong to javafx.fxml;

    exports com.example.phong;
    exports com.example.phong.controller;

    opens com.example.phong.controller to javafx.fxml;
}