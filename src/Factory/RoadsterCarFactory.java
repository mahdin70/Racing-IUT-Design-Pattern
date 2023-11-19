package Factory;


import Car.Car;
import Car.PorscheBoxster;
import Car.Ferrari812;
import Engine.Engine;
import TurboCharger.TurboCharger;

public class RoadsterCarFactory extends AbstractCarFactory{
    public Car getCar(String carName, Engine engine, TurboCharger turboCharger) {
        if(carName.equalsIgnoreCase("FERRARI")){
            return new Ferrari812(engine, turboCharger);
        }
        else if(carName.equalsIgnoreCase("PORSCHE")){
            return new PorscheBoxster(engine, turboCharger);
        }
        return null;
    }
}
