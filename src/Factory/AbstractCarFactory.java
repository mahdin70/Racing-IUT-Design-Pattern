package Factory;

import Car.Car;
import Engine.Engine;
import TurboCharger.TurboCharger;

public abstract class AbstractCarFactory {
    public abstract Car getCar(String carType, Engine engine, TurboCharger turboCharger);
}
