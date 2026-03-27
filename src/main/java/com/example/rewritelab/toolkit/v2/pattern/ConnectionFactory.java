package com.example.rewritelab.toolkit.v2.pattern;

/**
 * v2 ConnectionFactory — enum-based type, AutoCloseable connections.
 *
 * <p>Migration notes from v1:
 * <ul>
 *   <li>{@code create(String type, String url)} now takes {@link ConnectionType} enum</li>
 *   <li>{@code Connection} now extends {@code AutoCloseable}</li>
 *   <li>{@code isSecure(String)} moved to {@code Connection.isSecure()} instance method</li>
 * </ul>
 */
public class ConnectionFactory {

    public enum ConnectionType {
        DATABASE,
        HTTP
    }

    public interface Connection extends AutoCloseable {
        String getUrl();
        boolean isOpen();
        boolean isSecure();

        @Override
        void close();
    }

    public static class DatabaseConnection implements Connection {
        private final String url;
        private boolean open;

        public DatabaseConnection(String url) {
            this.url = url;
            this.open = true;
        }

        @Override
        public String getUrl() {
            return url;
        }

        @Override
        public boolean isOpen() {
            return open;
        }

        @Override
        public boolean isSecure() {
            return url != null && url.startsWith("jdbc:ssl:");
        }

        @Override
        public void close() {
            this.open = false;
        }

        @Override
        public String toString() {
            return "DB[" + url + ", open=" + open + "]";
        }
    }

    public static class HttpConnection implements Connection {
        private final String url;
        private boolean open;

        public HttpConnection(String url) {
            this.url = url;
            this.open = true;
        }

        @Override
        public String getUrl() {
            return url;
        }

        @Override
        public boolean isOpen() {
            return open;
        }

        @Override
        public boolean isSecure() {
            return url != null && url.startsWith("https");
        }

        @Override
        public void close() {
            this.open = false;
        }

        @Override
        public String toString() {
            return "HTTP[" + url + ", open=" + open + "]";
        }
    }

    /** Now takes {@link ConnectionType} enum. v1 accepted {@code String}. */
    public static Connection create(ConnectionType type, String url) {
        return switch (type) {
            case DATABASE -> new DatabaseConnection(url);
            case HTTP -> new HttpConnection(url);
        };
    }
}
