package RaceComponents;

import Car.Car;
import NOS.NOS;
import Track.Track;
import NOS.Resonac;
import NOS.Sema;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Race {
    private final Car car;
    private final Track track;

    public Race(Car car, Track track) {
        this.car = car;
        this.track = track;
    }

    public final void showRaceInfo(){
        car.showCarInfo();
        track.showTrackInfo();
    }

    private void startLine(Track track){
        track.startLine();
    }

    private void finishLine(Track track){
        track.finishingLine();
    }

    private void startCar(Car car){
        car.start();
    }
    private void stopCar(Car car){
        car.stop();
    }
    private void accelerateCar(Car car){
        car.accelerate();
    }

    private void applyNOS(Car car, NOS nos){
        car.setNOS(nos);
    }

    private void pitStop(Car car){
        System.out.println("---------------------Pit Stop----------------------");
        NOS nos = null;
        System.out.println("Select NOS to apply: \n(1) Resonac\n(2) Sema\n");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                nos = new Resonac();
                break;
            case 2:
                nos = new Sema();
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }

        applyNOS(car, nos);
        assert nos != null;
        System.out.println("Applying NOS: " + nos.getClass().getSimpleName());
        car.setNOS(nos);
        System.out.println(nos.getClass().getSimpleName() + "NOS Applied");
        accelerateCar(car);
    }

    private void lapTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Random random = new Random();

        long ms = random.nextInt(3600000);
        Date date = new Date(ms);
        String formattedTime = simpleDateFormat.format(date);

        System.out.println("Lap Time: " + formattedTime);
    }

    public final void startRace(){
        showRaceInfo();
        System.out.println("-------------------------------------------------------------");
        startLine(track);
        startCar(this.car);
        accelerateCar(this.car);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wanna Apply NOS? (Y/N)");
        String choice = scanner.nextLine();

        if(choice.equalsIgnoreCase("Y")){
            pitStop(car);
        }
        System.out.println("-------------------------------------------------------------");
        finishLine(this.track);
        stopCar(this.car);
        System.out.println("-------------------------------------------------------------");
        lapTime();
    }
}
