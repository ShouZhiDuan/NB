package com.nb.dingding.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author dev
 */
@Data
@Component
@ConfigurationProperties(prefix = "dingding")
public class DingDingPushConfigProperties {
    private String baseurl;
    private String token;
    private String secret;
}