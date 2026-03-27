package com.example.rewritelab.toolkit.v1.pattern;

/**
 * Factory for creating connections with inner interface and classes.
 */
public class ConnectionFactory {

    public interface Connection {
        String getUrl();
        boolean isOpen();
        void close();
    }

    public static class DatabaseConnection implements Connection {
        private String url;
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
        public void close() {
            this.open = false;
        }

        @Override
        public String toString() {
            return "DB[" + url + ", open=" + open + "]";
        }
    }

    public static class HttpConnection implements Connection {
        private String url;
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
        public void close() {
            this.open = false;
        }

        @Override
        public String toString() {
            return "HTTP[" + url + ", open=" + open + "]";
        }
    }

    // Old-style switch (no arrow syntax)
    public static Connection create(String type, String url) {
        switch (type) {
            case "db":
                return new DatabaseConnection(url);
            case "http":
                return new HttpConnection(url);
            default:
                throw new IllegalArgumentException("Unknown connection type: " + type);
        }
    }

    // SimplifyTernary
    public static boolean isSecure(String url) {
        return url != null && url.startsWith("https") ? true : false;
    }
}
