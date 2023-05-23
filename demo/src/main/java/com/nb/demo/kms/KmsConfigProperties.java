package com.nb.demo.kms;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shouzhi@duan
 * KmsTemplate初始换相关的系统变量BEAN
 */
@Data
@ConfigurationProperties(prefix = "nv.kms")
public class KmsConfigProperties {
    private String algo;
}