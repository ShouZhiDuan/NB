package com.nb.demo.kms;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shouzhi@duan
 * 具体算法实现输出工厂
 */
@Slf4j
@Component
public class KmsHandlerFactory {

    private final Map<String,KmsHandlerAbstract> handlers = new ConcurrentHashMap<>();

    public KmsHandlerAbstract productHandler(KmsAlgoEnum kmsAlgoEnum){
        KmsHandlerAbstract kmsHandler = handlers.get(kmsAlgoEnum.getALGO());
        if(ObjectUtils.isNotEmpty(kmsHandler)){
            return kmsHandler;
        }
        switch (kmsAlgoEnum){
            case SM4: kmsHandler = new Sm4Handler();
            break;
            case OTHER: kmsHandler = new OtherHandler();
            break;
            default:
                log.error("Illegal algo . . . . . .");
                break;
        }
        return kmsHandler;
    }

}