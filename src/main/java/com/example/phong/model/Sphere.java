package com.example.phong.model;

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
                        new Point(-100, 0, 100),
                        new Point(100, 0, 100),
                        new Point(0, -200, 100)) };
    }
}
