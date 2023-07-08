package com.nb.java.designmode.delegate.pattern2;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName TestMain
 * @author: duanshouzhi
 * @create: 2023-07-08 23:03
 * @description:
 **/
public class TestMain {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(new Monitor());
        teacher.command("学习委员");
        teacher.command("劳动委员");
        teacher.command("文艺委员");
    }
}