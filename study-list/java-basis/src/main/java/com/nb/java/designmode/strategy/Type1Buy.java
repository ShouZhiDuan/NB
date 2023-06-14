package com.nb.java.designmode.strategy;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName Type1Buy
 * @author: duanshouzhi
 * @create: 2023-06-14 13:41
 * @description:
 **/
public class Type1Buy implements BuyBookStrategy{

    @Override
    public void buyBook(Integer money) {
        System.out.println(money + "优惠10% = " + (money -money*0.1));
    }
}