package com.example.rewritelab.toolkit.v2.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * v2 CollectionHelper — no Guava dependency, standard Java collections.
 *
 * <p>Migration notes from v1:
 * <ul>
 *   <li>{@code newList()} / {@code newList(T...)} replaced with {@link #mutableList()} / {@link #mutableListOf(Object[])}</li>
 *   <li>{@code newListFrom(Iterable)} replaced with {@link #mutableListFrom(Iterable)}</li>
 *   <li>{@code newListWithCapacity(int)} replaced with {@link #mutableListWithCapacity(int)}</li>
 *   <li>{@code immutableCopy(Collection)} replaced with {@link #unmodifiableCopy(Collection)} using {@code List.copyOf()}</li>
 *   <li>{@code immutableOf(T...)} replaced with {@link #unmodifiableOf(Object[])} using {@code List.of()}</li>
 *   <li>{@code rawList()} removed</li>
 * </ul>
 */
public final class CollectionHelper {

    private CollectionHelper() {
    }

    public static <T> List<T> mutableList() {
        return new ArrayList<>();
    }

    @SafeVarargs
    public static <T> List<T> mutableListOf(T... items) {
        List<T> list = new ArrayList<>(items.length);
        for (T item : items) {
            list.add(item);
        }
        return list;
    }

    public static <T> List<T> mutableListFrom(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    public static <T> List<T> mutableListWithCapacity(int capacity) {
        return new ArrayList<>(capacity);
    }

    public static <T> List<T> unmodifiableCopy(Collection<T> source) {
        return List.copyOf(source);
    }

    @SafeVarargs
    public static <T> List<T> unmodifiableOf(T... items) {
        return List.of(items);
    }

    public static boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
