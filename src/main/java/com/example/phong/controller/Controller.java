package com.example.phong.controller;

import com.example.phong.model.Scene;
import com.example.phong.model.SceneType;
import com.example.phong.view.View;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Controller implements EventHandler<KeyEvent> {

    private final View view;

    public Controller(View view) {
        this.view = view;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case D:
                Scene.loadScene(SceneType.DREWNO);
                break;
            case K:
                Scene.loadScene(SceneType.KREDA);
                break;
            case M:
                Scene.loadScene(SceneType.METAL);
                break;
            case P:
                Scene.loadScene(SceneType.PLASTIK);
                break;
            default:
                System.out.println("Key not used.");
        }

        view.draw();
    }
}