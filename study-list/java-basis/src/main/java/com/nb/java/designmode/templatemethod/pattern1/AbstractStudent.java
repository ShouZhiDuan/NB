package com.nb.java.designmode.templatemethod.pattern1;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName AbstractStudent
 * @author: duanshouzhi
 * @create: 2023-07-09 22:06
 * @description:
 **/
public abstract class AbstractStudent {

    public String isOk = "===父类属性===";

    protected final void todayTask(){
        System.out.println(isOk);
        //1、写作业
        doTask();
        //2、检查作业
        checkTask();
        //3、是否做课外作业
        if (isOtherTask()){
            doOtherTask();
        }
    }

    protected void doTask(){
        System.out.println("===父类、写作业===");
    }
    protected void checkTask(){
        System.out.println("===父类、检查作业===");
    }

    protected boolean isOtherTask(){
        return true;
    }


    protected abstract void doOtherTask();


}