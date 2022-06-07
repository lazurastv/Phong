package com.example.phong.model;

import com.example.phong.view.View;

import javafx.scene.canvas.GraphicsContext;

public class Scene {
    private static double specular = 1;
    private static double diffuse = 1;
    public static final double n = 5;

    public static void draw(GraphicsContext g) {
        double min = 1;
        double max = -1;
        for (Triangle t : new Sphere(0, 0, 300, 100).getTriangles(30)) {
            double intensity = Phong.getIntensity(t);
            if (intensity < min) {
                min = intensity;
            }
            if (intensity > max) {
                max = intensity;
            }
            t.draw(g, (int) ((2 + Math.min(Math.max(-2, intensity), 2)) * 255 / 4));
        }
        System.out.println(min + " " + max);
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
