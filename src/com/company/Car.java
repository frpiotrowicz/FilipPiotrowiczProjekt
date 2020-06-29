package com.company;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

    private String braksDisplay;

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


    public void repairBrakes(){
        if (repair(brakes)) {
            brakes = true;
        }
    }

    public void repairSuspension(){
        if (repair(suspension)) {
            suspension = true;
        }
    }

    public void repairEngine(){
        if (repair(engine)) {
            engine = true;
        }
    }

    public void repairBody(){
        if (repair(body)) {
            body = true;
        }
    }

    public void repairTransmission(){
        if (repair(transmission)) {
            transmission = true;
        }
    }

    public void chooseRepair(String element){
        switch (elementsToInt(element)) {
            case 1:
                this.repairBrakes();
                break;
            case 2:
                this.repairSuspension();
                break;
            case 3:
                this.repairEngine();
                break;
            case 4:
                this.repairBody();
                break;
            case 5:
                this.repairTransmission();
                break;
            default:
                System.out.println("there is no such part");
        }
    }
}
