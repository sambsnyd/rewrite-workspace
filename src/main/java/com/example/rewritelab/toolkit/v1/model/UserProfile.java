package com.example.rewritelab.toolkit.v1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A user profile JavaBean with deliberate code smells.
 */
public class UserProfile {

    private String name;
    private String email;
    private int age;
    private Date createdAt;
    private List roles; // raw type

    public UserProfile() {
        this.roles = new ArrayList(); // raw type
        this.createdAt = new Date();
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

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List getRoles() {
        return roles;
    }

    public void setRoles(List roles) {
        this.roles = roles;
    }

    // EqualsAvoidsNull: variable.equals("literal")
    public boolean isAdmin() {
        return name.equals("admin");
    }

    // UseIntegerValueOf
    public Integer getAgeAsObject() {
        return new Integer(age);
    }

    // StringIsEmpty: str.length() == 0
    public boolean hasEmail() {
        return email != null && email.length() != 0;
    }

    // String concat in loop
    public String roleSummary() {
        String result = "";
        for (int i = 0; i < roles.size(); i++) {
            result = result + roles.get(i).toString();
            if (i < roles.size() - 1) {
                result = result + ", ";
            }
        }
        return result;
    }

    // SimplifyTernary
    public boolean isEmailPresent() {
        return email != null ? true : false;
    }

    @Override
    public String toString() {
        return "UserProfile{name='" + name + "', email='" + email + "', age=" + age + "}";
    }
}
