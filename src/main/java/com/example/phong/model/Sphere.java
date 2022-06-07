package com.example.phong.model;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class Sphere {
    /**
     * Returns array of triangles that are arranged in a sphere
     * 
     * @param count Amount of triangles that make up the sphere
     * @return The triangles
     */
    public Triangle[] getTriangles(int count) {
        return new Triangle[] {
                new Triangle(
                        new Vector3D(-100, 0, 100),
                        new Vector3D(100, 0, 100),
                        new Vector3D(0, -200, 100)) };
    }
}
