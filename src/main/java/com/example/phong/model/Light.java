package com.example.phong.model;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class Light {
    public static final double C = 5;
    public static final double INTENSITY = 5;
    public static final int DISTANCE_PER_MOVE = 10;
    public static Vector3D coords = new Vector3D(0, 0, 500);

    public static void move(int direction, int axis) {
        coords = coords.add(
                new Vector3D(
                        axis == 0 ? 1 : 0,
                        axis == 1 ? 1 : 0,
                        axis == 2 ? 1 : 0)
                        .scalarMultiply(direction * DISTANCE_PER_MOVE));
    }

    public static Vector3D getVectorFromPoint(Vector3D point) {
        return point.subtract(coords).normalize();
    }

    public static double getLightDecay(Vector3D point) {
        return 1 / (C + coords.distance(point));
    }
}
