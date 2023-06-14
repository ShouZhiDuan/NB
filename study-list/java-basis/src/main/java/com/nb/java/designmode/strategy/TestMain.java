package com.nb.java.designmode.strategy;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName TestMain
 * @author: duanshouzhi
 * @create: 2023-06-14 13:37
 * @description:
 **/
public class TestMain {

    public static void main(String[] args) {
        Type1Buy type1Buy = new Type1Buy();
        Type2Buy type2Buy = new Type2Buy();
        StrategyContext.builder(type1Buy).buy(100);
        StrategyContext.builder(type2Buy).buy(100);
    }

}