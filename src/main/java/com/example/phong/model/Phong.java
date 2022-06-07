package com.example.phong.model;

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
         * odbitym do światła
         * n = gładkość powierzchni
         */
        return 0;
    }
}
