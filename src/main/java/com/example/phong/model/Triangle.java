package com.example.phong.model;

import com.example.phong.view.View;

import javafx.scene.canvas.GraphicsContext;

public class Triangle {

    public Point[] vertices;

    public Triangle(Point a, Point b, Point c) {
        this.vertices = new Point[] { a, b, c };
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

    public double[] center(double[] values, boolean x) {
        for (int i = 0; i < values.length; i++) {
            values[i] += x ? View.WIDTH / 2 : View.HEIGHT / 2;
        }
        return values;
    }

    public void draw(GraphicsContext g) {
        g.beginPath();
        g.strokePolygon(center(getX(), true), center(getY(), false), 3);
        g.closePath();
    }
}
