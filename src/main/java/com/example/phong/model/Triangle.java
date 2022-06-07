package com.example.phong.model;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import com.example.phong.view.View;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle {
    public Vector3D[] vertices;

    public Triangle(Vector3D a, Vector3D b, Vector3D c) {
        this.vertices = new Vector3D[] { a, b, c };
    }

    public double[] getX() {
        return new double[] { vertices[0].getX(), vertices[1].getX(), vertices[2].getX() };
    }

    public double[] getY() {
        return new double[] { vertices[0].getY(), vertices[1].getY(), vertices[2].getY() };
    }

    public double[] getZ() {
        return new double[] { vertices[0].getZ(), vertices[1].getZ(), vertices[2].getZ() };
    }

    public Vector3D getCenterPoint() {
        double x = 0, y = 0, z = 0;
        for (Vector3D vector : vertices) {
            x += vector.getX();
            y += vector.getY();
            z += vector.getZ();
        }
        return new Vector3D(x / 3, y / 3, z / 3);
    }

    public Vector3D getNormalVector() {
        double[] xs = getX();
        double[] ys = getY();
        double[] zs = getZ();
        Vector3D edge1 = new Vector3D(xs[0] - xs[1], ys[0] - ys[1], zs[0] - zs[1]);
        Vector3D edge2 = new Vector3D(xs[1] - xs[2], ys[1] - ys[2], zs[1] - zs[2]);
        return edge1.crossProduct(edge2).normalize();
    }

    private double[] center(double[] values, boolean x) {
        for (int i = 0; i < values.length; i++) {
            values[i] += x ? View.WIDTH / 2 : View.HEIGHT / 2;
        }
        return values;
    }

    public void draw(GraphicsContext g, int intensity) {
        g.beginPath();
        g.setFill(Color.rgb(intensity, intensity, intensity));
        g.fillPolygon(center(getX(), true), center(getY(), false), 3);
        g.closePath();
    }
}
