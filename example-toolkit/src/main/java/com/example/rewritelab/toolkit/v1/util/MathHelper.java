package com.example.rewritelab.toolkit.v1.util;

/**
 * Arithmetic utility methods with boxing smells.
 */
public final class MathHelper {

    private MathHelper() {
        // utility class
    }

    // new Integer() boxing
    public static Integer parseIntSafe(String value, int defaultValue) {
        try {
            return new Integer(value);
        } catch (NumberFormatException e) {
            return new Integer(defaultValue);
        }
    }

    // new Long() boxing
    public static Long parseLongSafe(String value, long defaultValue) {
        try {
            return new Long(value);
        } catch (NumberFormatException e) {
            return new Long(defaultValue);
        }
    }

    // new Double() boxing
    public static Double parseDoubleSafe(String value, double defaultValue) {
        try {
            return new Double(value);
        } catch (NumberFormatException e) {
            return new Double(defaultValue);
        }
    }

    // SimplifyTernary
    public static boolean isPositive(int value) {
        return value > 0 ? true : false;
    }

    public static int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    public static double average(int[] values) {
        if (values == null || values.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int v : values) {
            sum += v;
        }
        return (double) sum / values.length;
    }
}
