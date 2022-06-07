package com.example.phong.model;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.ArrayList;
import java.util.List;

public class Sphere {

    private double centerX = 0;
    private double centerY = 0;
    private double centerZ = 0;
    private double r = 250;

    public Sphere() {}

    public Sphere(double r) {
        this.r = r;
    }

    public Sphere(double centerX, double centerY, double centerZ, double r) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.centerZ = centerZ;
        this.r = r;
    }

    /**
     * Returns array of triangles that are arranged in a sphere
     * 
     * @param n Square root of amount of triangles that make up the sphere
     * @return The triangles
     */
    public Triangle[] getTriangles(int n) {
        Vector3D[][] points = new Vector3D[n][n + 1];
        for (int i = 1; i < n; i++) {
            double longitude = map(i, n, 0, Math.PI);
            for (int j = 0; j < n+1; j++) {
                double latitude = map(j, n, 0, Math.PI);
                double x = centerX + r * Math.sin(longitude) * Math.cos(latitude);
                double y = centerY + r * Math.cos(longitude);
                double z = centerZ + r * Math.sin(longitude) * Math.sin(latitude);
                points[i][j] = new Vector3D(x, y, z);
            }
        }

        List<Triangle> trianglesList = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < n ; j++) {
                trianglesList.add(new Triangle(points[i][j], points[i + 1][j], points[i][j + 1]));
                trianglesList.add(new Triangle(points[i + 1][j], points[i + 1][j + 1], points[i][j + 1]));
            }
        }

        for (int j = 0; j < n ; j++) {
            trianglesList.add(new Triangle(new Vector3D(centerX, centerY + r, centerZ),points[1][j], points[1][j+1]));
            trianglesList.add(new Triangle(new Vector3D(centerX, centerY - r, centerZ),points[n - 1][j + 1], points[n - 1][j]));
        }

        Triangle[] triangles = new Triangle[trianglesList.size()];
        trianglesList.toArray(triangles);
        return triangles;
    }

    private double map(int index, int samples, double x1, double x2) {
        double sampleLength = (x2 - x1) / samples;
        return x1 + index * sampleLength;
    }

    public static void main(String[] args) {

    }
}
