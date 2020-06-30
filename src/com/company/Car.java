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
    public boolean brakes;
    private boolean suspension;
    private boolean engine;
    private boolean body;
    private boolean transmission;
    public boolean repairFailed = false;

    Scanner scan = new Scanner(System.in);
    Random random = new Random();

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
        this.value = Math.round(ThreadLocalRandom.current().nextDouble(2000.0, 150000.0) * 100d) / 100d;
        this.brand = carBrands[random.nextInt(carBrands.length)];
        this.mileage = Math.round(ThreadLocalRandom.current().nextDouble(0.0, 350000.0));
        this.colour = carColour[random.nextInt(carColour.length)];
        this.segment = carSegments[random.nextInt(carSegments.length)];
        this.brakes = random.nextBoolean();
        this.suspension = random.nextBoolean();
        this.engine = random.nextBoolean();
        this.body = random.nextBoolean();
        this.transmission = random.nextBoolean();
        this.repairFailed = false;
    }


    public boolean youSure(double price) {
        System.out.println("are you sure you want to try repair for " + Math.round(price * 100d) / 100d + "? type 'yes' if so or anything else to cancel");
        String answer = scan.next();
        return "yes".equals(answer);
    }


    public boolean repairBrakes() {
        if (!brakes) {
            brakes = true;
            return true;
        } else {
            System.out.println("it doesnt need repair");
            return false;
        }
    }

    public boolean repairSuspension() {
        if (!suspension) {
            suspension = true;
            return true;
        } else {
            System.out.println("it doesnt need repair");
            return false;
        }
    }

    public boolean repairEngine() {
        if (!engine) {
            engine = true;
            return true;
        } else {
            System.out.println("it doesnt need repair");
            return false;
        }
    }

    public boolean repairBody() {
        if (!body) {
            body = true;
            return true;
        } else {
            System.out.println("it doesnt need repair");
            return false;
        }
    }

    public boolean repairTransmission() {
        if (!transmission) {
            transmission = true;
            return true;
        } else {
            System.out.println("it doesnt need repair");
            return false;
        }
    }


    public void chooseRepair(String element, Player player, double priceMultiplayer) {
        double price;
        switch (element) {
            case "brakes":
                price = this.value * 0.07 * priceMultiplayer;
                if (youSure(price) && this.repairBrakes() && player.haveMoney(price)) {
                    player.cash -= price;
                    this.value *= 1.1;
                } else {
                    player.yourCarsMenu();
                }
                break;
            case "suspension":
                price = this.value * 0.15 * priceMultiplayer;
                if (youSure(price) && this.repairSuspension() && player.haveMoney(price)) {
                    player.cash -= price;
                    this.value *= 1.2;
                } else {
                    player.yourCarsMenu();
                }
                break;
            case "engine":
                price = this.value * 0.7 * priceMultiplayer;
                if (youSure(price) && this.repairEngine() && player.haveMoney(price)) {
                    player.cash -= price;
                    this.value *= 2;
                } else {
                    player.yourCarsMenu();
                }
                break;
            case "body":
                price = this.value * 0.3 * priceMultiplayer;
                if (youSure(price) && this.repairBody() && player.haveMoney(price)) {
                    player.cash -= price;
                    this.value *= 1.5;
                } else {
                    player.yourCarsMenu();
                }
                break;
            case "transmission":
                price = this.value * 0.3 * priceMultiplayer;
                if (youSure(price) && this.repairTransmission() && player.haveMoney(price)) {
                    player.cash -= price;
                    this.value *= 1.5;
                } else {
                    player.yourCarsMenu();
                }
                break;
            default:
                System.out.println("there is no such part");
        }
    }

    public void chooseRepairFail(String element, Player player, double priceMultiplayer) {
        double price;
        switch (element) {
            case "brakes":
                price = this.value * 0.07 * priceMultiplayer;
                if (youSure(price) && this.repairBrakes() && player.haveMoney(price)) {
                    player.cash -= price;
                } else {
                    player.yourCarsMenu();
                }
                break;
            case "suspension":
                price = this.value * 0.15 * priceMultiplayer;
                if (youSure(price) && this.repairSuspension() && player.haveMoney(price)) {
                    player.cash -= price;
                } else {
                    player.yourCarsMenu();
                }
                break;
            case "engine":
                price = this.value * 0.7 * priceMultiplayer;
                if (youSure(price) && this.repairEngine() && player.haveMoney(price)) {
                    player.cash -= price;
                } else {
                    player.yourCarsMenu();
                }
                break;
            case "body":
                price = this.value * 0.3 * priceMultiplayer;
                if (youSure(price) && this.repairBody() && player.haveMoney(price)) {
                    player.cash -= price;
                } else {
                    player.yourCarsMenu();
                }
                break;
            case "transmission":
                price = this.value * 0.3 * priceMultiplayer;
                if (youSure(price) && this.repairTransmission() && player.haveMoney(price)) {
                    player.cash -= price;
                } else {
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
        System.out.println();
        player.yourCarsMenu();
    }

    public void marianRepair(String element, Player player) {
        int randomInt = random.nextInt(99);
        if (randomInt < 90) {
            chooseRepair(element, player, 0.66);
            System.out.println("congrats. car rapaired successfully");
            System.out.println(this);
            System.out.println();
            player.yourCarsMenu();
        } else {
            this.repairFailed = true;
            this.chooseRepairFail(element, player, 0.66);
            System.out.println("sorry repair failed.");
            repairAfterFail(element, player);
        }
       }

    public void adrianRepair(String element, Player player){
        if (random.nextInt(99) < 4) {
            this.screwElement();
        }
        if (random.nextInt(99) < 80) {
            chooseRepair(element, player, 0.66);
            System.out.println("congrats. car rapaired successfully");
            System.out.println(this);
            System.out.println();
            player.yourCarsMenu();
        } else {
            this.repairFailed = true;
            this.chooseRepairFail(element, player, 0.66);
            System.out.println("sorry repair failed.");
            repairAfterFail(element, player);
        }
    }



        public void chooseMechanic (String element, Player player){
            System.out.println("choose your mechanic with number");
            System.out.println("1. Janusz: success 100%");
            System.out.println("2. Marian: success 90%");
            System.out.println("3. Adrian: success 80%");

            String mechanic = scan.next();

            if (this.repairFailed = false) {
                switch (mechanic) {
                    case "1":
                        januszRepair(element, player);
                        break;
                    case "2":
                        marianRepair(element, player);
                        break;
                    case "3":
                        adrianRepair(element, player);
                        break;
                    default:
                        System.out.println("there is no such mechanic");
                        player.yourCarsMenu();
                }
            } else {
                System.out.println("you can only try with Janusz now");
                this.repairAfterFail(element, player);
            }
        }


    public void repairAfterFail(String element, Player player) {
        System.out.println("would you like to try with Janusz? type yes if so");
        String choice = scan.next();
        if (choice.equals("yes")) {
            januszRepair(element, player);
        } else {
            player.mainMenu();
        }
    }

    public void screwElement(){
        int rand = random.nextInt(5);
        switch (rand){
            case 0:
                this.brakes = false;
                break;
            case 1:
                this.suspension = false;
                break;
            case 2:
                this.engine = false;
                break;
            case 3:
                this.body = false;
                break;
            case 4:
                this.transmission = false;
                break;
            default:
                break;
        }
    }
}
