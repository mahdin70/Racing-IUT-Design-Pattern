package Decorator;

import Car.Car;
import NOS.NOS;

public class NOSCarDecorator extends CarDecorator{
    public NOSCarDecorator(Car decoratedCar, NOS nos){
        super(decoratedCar, nos);
    }
}
