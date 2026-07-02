package com.example.rewritelab.toolkit.v2;

import com.example.rewritelab.toolkit.v2.model.UserProfile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit 4 tests for v2 UserProfile.
 */
public class UserProfileV2Test {

    private UserProfile profile;

    @Before
    public void setUp() {
        profile = new UserProfile("Alice", "alice@example.com", 30);
    }

    @Test
    public void testFluentSetters() {
        UserProfile result = new UserProfile()
                .setName("Bob")
                .setEmail("bob@example.com")
                .setAge(25)
                .addRole("USER")
                .addRole("ADMIN");

        Assert.assertEquals("Bob", result.getName());
        Assert.assertEquals("bob@example.com", result.getEmail());
        Assert.assertEquals(25, result.getAge());
        Assert.assertEquals(2, result.getRoles().size());
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
    public void testRoleSummary() {
        profile.addRole("USER").addRole("EDITOR");
        Assert.assertEquals("USER, EDITOR", profile.roleSummary());
    }

    @Test
    public void testGetCreatedAt() {
        Assert.assertNotNull(profile.getCreatedAt());
    }
}
