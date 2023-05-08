package com.nb.global.exception.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "rest.controller.advice")
public class RestControllerAdviceBasepackagesConfig {
      private String basepackages;
}

