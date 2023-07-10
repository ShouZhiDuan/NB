package com.nb.java.designmode.templatemethod.pattern1;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName HanMei
 * @author: duanshouzhi
 * @create: 2023-07-10 15:41
 * @description:
 **/
public class HanMei extends AbstractStudent{

    @Override
    protected void doOtherTask() {
        System.out.println("======寒梅需要做课外作业======");
    }

    @Override
    protected boolean isOtherTask() {
        return false;
    }
}