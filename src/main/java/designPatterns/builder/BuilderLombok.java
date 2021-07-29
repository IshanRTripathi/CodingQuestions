package main.java.designPatterns.builder;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
public class BuilderLombok {
    private String host;
    private int port;
    private boolean useHttps;

    private long connectTimeout;
    private long readTimeout;

    private String username;
    private String password;
}
