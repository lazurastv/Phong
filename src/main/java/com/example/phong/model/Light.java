package com.example.phong.model;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class Light {
    public static final double INTENSITY = 1;
    public static final int DISTANCE_PER_MOVE = 10;
    public static Vector3D coords = new Vector3D(0, 0, 0);

    public static void move(int direction, int axis) {
        double x = coords.getX();
        double y = coords.getY();
        double z = coords.getZ();
        switch (axis) {
            case 0:
                x += direction * DISTANCE_PER_MOVE;
                break;
            case 1:
                y += direction * DISTANCE_PER_MOVE;
                break;
            case 2:
                z += direction * DISTANCE_PER_MOVE;
                break;
            default:
                System.out.println("Unsupported axis.");
        }
        coords = new Vector3D(x, y, z);
    }

    public static Vector3D getVectorFromPoint() {
        return null;
    }
}
