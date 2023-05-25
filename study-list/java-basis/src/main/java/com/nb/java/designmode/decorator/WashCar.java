package com.nb.java.designmode.decorator;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName WashCar
 * @author: duanshouzhi
 * @create: 2023-05-25 15:17
 * @description:
 **/
public class WashCar extends DecoratorCar{

    public WashCar(Car car) {
        super(car);
    }

    public void method1(){
        System.out.println("======洗车======");
    }

    @Override
    public void car() {
        super.car();
        method1();
    }
}