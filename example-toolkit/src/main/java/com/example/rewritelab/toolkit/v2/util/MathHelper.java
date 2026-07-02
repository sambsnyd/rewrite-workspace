package com.example.rewritelab.toolkit.v2.util;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/**
 * v2 MathHelper — Optional returns instead of boxed-with-default pattern.
 *
 * <p>Migration notes from v1:
 * <ul>
 *   <li>{@code parseIntSafe(String, int)} replaced with {@link #parseInt(String)} returning {@code OptionalInt}</li>
 *   <li>{@code parseLongSafe(String, long)} replaced with {@link #parseLong(String)} returning {@code OptionalLong}</li>
 *   <li>{@code parseDoubleSafe(String, double)} replaced with {@link #parseDouble(String)} returning {@code OptionalDouble}</li>
 *   <li>{@code isPositive(int)} removed (trivial)</li>
 *   <li>{@code average(int[])} now returns {@code OptionalDouble}</li>
 * </ul>
 */
public final class MathHelper {

    private MathHelper() {
    }

    /** Replaces v1 {@code parseIntSafe(String, int)}. */
    public static OptionalInt parseInt(String value) {
        try {
            return OptionalInt.of(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            return OptionalInt.empty();
        }
    }

    /** Replaces v1 {@code parseLongSafe(String, long)}. */
    public static OptionalLong parseLong(String value) {
        try {
            return OptionalLong.of(Long.parseLong(value));
        } catch (NumberFormatException e) {
            return OptionalLong.empty();
        }
    }

    /** Replaces v1 {@code parseDoubleSafe(String, double)}. */
    public static OptionalDouble parseDouble(String value) {
        try {
            return OptionalDouble.of(Double.parseDouble(value));
        } catch (NumberFormatException e) {
            return OptionalDouble.empty();
        }
    }

    public static int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    /** Now returns {@code OptionalDouble.empty()} for null/empty input. v1 returned {@code 0.0}. */
    public static OptionalDouble average(int[] values) {
        if (values == null || values.length == 0) {
            return OptionalDouble.empty();
        }
        int sum = 0;
        for (int v : values) {
            sum += v;
        }
        return OptionalDouble.of((double) sum / values.length);
    }
}
