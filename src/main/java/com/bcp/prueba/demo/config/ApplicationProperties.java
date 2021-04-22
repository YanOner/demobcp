package com.bcp.prueba.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@Data
public class ApplicationProperties {

    @Value("${url.api.convert}")
    private String urlApiConvert;

    @Value("${api.access.key}")
    private String apiAccessKey;

}
