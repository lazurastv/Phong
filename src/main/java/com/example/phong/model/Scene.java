package com.example.phong.model;

import com.example.phong.view.View;

import javafx.scene.canvas.GraphicsContext;

public class Scene {
    private static double specular = 1;
    private static double diffuse = 1;
    public static final double n = 5;

    public static void draw(GraphicsContext g) {
        for (Triangle t : new Sphere().getTriangles(16)) {
            double intensity = Phong.getIntensity(t);
            t.draw(g, (int) (intensity * 255));
        }
        g.strokeOval(
                View.WIDTH / 2 + Light.coords.getX() - 5,
                View.HEIGHT / 2 + Light.coords.getY() - 5,
                10,
                10);
    }

    public static double getSpecular() {
        return specular;
    }

    public static double getDiffuse() {
        return diffuse;
    }

    public static void loadScene(SceneType scene) {
        switch (scene) {
            case DREWNO:
                specular = 0.8;
                diffuse = 0.2;
                break;
            case KREDA:
                specular = 0;
                diffuse = 1;
                break;
            case METAL:
                specular = 1;
                diffuse = 0;
                break;
            case PLASTIK:
                specular = 0.2;
                diffuse = 0.8;
                break;
            default:
                System.out.println("Unused scene type.");
                break;
        }
    }
}
