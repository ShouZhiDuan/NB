package com.nb.java.designmode.bradge;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName BradgeTestMain
 * @author: duanshouzhi
 * @create: 2023-06-12 16:08
 * @description:
 **/
public class BradgeTestMain {

    public static void main(String[] args) {
        Memory8g memory8g = new Memory8g();
        HuaWei huaWei = new HuaWei();
        huaWei.setMemory(memory8g);
        huaWei.buyPhone();
    }

}