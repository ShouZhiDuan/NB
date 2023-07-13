package com.nb.java.designmode.templatemethod.pattern1;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName TestMain
 * @author: duanshouzhi
 * @create: 2023-07-09 22:12
 * @description:
 **/
public class TestMain {

    public static void main(String[] args) {
        //AbstractStudent student = new XiaoMing();
        AbstractStudent xiaoMing = new XiaoMing();
        xiaoMing.todayTask();

        AbstractStudent hanMei = new HanMei();
        hanMei.todayTask();

    }

}