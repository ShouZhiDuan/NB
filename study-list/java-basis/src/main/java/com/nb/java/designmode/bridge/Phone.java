package com.nb.java.designmode.bridge;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName Phone
 * @author: duanshouzhi
 * @create: 2023-06-12 15:59
 * @description:
 **/

public abstract class Phone {

    private com.nb.java.designmode.bridge.Memory memory;

    public Phone() {

    }

    public Phone(com.nb.java.designmode.bridge.Memory memory) {
        this.memory = memory;
    }

    public com.nb.java.designmode.bridge.Memory getMemory() {
        return memory;
    }

    public void setMemory(com.nb.java.designmode.bridge.Memory memory) {
        this.memory = memory;
    }

    /**
     * 购买手机
     */
    public abstract void buyPhone();

}