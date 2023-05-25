package com.nb.java.designmode.decorator;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName DecoratorCar
 * @author: duanshouzhi
 * @create: 2023-05-25 15:07
 * @description:
 **/
public abstract class DecoratorCar extends Car {

    private Car car;

    public DecoratorCar(Car car) {
        this.car = car;
    }

    @Override
    public void car() {
        this.car.car();
    }

}