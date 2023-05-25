package com.nb.java.designmode.decorator;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName DecoratorTestMain
 * @author: duanshouzhi
 * @create: 2023-05-25 15:22
 * @description: 装饰器模式测试
 **/
public class DecoratorTestMain {

    public static void main(String[] args) {
        Car car = new CreateCar();
        car = new BuyCar(car);
        car = new WashCar(car);
        car.car();
    }

}