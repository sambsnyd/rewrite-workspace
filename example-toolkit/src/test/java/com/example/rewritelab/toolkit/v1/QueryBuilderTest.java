package com.example.rewritelab.toolkit.v1;

import com.example.rewritelab.toolkit.v1.builder.QueryBuilder;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit 4 tests for QueryBuilder (migration target for JUnit 5).
 */
public class QueryBuilderTest {

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
    public void testWhereClause() {
        String query = new QueryBuilder("users")
                .where("age > 18")
                .build();
        Assert.assertEquals("SELECT * FROM users WHERE age > 18", query);
    }

    @Test
    public void testLimit() {
        String query = new QueryBuilder("users")
                .limit(10)
                .build();
        Assert.assertEquals("SELECT * FROM users LIMIT 10", query);
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
