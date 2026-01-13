package it.exprivia.Scuola.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.security.jwt")
@Data // Se usi Lombok, altrimenti usa Getter e Setter
public class JwtConfig {
    private String secretKey;
    private long expiration;
}