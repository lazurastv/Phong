package com.example.phong.model;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class Phong {
    public static double getIntensity(Triangle t) {
        Vector3D center = t.getCenterPoint();
        double f = 1; // Light.getLightDecay(center);
        double Ip = Light.INTENSITY;

        double kd = Scene.getDiffuse();
        Vector3D N = t.getNormalVector();
        Vector3D L = Light.getVectorFromPoint(center);

        double ks = Scene.getSpecular();
        Vector3D R = N.scalarMultiply(2 * L.dotProduct(N)).subtract(L).normalize();
        Vector3D V = center.scalarMultiply(-1).normalize();

        return f * Ip * (kd * Math.max(L.dotProduct(N), 0) + ks * Math.pow(Math.max(R.dotProduct(V), 0), Scene.n));
    }
}
