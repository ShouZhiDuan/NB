package com.nb.java.designmode.bridge;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName BradgeTestMain
 * @author: duanshouzhi
 * @create: 2023-06-12 16:08
 * @description:
 **/
public class BridgeTestMain {

    public static void main(String[] args) {
        com.nb.java.designmode.bridge.Memory8g memory8g = new com.nb.java.designmode.bridge.Memory8g();
        com.nb.java.designmode.bridge.HuaWei huaWei = new com.nb.java.designmode.bridge.HuaWei();
        huaWei.setMemory(memory8g);
        huaWei.buyPhone();
    }

}