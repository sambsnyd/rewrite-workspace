package com.example.rewritelab.toolkit.v1;

import com.example.rewritelab.toolkit.v1.model.UserProfile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit 4 tests for UserProfile (migration target for JUnit 5).
 */
public class UserProfileTest {

    private UserProfile profile;

    @Before
    public void setUp() {
        profile = new UserProfile("Alice", "alice@example.com", 30);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Alice", profile.getName());
    }

    @Test
    public void testGetEmail() {
        Assert.assertEquals("alice@example.com", profile.getEmail());
    }

    @Test
    public void testGetAge() {
        Assert.assertEquals(30, profile.getAge());
    }

    @Test
    public void testIsAdmin() {
        Assert.assertFalse(profile.isAdmin());
        profile.setName("admin");
        Assert.assertTrue(profile.isAdmin());
    }

    @Test
    public void testHasEmail() {
        Assert.assertTrue(profile.hasEmail());
        profile.setEmail("");
        Assert.assertFalse(profile.hasEmail());
    }

    @Test
    public void testIsEmailPresent() {
        Assert.assertTrue(profile.isEmailPresent());
        profile.setEmail(null);
        Assert.assertFalse(profile.isEmailPresent());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testRoleSummary() {
        profile.getRoles().add("USER");
        profile.getRoles().add("EDITOR");
        Assert.assertEquals("USER, EDITOR", profile.roleSummary());
    }

    @Test
    public void testGetAgeAsObject() {
        Assert.assertEquals(Integer.valueOf(30), profile.getAgeAsObject());
    }

    @Test
    public void testToString() {
        String str = profile.toString();
        Assert.assertTrue(str.contains("Alice"));
    }
}
