package com.example.rewritelab.toolkit.v1.builder;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Builds notification messages.
 */
public class NotificationBuilder {

    private String recipient;
    private String subject;
    private String body;
    private List<String> tags;

    public NotificationBuilder() {
        this.tags = Lists.newArrayList();
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

    // Guava Strings.isNullOrEmpty()
    public boolean isValid() {
        return !Strings.isNullOrEmpty(recipient) && !Strings.isNullOrEmpty(subject);
    }

    public String build() {
        if (!isValid()) {
            throw new IllegalStateException("Recipient and subject are required");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("To: ").append(recipient).append("\n");
        sb.append("Subject: ").append(subject).append("\n");
        if (!Strings.isNullOrEmpty(body)) {
            sb.append("Body: ").append(body).append("\n");
        }
        if (!tags.isEmpty()) {
            sb.append("Tags: ").append(String.join(", ", tags)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "NotificationBuilder{to='" + recipient + "', subject='" + subject + "'}";
    }
}
