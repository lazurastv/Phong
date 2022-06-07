package com.example.phong;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.phong.controller.Controller;
import com.example.phong.view.View;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        View view = new View();
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(new Controller(view));
        root.getChildren().add(view);
        stage.setTitle("Phong model");
        stage.setScene(scene);
        view.draw();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}