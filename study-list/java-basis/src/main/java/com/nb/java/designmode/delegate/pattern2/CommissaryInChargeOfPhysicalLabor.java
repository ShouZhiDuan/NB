package com.nb.java.designmode.delegate.pattern2;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName CommissaryInChargeOfPhysicalLabor
 * @author: duanshouzhi
 * @create: 2023-07-08 22:52
 * @description: 劳动委员
 **/
public class CommissaryInChargeOfPhysicalLabor implements Student{

    @Override
    public void registrationProgram(String role) {
        System.out.println("我是劳动委员：我要报名表演打扫卫生");
    }
}