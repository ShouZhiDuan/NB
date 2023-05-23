package com.nb.demo.kms;

import lombok.Data;


/**
 * @author shouzhi@duan
 * 支持算法枚举
 */
public enum KmsAlgoEnum {

    SM4("SM4"),
    OTHER("OTHER")
    ;

    private String ALGO;

    KmsAlgoEnum(String ALGO){
        this.ALGO = ALGO;
    }

    public String getALGO() {
        return ALGO;
    }
}