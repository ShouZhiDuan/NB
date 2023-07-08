package com.nb.java.designmode.chain;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName Handler
 * @author: duanshouzhi
 * @create: 2023-07-08 14:34
 * @description:
 **/
public abstract class Handler {

    private Handler handler;

    public Handler(Handler handler) {
        this.handler = handler;
    }

    public Handler getNext(){
        return this.handler;
    }

    public abstract void process(Request request);

}