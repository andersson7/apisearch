package com.fri.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author Andersson
 */
@Component
@ConfigurationProperties(prefix = "app")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppConfig {

    private String authUri;
    private boolean ignoreSession;
    private String allowedOrigins = "*";
    private String allowedMethods = "GET, POST, PUT, DELETE, OPTIONS";
    private String allowedHeaders = "Access-Control-Allow-Origin, Access-Control-Allow-Headers, Access-Control-Allow-Methods, Accept, "
            + "Authorization, Content-Type, Method, Origin, X-Forwarded-For, X-Real-IP";
}
