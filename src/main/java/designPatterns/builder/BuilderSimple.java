package main.java.designPatterns.builder;

public class BuilderSimple {
    private String host;
    private int port;
    private boolean useHttps;

    private long connectTimeout;
    private long readTimeout;

    private String username;
    private String password;

    public BuilderSimple(String host, int port, boolean useHttps, long connectTimeout, long readTimeout, String username, String password) {
        this.host = host;
        this.port = port;
        this.useHttps = useHttps;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.username = username;
        this.password = password;
    }

    public BuilderSimple() {
    }

    public String getHost() {
        return host;
    }

    public BuilderSimple host(String host) {
        this.host = host;
        return this;
    }

    public int getPort() {
        return port;
    }

    public BuilderSimple port(int port) {
        this.port = port;
        return this;
    }

    public boolean isUseHttps() {
        return useHttps;
    }

    public BuilderSimple useHttps(boolean useHttps) {
        this.useHttps = useHttps;
        return this;
    }

    public long getConnectTimeout() {
        return connectTimeout;
    }

    public BuilderSimple connectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public long getReadTimeout() {
        return readTimeout;
    }

    public BuilderSimple readTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public BuilderSimple username(String username) {
        this.username = username;
        return  this;
    }

    public String getPassword() {
        return password;
    }

    public BuilderSimple password(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "BuilderSimple{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", useHttps=" + useHttps +
                ", connectTimeout=" + connectTimeout +
                ", readTimeout=" + readTimeout +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
