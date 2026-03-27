package com.example.rewritelab.toolkit.v1.builder;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * A query builder with deliberate code smells.
 */
public class QueryBuilder {

    private String table;
    private List<String> columns;
    private List<String> conditions;
    private Integer limit;

    public QueryBuilder(String table) {
        this.table = table;
        this.columns = Lists.newArrayList(); // Guava Lists.newArrayList()
        this.conditions = Lists.newArrayList();
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

    // UseIntegerValueOf
    public QueryBuilder limit(int max) {
        this.limit = new Integer(max);
        return this;
    }

    // StringIsEmpty
    public String build() {
        StringBuilder sb = new StringBuilder("SELECT ");
        if (columns.size() == 0) {
            sb.append("*");
        } else {
            sb.append(String.join(", ", columns));
        }
        sb.append(" FROM ").append(table);

        if (conditions.size() != 0) {
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
