package com.nb.java.designmode.decorator;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName BuyCar
 * @author: duanshouzhi
 * @create: 2023-05-25 15:14
 * @description:
 **/
public class BuyCar extends DecoratorCar{

    public BuyCar(Car car) {
        super(car);
    }


    public void method1(){
        System.out.println("======买车======");
    }
    @Override
    public void car() {
        super.car();
        method1();
    }
}