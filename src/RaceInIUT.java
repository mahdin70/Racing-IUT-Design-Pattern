import Car.*;
import Engine.*;
import RaceComponents.*;
import Track.Track;
import Decorator.*;
import NOS.*;
import Factory.*;
import TurboCharger.*;

import java.util.Scanner;


public class RaceInIUT {
    public static Race createRace(Car car, Track track){
        return new Race(car, track);
    }

    public static Engine getv6Engine() {return new V6Engine();}
    public static Engine getv8Engine(){return new V8Engine();}
    public static Engine getv12Engine(){return new V12Engine();}
    public static TurboCharger getHoneywellTurboCharger(){return new Honeywell();}
    public static TurboCharger getCumminsTurboCharger(){return new Cummins();}
    public static TurboCharger getAlpineTurboCharger(){return new Alpine();}

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Racing Game in IUT\n");
            System.out.println("------------------------------------------------------");
            System.out.println("Enter Player Name: ");
            String playerName = scanner.nextLine();
            Player player = Player.getInstance();
            player.name = playerName;
            System.out.println("Hello " + player.name + "!" + "\nWelcome to IUT Racing Game!\n");
            System.out.println("------------------------------------------------------");

            System.out.println("Choose a Car Category:\n(1) Coupe\n(2) Roadster");
            int carCategory = scanner.nextInt();
            switch(carCategory){
                case 1:
                    carCategory = 1;
                    break;
                case 2:
                    carCategory = 2;
                    break;
                default:
                    throw new IllegalStateException("Invalid Car Category");
            }

            AbstractCarFactory carFactory;
            carFactory = carCategory == 1 ? CarFactoryProducer.getFactory("COUPE") : CarFactoryProducer.getFactory("ROADSTER");
            assert carFactory != null;

            System.out.println("------------------------------------------------------");
            int carType;
            String carName;

            if(carCategory == 1){
                System.out.println("Choose a Coupe Car : \n(1) Toyota GR86\n(2) Subaru BRZ\n");
                carType = scanner.nextInt();
                switch(carType){
                    case 1:
                        carName = "TOYOTA";
                        break;
                    case 2:
                        carName = "SUBARUBRZ";
                        break;
                    default:
                        throw new IllegalStateException("Invalid Car Type" + carType);
                }

            }

            else{
                System.out.println("Choose a Roadster Car : \n(1) PorscheBoxster\n(2) Ferrari 812\n");
                carType = scanner.nextInt();
                switch(carType){
                    case 1:
                        carName = "PORSCHE";
                        break;
                    case 2:
                        carName = "FERRARI";
                        break;
                    default:
                        throw new IllegalStateException("Invalid Car Type" + carType);
                }
            }

            Engine engine = null;
            TurboCharger turboCharger = null;

            System.out.println("------------------------------------------------------");
            System.out.println("Choose an Engine: \n(1) V6\n(2) V8\n(3) V12\n");
            int engineChoice = scanner.nextInt();
            switch(engineChoice){
                case 1:
                    engine = getv6Engine();
                    break;
                case 2:
                    engine = getv8Engine();
                    break;
                case 3:
                    engine = getv12Engine();
                    break;
                default:
                    throw new IllegalStateException("Invalid Engine Choice" + engineChoice);
            }

            System.out.println("------------------------------------------------------");
            System.out.println("Choose a TurboCharger: \n(1) Honeywell\n(2) Cummins\n(3) Alpine\n");
            int turboChargerChoice = scanner.nextInt();
            switch(turboChargerChoice){
                case 1:
                    turboCharger = getHoneywellTurboCharger();
                    break;
                case 2:
                    turboCharger = getCumminsTurboCharger();
                    break;
                case 3:
                    turboCharger = getAlpineTurboCharger();
                    break;
                default:
                    throw new IllegalStateException("Invalid TurboCharger Choice" + turboChargerChoice);
            }

            Car car = carFactory.getCar(carName, engine, turboCharger);
            car.showCarInfo();
            System.out.println("------------------------------------------------------");


            TrackFactory trackFactory = new TrackFactory();
            System.out.println("Choose a Track: \n(1) BB Raceway Japan\n(2) Blue Moon Bay Speedway USA\n(3) Circuit De Spa Francorchamps Germany\n");
            int trackChoice = scanner.nextInt();
            String trackName;
            switch(trackChoice){
                case 1:
                    trackName = "BBRacewayJapan";
                    break;
                case 2:
                    trackName = "BlueMoonBaySpeedwayUSA";
                    break;
                case 3:
                    trackName = "CircuitDeSpaFrancorchampsGermany";
                    break;
                default:
                    throw new IllegalStateException("Invalid Track Choice" + trackChoice);
            }

            Track track = trackFactory.getTrack(trackName);

            Race race = createRace(car, track);
            race.startRace();


        }

        catch (Exception e){
            System.out.println(e);
            System.out.println("Your input was wrong!Let's try again.");
            main(args);
        }
    }
}
