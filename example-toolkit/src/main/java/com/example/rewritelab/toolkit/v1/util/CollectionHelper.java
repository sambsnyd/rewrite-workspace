package com.example.rewritelab.toolkit.v1.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

/**
 * Collection utility methods using Guava.
 */
public final class CollectionHelper {

    private CollectionHelper() {
        // utility class
    }

    // Lists.newArrayList() variants
    public static <T> List<T> newList() {
        return Lists.newArrayList();
    }

    public static <T> List<T> newList(T... items) {
        return Lists.newArrayList(items);
    }

    public static <T> List<T> newListFrom(Iterable<T> iterable) {
        return Lists.newArrayList(iterable);
    }

    public static <T> List<T> newListWithCapacity(int capacity) {
        return Lists.newArrayListWithCapacity(capacity);
    }

    // ImmutableList
    public static <T> List<T> immutableCopy(Collection<T> source) {
        return ImmutableList.copyOf(source);
    }

    public static <T> List<T> immutableOf(T... items) {
        return ImmutableList.copyOf(items);
    }

    // raw type
    public static List rawList() {
        return Lists.newArrayList();
    }

    // TODO: Consider adding Map helper methods
    public static boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
