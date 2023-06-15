package com.nb.java.designmode.singleton.study.serializable;

import java.io.Serializable;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName SerializableSingleton
 * @author: duanshouzhi
 * @create: 2023-06-15 14:55
 * @description:
 **/
public class SerializableSingleton implements Serializable {

    private SerializableSingleton(){
        if(SINGLETON != null){
            throw new RuntimeException("已有实例，无法创建");
        }
    }
    private final static SerializableSingleton SINGLETON = new SerializableSingleton();

    static SerializableSingleton getSingleton(){
        return SINGLETON;
    }

    public Object readResolve(){
        return SINGLETON;
    }

}