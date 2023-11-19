package Factory;

public class CarFactoryProducer {
    public static AbstractCarFactory getFactory(String factoryType) {
        if (factoryType.equalsIgnoreCase("COUPE")) {
            return new CoupeCarFactory();
        }
        else if (factoryType.equalsIgnoreCase("ROADSTER")) {
            return new RoadsterCarFactory();
        }
        return null;
    }
}
