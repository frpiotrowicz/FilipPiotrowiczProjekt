package com.company;

import com.company.people.Player;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Car extends Elements {
    public double value;
    private String brand;
    private double mileage;
    private String colour;
    private String segment;
    private boolean brakes;
    private boolean suspension;
    private boolean engine;
    private boolean body;
    private boolean transmission;

    Scanner scan = new Scanner(System.in);

    private static String[] carBrands = new String[]{
            "Audi",
            "BMW",
            "Fiat",
            "Ford",
            "Jaguar",
            "Mazda",
            "Mercedes",
            "Opel"
    };
    private static String[] carColour = new String[]{
            "Green",
            "Black",
            "Blue",
            "Brown",
            "Grey",
            "Orange",
            "Pink",
            "Purple",
            "Red",
            "White",
            "Yellow"
    };
    private static String[] carSegments = new String[]{
            "Budget",
            "Premium",
            "Standar"
    };

    Random random = new Random();


    @Override
    public String toString() {
        return "brand=" + brand +
                ", colour=" + colour +
                ", value=" + value +
                ", mileage=" + mileage +
                ", segment=" + segment +
                ", brakes=" + elements(brakes) +
                ", suspension=" + elements(suspension) +
                ", engine=" + elements(engine) +
                ", body=" + elements(body) +
                ", transmission=" + elements(transmission);
    }

    public Car() {
        this.value = Math.round(ThreadLocalRandom.current().nextDouble(2000.0,150000.0)*100d)/100d;
        this.brand = carBrands[random.nextInt(carBrands.length)];
        this.mileage = Math.round(ThreadLocalRandom.current().nextDouble(0.0,350000.0));
        this.colour = carColour[random.nextInt(carColour.length)];
        this.segment = carSegments[random.nextInt(carSegments.length)];
        this.brakes = random.nextBoolean();
        this.suspension = random.nextBoolean();
        this.engine = random.nextBoolean();
        this.body = random.nextBoolean();
        this.transmission = random.nextBoolean();
    }


    public boolean youSure(double price){
        System.out.println("are you sure you want to try repair for " + price*100d/100d +"? type 'yes' if so or anything else to cancel");
        String answer = scan.next();
        return "yes".equals(answer);
    }

    public void repairBrakes(){
        if (repair(brakes)) {
            brakes = true;
            this.value *=1.1;
        }
    }

    public void repairSuspension(){
        if (repair(suspension)) {
            suspension = true;
            this.value *= 1.2;
        }
    }

    public void repairEngine(){
        if (repair(engine)) {
            engine = true;
            this.value *= 2;
        }
    }

    public void repairBody(){
        if (repair(body)) {
            body = true;
            this.value *= 1.5;
        }
    }

    public void repairTransmission(){
        if (repair(transmission)) {
            transmission = true;
            this.value *= 1.5;
        }
    }

    public void chooseRepair(String element, Player player, double priceMultiplayer){
        double price;
        switch (element) {
            case "brakes":
                price = this.value*0.07*priceMultiplayer;
                if (youSure(price)) {
                    player.cash -= price;
                    this.repairBrakes();
                } else {
                    player.yourCarsMenu();
                }
                break;
            case "suspension":
                price = this.value*0.15*priceMultiplayer;
                if (youSure(price)) {
                    player.cash -= price;
                    this.repairSuspension();
                } else {
                    player.yourCarsMenu();
                }
                break;
            case "engine":
                price = this.value*0.7*priceMultiplayer;
                if (youSure(price)) {
                    player.cash -= price;
                    this.repairEngine();
                }else {
                    player.yourCarsMenu();
                }
                break;
            case "body":
                price = this.value*0.3*priceMultiplayer;
                if (youSure(price)) {
                    player.cash -= price;
                    this.repairBody();
                }else {
                    player.yourCarsMenu();
                }
                break;
            case "transmission":
                price = this.value*0.3*priceMultiplayer;
                if (youSure(price)) {
                    player.cash -= price;
                    this.repairTransmission();
                }else {
                    player.yourCarsMenu();
                }
                break;
            default:
                System.out.println("there is no such part");
        }
    }

    public void januszRepair(String element, Player player) {
        chooseRepair(element, player, 1.0);
        System.out.println("congrats. car rapaired successfully");
        System.out.println(this);
        player.yourCarsMenu();
    }

//    public void marianRepair(String element, Player player){
//
//    }
//
//    public void adrianRepair(String element, Player player){
//
//    }

    public void chooseMechanic(String element, Player player){
        System.out.println("choose your mechanic with number");
        System.out.println("1. Janusz: success 100%");
        System.out.println("2. Marian: success 90%");
        System.out.println("3. Adrian: success 80%");

        String choice = scan.next();

        switch (choice) {
            case "1":
                januszRepair(element, player);
                break;
//            case 2:
//                marianRepair(element, player);
//                break;
//            case 3:
//                adrianRepair(element, player);
//                break;
            default:
                System.out.println("there is no such mechanic");
                player.yourCarsMenu();
        }
    }
}
