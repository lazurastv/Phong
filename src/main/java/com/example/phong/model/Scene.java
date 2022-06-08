package com.example.phong.model;

import com.example.phong.view.View;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Scene {
    private static double specular = 1;
    private static double diffuse = 1;
    public static final double n = 5;
    private static int[] color = new int[]{125, 125, 125};
    private static int sphereRows = 10;

    public static void draw(GraphicsContext g) {
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, View.WIDTH, View.HEIGHT);
        for (Triangle t : new Sphere(0, 0, 500, 200).getTriangles(sphereRows)) {
            double intensity = Phong.getIntensity(t);
            t.draw(g, calculateColor(intensity / 15));
        }
        g.setStroke(Color.YELLOW);
        g.strokeOval(
                View.WIDTH / 2 + Light.coords.getX() - 5,
                View.HEIGHT / 2 + Light.coords.getY() - 5,
                10,
                10);

        g.setStroke(Color.WHITE);
        g.strokeText(Integer.toString(sphereRows), View.WIDTH - 20, View.HEIGHT - 5);
    }

    private static int[] calculateColor(double intensity) {
        int start= 50;
        return new int[] {(int)(color[0] * start / 255 + color[0] * intensity),
                (int)(color[1] * start / 255 +  color[1] * intensity),
                (int)(color[2] * start / 255 + color[2] * intensity)};
    }

    public static void addToSphereRowsNumber(int value) {
        if (sphereRows + value < 3 || sphereRows + value > 100) {
            return;
        }
        sphereRows += value;
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
                color = new int[]{121, 87, 53};
                break;
            case KREDA:
                specular = 0;
                diffuse = 1;
                color = new int[]{200, 200, 0};
                break;
            case METAL:
                specular = 1;
                diffuse = 0;
                color = new int[]{200, 200, 255};
                break;
            case PLASTIK:
                specular = 0.2;
                diffuse = 0.8;
                color = new int[]{255, 255, 255};
                break;
            default:
                System.out.println("Unused scene type.");
                break;
        }
    }
}
