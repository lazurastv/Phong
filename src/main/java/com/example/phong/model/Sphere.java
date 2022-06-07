package com.example.phong.model;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.ArrayList;
import java.util.List;

public class Sphere {

    private double r = 200;
    /**
     * Returns array of triangles that are arranged in a sphere
     * 
     * @param n Square root of amount of triangles that make up the sphere
     * @return The triangles
     */
    public Triangle[] getTriangles(int n) {
        Vector3D[][] points = new Vector3D[n][n+1];
        for (int i = 1; i < n; i++) {
            double longitude = map(i, n, 0, Math.PI);
            for (int j = 0; j < n+1; j++) {
                double latitude = map(j, n, 0, Math.PI);
                double x = r * Math.sin(longitude) * Math.cos(latitude);
                double y = r * Math.cos(longitude);
                double z = r * Math.sin(longitude) * Math.sin(latitude);
                points[i][j] = new Vector3D(x, y, z);
            }
        }

        List<Triangle> trianglesList = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < n ; j++) {
                trianglesList.add(new Triangle(points[i][j], points[i + 1][j], points[i][j + 1]));
                trianglesList.add(new Triangle(points[i + 1][j], points[i][j + 1], points[i + 1][j + 1]));
            }
        }

        for (int j = 0; j < n ; j++) {
            trianglesList.add(new Triangle(new Vector3D(0, r, 0),points[1][j], points[1][j+1]));
            trianglesList.add(new Triangle(new Vector3D(0, -r, 0),points[n-1][j], points[n-1][j+1]));
        }

        Triangle[] triangles = new Triangle[trianglesList.size()];
        trianglesList.toArray(triangles);
        return triangles;
    }

    private double map(int index, int samples, double x1, double x2) {
        double sampleLength = (x2 - x1) / samples;
        return x1 + index * sampleLength;
    }
}
