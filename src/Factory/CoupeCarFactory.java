package Factory;

import Car.Car;
import Car.ToyotaGR86;
import Car.SubaruBRZ;
import Engine.Engine;
import TurboCharger.TurboCharger;

public class CoupeCarFactory extends AbstractCarFactory{
    @Override
    public Car getCar(String carType, Engine engine, TurboCharger turboCharger) {
        if(carType.equalsIgnoreCase("TOYOTA")){
            return new ToyotaGR86(engine, turboCharger);
        }

        else if(carType.equalsIgnoreCase("SUBARUBRZ")){
            return new SubaruBRZ(engine, turboCharger);
        }
        return null;
    }
}
