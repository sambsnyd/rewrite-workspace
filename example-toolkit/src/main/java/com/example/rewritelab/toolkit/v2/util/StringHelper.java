package com.example.rewritelab.toolkit.v2.util;

import java.util.Optional;

/**
 * v2 StringHelper — Optional returns, renamed methods.
 *
 * <p>Migration notes from v1:
 * <ul>
 *   <li>{@code isEmpty(String)} removed; use {@code String.isEmpty()} or {@link #isNullOrBlank(String)}</li>
 *   <li>{@code isBlank(String)} renamed to {@link #isNullOrBlank(String)}</li>
 *   <li>{@code isDefaultValue(String)} renamed to {@link #isDefault(String)}</li>
 *   <li>{@code trimToEmpty(String)} now returns {@code Optional<String>} via {@link #trimToOptional(String)}</li>
 *   <li>{@code join(List, String)} removed; use {@code String.join()} directly</li>
 * </ul>
 */
public final class StringHelper {

    private StringHelper() {
    }

    /** Renamed from v1 {@code isBlank}. */
    public static boolean isNullOrBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    /** Renamed from v1 {@code isDefaultValue}. */
    public static boolean isDefault(String str) {
        return "default".equals(str);
    }

    /**
     * Replaces v1 {@code trimToEmpty}. Returns {@code Optional.empty()} for null/blank input.
     */
    public static Optional<String> trimToOptional(String str) {
        if (str == null) {
            return Optional.empty();
        }
        String trimmed = str.trim();
        if (trimmed.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(trimmed);
    }

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
