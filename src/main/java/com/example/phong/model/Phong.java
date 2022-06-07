package com.example.phong.model;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class Phong {
    public static double getIntensity(Triangle t) {
        /*
         * f * Ip * [kd * (N o L) + ks * cos(alpha) ^ n]
         * 
         * f = 1 / (c + r), c = const
         * Ip = natężenie punktowe (1)
         * 
         * kd = rozproszenie
         * N = wektor normalny do trójkąta
         * L = wektor skierowany do źródła światła
         * 
         * ks = kierunkowe
         * alpha = kąt między wektorem do obserwatora a
         * odbitym do światła - obserwator w 0, 0, 0
         * n = gładkość powierzchni
         */

        double f = Light.getLightDecay(t.getCenterPoint());
        double Ip = Light.INTENSITY;

        double kd = Scene.getDiffuse();
        Vector3D N = t.getNormalVector();
        Vector3D L = Light.getVectorFromPoint(t.getCenterPoint());

        double ks = Scene.getSpecular();

        Vector3D vectorToObserver = t.getCenterPoint().scalarMultiply(-1).normalize();
        double alpha = 0;
        double n = Scene.n;

        return f * Ip * (kd * N.dotProduct(L) + ks * Math.pow(Math.cos(alpha), n));
    }
}
