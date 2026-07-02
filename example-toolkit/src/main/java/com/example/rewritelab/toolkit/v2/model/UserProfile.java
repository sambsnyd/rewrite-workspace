package com.example.rewritelab.toolkit.v2.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * v2 UserProfile — fluent setters, typed roles, java.time.
 *
 * <p>Migration notes from v1:
 * <ul>
 *   <li>Setters now return {@code this} for fluent chaining</li>
 *   <li>{@code Date createdAt} replaced with {@code Instant createdAt}</li>
 *   <li>{@code List roles} (raw) replaced with {@code List<String> roles}</li>
 *   <li>{@code roleSummary()} now uses StringJoiner internally</li>
 * </ul>
 */
public class UserProfile {

    private String name;
    private String email;
    private int age;
    private Instant createdAt;
    private List<String> roles;

    public UserProfile() {
        this.roles = new ArrayList<>();
        this.createdAt = Instant.now();
    }

    public UserProfile(String name, String email, int age) {
        this();
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    /** Fluent setter — returns {@code this}. */
    public UserProfile setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    /** Fluent setter — returns {@code this}. */
    public UserProfile setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getAge() {
        return age;
    }

    /** Fluent setter — returns {@code this}. */
    public UserProfile setAge(int age) {
        this.age = age;
        return this;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    /** Fluent setter — returns {@code this}. */
    public UserProfile setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public List<String> getRoles() {
        return Collections.unmodifiableList(roles);
    }

    /** Fluent setter — returns {@code this}. */
    public UserProfile setRoles(List<String> roles) {
        this.roles = new ArrayList<>(roles);
        return this;
    }

    /** Fluent add — returns {@code this}. */
    public UserProfile addRole(String role) {
        this.roles.add(role);
        return this;
    }

    public boolean isAdmin() {
        return "admin".equals(name);
    }

    public int getAgeAsInt() {
        return age;
    }

    public boolean hasEmail() {
        return email != null && !email.isEmpty();
    }

    public String roleSummary() {
        StringJoiner joiner = new StringJoiner(", ");
        for (String role : roles) {
            joiner.add(role);
        }
        return joiner.toString();
    }

    public boolean isEmailPresent() {
        return email != null;
    }

    @Override
    public String toString() {
        return "UserProfile{name='" + name + "', email='" + email + "', age=" + age + "}";
    }
}
