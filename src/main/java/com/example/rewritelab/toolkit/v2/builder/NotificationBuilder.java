package com.example.rewritelab.toolkit.v2.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * v2 NotificationBuilder — drops Guava Strings dependency, adds priority.
 *
 * <p>Migration notes from v1:
 * <ul>
 *   <li>No longer uses {@code Strings.isNullOrEmpty()}</li>
 *   <li>New {@code priority(int)} method</li>
 *   <li>{@code isValid()} now also requires non-empty subject (not just non-null)</li>
 * </ul>
 */
public class NotificationBuilder {

    private String recipient;
    private String subject;
    private String body;
    private List<String> tags;
    private int priority;

    public NotificationBuilder() {
        this.tags = new ArrayList<>();
        this.priority = 3; // default normal priority
    }

    public NotificationBuilder to(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public NotificationBuilder subject(String subject) {
        this.subject = subject;
        return this;
    }

    public NotificationBuilder body(String body) {
        this.body = body;
        return this;
    }

    public NotificationBuilder tag(String tag) {
        this.tags.add(tag);
        return this;
    }

    /** New in v2. Priority 1 (highest) to 5 (lowest). */
    public NotificationBuilder priority(int priority) {
        this.priority = priority;
        return this;
    }

    public boolean isValid() {
        return recipient != null && !recipient.isEmpty()
                && subject != null && !subject.isEmpty();
    }

    public String build() {
        if (!isValid()) {
            throw new IllegalStateException("Recipient and subject are required");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("To: ").append(recipient).append("\n");
        sb.append("Subject: ").append(subject).append("\n");
        sb.append("Priority: ").append(priority).append("\n");
        if (body != null && !body.isEmpty()) {
            sb.append("Body: ").append(body).append("\n");
        }
        if (!tags.isEmpty()) {
            sb.append("Tags: ").append(String.join(", ", tags)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "NotificationBuilder{to='" + recipient + "', subject='" + subject + "', priority=" + priority + "}";
    }
}
