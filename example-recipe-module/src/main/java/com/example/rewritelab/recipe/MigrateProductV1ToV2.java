package com.example.rewritelab.recipe;

import org.openrewrite.ExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.TreeVisitor;

public class MigrateProductV1ToV2 extends Recipe {

    @Override
    public String getDisplayName() {
        return "Migrate `v1.Product` to `v2.Product`";
    }

    @Override
    public String getDescription() {
        return "Rewrites usages of the v1 `Product` JavaBean to the v2 `Product` API.";
    }

    @Override
    public TreeVisitor<?, ExecutionContext> getVisitor() {
        // TODO: implement
        return TreeVisitor.noop();
    }
}
