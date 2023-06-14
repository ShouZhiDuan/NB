package com.nb.java.designmode.strategy;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName StrategyContext
 * @author: duanshouzhi
 * @create: 2023-06-14 13:39
 * @description:
 **/
public class StrategyContext {

    private BuyBookStrategy strategy;

    static StrategyContext builder(BuyBookStrategy strategy){
        return new StrategyContext(strategy);
    }

    private StrategyContext(BuyBookStrategy strategy){
        this.strategy = strategy;
    }

    public void buy(Integer money){
        strategy.buyBook(money);
    }

}