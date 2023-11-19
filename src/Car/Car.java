package Car;

import Engine.Engine;
import NOS.NOS;
import TurboCharger.TurboCharger;

public class Car {
    private Engine engine;
    private TurboCharger turboCharger;



    private NOS nos;

    public Car(Engine engine, TurboCharger turboCharger){
        this.setEngine(engine);
        this.setTurboCharger(turboCharger);
    }

    public Car(Engine engine, TurboCharger turboCharger, NOS nos){
        this.setEngine(engine);
        this.setTurboCharger(turboCharger);
        this.setNOS(nos);
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public TurboCharger getTurboCharger() {
        return turboCharger;
    }

    public void setTurboCharger(TurboCharger turboCharger) {
        this.turboCharger = turboCharger;
    }

    public NOS getNos() {
        return nos;
    }

    public void setNOS(NOS nos) {
        this.nos = nos;
    }

    public void showCarInfo(){
        System.out.println("Car Information:");
        System.out.println("Car Name :" + this.getClass().getSimpleName());
        engine.showEngineInfo();
        turboCharger.showTurboInfo();
        if(this.getNos() != null){
            nos.showNOSInfo();
        }
    }

    public void start(){
        System.out.println("Car is Started");
    }

    public void stop(){
        System.out.println("Car is Stopped");
    }

    public void accelerate(){
        System.out.println("Car is Accelerated");
    }
}
