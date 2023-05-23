package com.nb.demo.kms;


import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author shouzhi@duan
 * KmsTemplate核心注入类
 */
@AutoConfiguration
@EnableConfigurationProperties({KmsConfigProperties.class})
public class KmsAutoConfiguration {

    final KmsConfigProperties kmsConfigProperties;


    public KmsAutoConfiguration(KmsConfigProperties kmsConfigProperties){
        this.kmsConfigProperties = kmsConfigProperties;
    }

    @Bean
    @ConditionalOnMissingBean(
            name = {"kmsTemplate"}
    )
    public KmsTemplate kmsTemplate(KmsHandlerFactory kmsHandlerFactory) {
        String ALGO = kmsConfigProperties.getAlgo();
        KmsAlgoEnum kmsAlgoEnum = KmsAlgoEnum.valueOf(ALGO);
        KmsHandlerAbstract kmsHandler = kmsHandlerFactory.productHandler(kmsAlgoEnum);
        KmsTemplate kmsTemplate = new KmsTemplate(kmsHandler);
        return kmsTemplate;
    }



}