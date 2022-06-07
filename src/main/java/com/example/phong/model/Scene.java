package com.example.phong.model;

import javafx.scene.canvas.GraphicsContext;

public class Scene {
    private static double specular = 1;
    private static double diffuse = 1;

    public static void draw(GraphicsContext g) {
        for (Triangle t : new Sphere().getTriangles(16)) {
            double intensity = Phong.getIntensity(t);
            t.draw(g, (int) (intensity * 255));
        }
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
