package com.grammyejb.config.properties;

import jakarta.ejb.Stateless;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Service;

@Stateless
@Service
@Data
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "application.services.music-bands")
public class MusicBandsServiceProps {
    private String host;
    private Integer port;

    public String getUrl() {
        return String.format("%s:%d", "https://localhost", 8443);
    }
}
