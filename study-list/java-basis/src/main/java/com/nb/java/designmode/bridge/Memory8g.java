package com.nb.java.designmode.bridge;

import com.nb.java.designmode.bridge.Memory;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName Memory8g
 * @author: duanshouzhi
 * @create: 2023-06-12 16:05
 * @description:
 **/
public class Memory8g implements Memory {

    @Override
    public void addMemory() {
        System.out.println("设置8G内存");
    }
}