package com.example.phong.model;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class Phong {
    private static Vector3D getReflectionVector(Triangle t) {
        Vector3D center = t.getCenterPoint();
        Vector3D normalVector = t.getNormalVector();

        RealMatrix normalMatrix = new Array2DRowRealMatrix(
                new double[] { normalVector.getX(), normalVector.getY(), normalVector.getZ() });
        normalMatrix = normalMatrix.transpose();
        RealMatrix centerMatrix = new Array2DRowRealMatrix(
                new double[] { center.getX(), center.getY(), center.getZ() });
        double D = normalMatrix.multiply(centerMatrix).getEntry(0, 0);

        Vector3D coords = Light.coords;
        Vector3D vectorToLight = coords.subtract(center).normalize();
        Vector3D extensionOfLightVector = center.subtract(vectorToLight);
        RealMatrix extensionMatrix = new Array2DRowRealMatrix(
                new double[] { extensionOfLightVector.getX(), extensionOfLightVector.getY(),
                        extensionOfLightVector.getZ() });
        double scaleNormal = normalMatrix.multiply(extensionMatrix).getEntry(0, 0) - D;
        Vector3D reflectionPoint = extensionOfLightVector.subtract(normalVector.scalarMultiply(scaleNormal * 2));

        return reflectionPoint.subtract(center);
    }

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

        Vector3D center = t.getCenterPoint();
        double f = 1;// Light.getLightDecay(center);
        double Ip = Light.INTENSITY;

        double kd = Scene.getDiffuse();
        Vector3D N = t.getNormalVector();
        Vector3D L = Light.getVectorFromPoint(center);

        double ks = Scene.getSpecular();
        Vector3D reflecedVector = getReflectionVector(t);
        Vector3D vectorToObserver = center.scalarMultiply(-1).normalize();
        double alpha = Vector3D.angle(vectorToObserver, reflecedVector);
        double n = Scene.n;

        return f * Ip * (kd * N.dotProduct(L) + ks * Math.pow(Math.cos(alpha), n));
    }
}
