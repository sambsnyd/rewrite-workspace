package com.example.rewritelab.toolkit.v2;

import com.example.rewritelab.toolkit.v2.builder.QueryBuilder;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit 4 tests for v2 QueryBuilder.
 */
public class QueryBuilderV2Test {

    @Test
    public void testSelectAll() {
        String query = new QueryBuilder("users").build();
        Assert.assertEquals("SELECT * FROM users", query);
    }

    @Test
    public void testSelectColumns() {
        String query = new QueryBuilder("users")
                .select("name", "email")
                .build();
        Assert.assertEquals("SELECT name, email FROM users", query);
    }

    @Test
    public void testLongLimit() {
        String query = new QueryBuilder("events")
                .limit(5000000000L)
                .build();
        Assert.assertTrue(query.contains("LIMIT 5000000000"));
    }

    @Test
    public void testFullQuery() {
        String query = new QueryBuilder("products")
                .select("sku", "name", "price")
                .where("price > 100")
                .where("quantity > 0")
                .limit(50)
                .build();
        Assert.assertEquals(
                "SELECT sku, name, price FROM products WHERE price > 100 AND quantity > 0 LIMIT 50",
                query
        );
    }
}
