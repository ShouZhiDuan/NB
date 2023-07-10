package com.nb.java.designmode.templatemethod.pattern1;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName XiaoMing
 * @author: duanshouzhi
 * @create: 2023-07-09 22:12
 * @description:
 **/
public class XiaoMing extends AbstractStudent{

    @Override
    protected void doOtherTask() {
        System.out.println("小明做课外作业");
    }

    @Override
    protected boolean isOtherTask() {
        System.out.println("小明需要做课外作业的");
        return true;
    }
}