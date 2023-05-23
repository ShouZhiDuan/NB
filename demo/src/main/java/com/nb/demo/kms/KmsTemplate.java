package com.nb.demo.kms;

import lombok.Data;

/**
 * @author shouzhi@duan
 */
@Data
public class KmsTemplate {

    private KmsHandlerAbstract kmsHandler;

    public KmsTemplate(KmsHandlerAbstract kmsHandler){
        kmsHandler = kmsHandler;
    }

    /**
     * DEK
     */
    public String generateDEK(){
        // TODO ......
        return kmsHandler.generateDEK();
    }

    /**
     * CMK
     */
    public String generateCMK(){
        // TODO ......
        return kmsHandler.generateCMK();
    }

}