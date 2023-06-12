package com.nb.java.designmode.bradge;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName HuaWei
 * @author: duanshouzhi
 * @create: 2023-06-12 16:06
 * @description:
 **/
public class HuaWei extends Phone{
    @Override
    public void buyPhone() {
        getMemory().addMemory();
        System.out.println("购买华为手机");
    }
}