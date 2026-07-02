package com.example.rewritelab.toolkit.v1.util;

import java.util.List;

/**
 * Static string utility methods.
 */
public final class StringHelper {

    private StringHelper() {
        // utility class
    }

    // StringIsEmpty: str.length() == 0
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    // EqualsAvoidsNull: variable.equals("literal")
    public static boolean isDefaultValue(String str) {
        return str.equals("default");
    }

    // String concat in loop
    public static String join(List<String> items, String delimiter) {
        String result = "";
        for (int i = 0; i < items.size(); i++) {
            result = result + items.get(i);
            if (i < items.size() - 1) {
                result = result + delimiter;
            }
        }
        return result;
    }

    // StringIsEmpty
    public static String trimToEmpty(String str) {
        if (str == null) {
            return "";
        }
        String trimmed = str.trim();
        if (trimmed.length() == 0) {
            return "";
        }
        return trimmed;
    }

    // EqualsAvoidsNull
    public static boolean isBlank(String str) {
        return str == null || str.trim().equals("");
    }

    public static String capitalize(String str) {
        if (isEmpty(str)) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
