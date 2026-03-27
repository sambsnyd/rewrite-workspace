package com.example.rewritelab.toolkit.v2.pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * v2 ServiceRegistry — instance-based (no singleton), typed, modern collections.
 *
 * <p>Migration notes from v1:
 * <ul>
 *   <li>No longer a singleton; create with {@code new ServiceRegistry()}</li>
 *   <li>{@code Hashtable} replaced with {@code HashMap}</li>
 *   <li>{@code Vector<String>} replaced with {@code List<String>}</li>
 *   <li>{@code getService(String)} now returns typed {@code <T>}</li>
 *   <li>{@code getServiceCount()} returns {@code int} not {@code Integer}</li>
 *   <li>{@code listServices()} removed; use {@link #getServiceNames()} and iterate</li>
 * </ul>
 */
public class ServiceRegistry {

    private final Map<String, Object> services;
    private final List<String> serviceNames;

    public ServiceRegistry() {
        this.services = new HashMap<>();
        this.serviceNames = new ArrayList<>();
    }

    public void register(String name, Object service) {
        services.put(name, service);
        if (!serviceNames.contains(name)) {
            serviceNames.add(name);
        }
    }

    /** Now returns typed result via unchecked cast. */
    @SuppressWarnings("unchecked")
    public <T> T getService(String name) {
        return (T) services.get(name);
    }

    /** Returns primitive {@code int}. v1 returned {@code Integer}. */
    public int getServiceCount() {
        return services.size();
    }

    /** Returns unmodifiable List. v1 returned {@code Vector<String>}. */
    public List<String> getServiceNames() {
        return Collections.unmodifiableList(serviceNames);
    }

    public boolean hasService(String name) {
        return services.containsKey(name);
    }

    public void clear() {
        services.clear();
        serviceNames.clear();
    }
}
