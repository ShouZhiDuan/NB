package com.nb.java.designmode.chain;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName LoginHandler
 * @author: duanshouzhi
 * @create: 2023-07-08 14:47
 * @description:
 **/
public class LoginHandler extends Handler{

    public LoginHandler(Handler handler) {
        super(handler);
    }

    @Override
    public void process(Request request) {
        System.out.println("======进行登陆操作======");
        Handler next = this.getNext();
        if(next != null){
            next.process(request);
        }else {
            System.out.println("没有链路执行了。。。。。。");
        }
    }
}