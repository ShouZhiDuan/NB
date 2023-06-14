package com.nb.java.designmode.strategy;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName BuyBookStrategy
 * @author: duanshouzhi
 * @create: 2023-06-14 13:40
 * @description:
 **/
public interface BuyBookStrategy {

    /**
     * 购买入口
     * @param money
     */
    void buyBook(Integer money);

}
