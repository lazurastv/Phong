package com.example.phong.model;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class Phong {
    public static double getIntensity(Triangle t) {
        Vector3D center = t.getCenterPoint();
        double f = 1; // Light.getLightDecay(center);
        double Ip = Light.INTENSITY;

        double kd = Scene.getDiffuse();
        Vector3D N = t.getNormalVector();
        Vector3D L = Light.getVectorFromPoint(center);

        double ks = Scene.getSpecular();
        Vector3D R = N.scalarMultiply(2 * N.dotProduct(L)).subtract(L).normalize();
        Vector3D V = center.scalarMultiply(-1).normalize();

        return f * Ip * (kd * N.dotProduct(L) + ks * Math.pow(V.dotProduct(R), Scene.n));
    }
}
