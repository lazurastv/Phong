package com.example.phong.controller;

import com.example.phong.model.Light;
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
            case W:
                Light.move(-1, 2);
                break;
            case S:
                Light.move(1, 2);
                break;
            case A:
                Light.move(-1, 0);
                break;
            case D:
                Light.move(1, 0);
                break;
            case SPACE:
                Light.move(-1, 1);
                break;
            case SHIFT:
            case C:
                Light.move(1, 1);
                break;
            case R:
                Scene.loadScene(SceneType.DREWNO);
                System.out.println("Wybrano: Drewno");
                break;
            case K:
                Scene.loadScene(SceneType.KREDA);
                System.out.println("Wybrano: Kreda");
                break;
            case M:
                Scene.loadScene(SceneType.METAL);
                System.out.println("Wybrano: Metal");
                break;
            case P:
                Scene.loadScene(SceneType.PLASTIK);
                System.out.println("Wybrano: Plastik");
                break;
            case Y:
                Scene.addToSphereRowsNumber(1);
                break;
            case H:
                Scene.addToSphereRowsNumber(-1);
                break;
            default:
                System.out.println("Key not used.");
        }

        view.draw();
    }
}