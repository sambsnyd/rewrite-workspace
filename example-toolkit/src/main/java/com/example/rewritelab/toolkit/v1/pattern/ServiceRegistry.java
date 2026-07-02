package com.example.rewritelab.toolkit.v1.pattern;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Singleton service registry using legacy collections.
 */
public class ServiceRegistry {

    private static final ServiceRegistry INSTANCE = new ServiceRegistry();

    // Hashtable and Vector are deliberate legacy collection smells
    private Hashtable<String, Object> services;
    private Vector<String> serviceNames;

    private ServiceRegistry() {
        services = new Hashtable<>();
        serviceNames = new Vector<>();
    }

    public static ServiceRegistry getInstance() {
        return INSTANCE;
    }

    public void register(String name, Object service) {
        services.put(name, service);
        if (!serviceNames.contains(name)) {
            serviceNames.add(name);
        }
    }

    public Object getService(String name) {
        return services.get(name);
    }

    // UseIntegerValueOf
    public Integer getServiceCount() {
        return new Integer(services.size());
    }

    // Enumeration iteration
    public void listServices() {
        Enumeration<String> keys = services.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println("Service: " + key + " -> " + services.get(key).getClass().getSimpleName());
        }
    }

    public Vector<String> getServiceNames() {
        return serviceNames;
    }

    public void clear() {
        services.clear();
        serviceNames.clear();
    }
}
