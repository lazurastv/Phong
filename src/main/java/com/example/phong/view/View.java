package com.example.phong.view;

import com.example.phong.model.Scene;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class View extends Canvas {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public View() {
        super(WIDTH, HEIGHT);
    }

    public void draw() {
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        Scene.draw(gc);
    }
}
