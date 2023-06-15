package com.nb.java.designmode.singleton.study.innerclass;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName InnerClassSingleTon
 * @author: duanshouzhi
 * @create: 2023-06-15 14:27
 * @description:
 **/
public class InnerClassSingleTon {

    private InnerClassSingleTon(){
        if(SingleTon.SINGLE_TON != null){
            throw new RuntimeException("非法构造");
        }
    }

    static class SingleTon{
        public final static InnerClassSingleTon SINGLE_TON = new InnerClassSingleTon();
    }


}