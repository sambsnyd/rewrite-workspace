package com.example.rewritelab.toolkit.v2.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * v2 QueryBuilder — drops Guava dependency, uses standard collections.
 *
 * <p>Migration notes from v1:
 * <ul>
 *   <li>No longer uses {@code Lists.newArrayList()}</li>
 *   <li>{@code limit(int)} now accepts {@code long} for large result sets</li>
 * </ul>
 */
public class QueryBuilder {

    private String table;
    private List<String> columns;
    private List<String> conditions;
    private Long limit;

    public QueryBuilder(String table) {
        this.table = table;
        this.columns = new ArrayList<>();
        this.conditions = new ArrayList<>();
    }

    public QueryBuilder select(String... cols) {
        for (String col : cols) {
            columns.add(col);
        }
        return this;
    }

    public QueryBuilder where(String condition) {
        conditions.add(condition);
        return this;
    }

    /** Now accepts {@code long}. v1 accepted {@code int}. */
    public QueryBuilder limit(long max) {
        this.limit = max;
        return this;
    }

    public String build() {
        StringBuilder sb = new StringBuilder("SELECT ");
        if (columns.isEmpty()) {
            sb.append("*");
        } else {
            sb.append(String.join(", ", columns));
        }
        sb.append(" FROM ").append(table);

        if (!conditions.isEmpty()) {
            sb.append(" WHERE ");
            sb.append(String.join(" AND ", conditions));
        }

        if (limit != null) {
            sb.append(" LIMIT ").append(limit);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return build();
    }
}
