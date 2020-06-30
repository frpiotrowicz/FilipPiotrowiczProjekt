package com.company.people;

import com.company.Car;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Player extends Human implements HaveMoney {
    private static final int Def_Score = 0;
    private static final double Def_Cash = 100000.0;
    public int score = 0;
    public List<Car> myCars = new LinkedList<>();
    public List<Car> carsToBuy = new LinkedList<>();
    public List<Client> clients = new LinkedList<>();

    Scanner scan = new Scanner(System.in);

    public Player(String name) {
        super(name);
        this.score = Def_Score;
        this.cash = Def_Cash;
        for (int i = 0; i < 12; i++){
            Car newCar = new Car();
            this.carsToBuy.add(newCar);
        }
        for (int i = 0; i < 10; i++){
            Client newClient = new Client();
            this.clients.add(newClient);
        }

    }

    public boolean elementExist(String element){
        switch (element) {
            case "brakes":
            case "suspension":
            case "engine":
            case "body":
            case "transmission":
                return true;
            default:
                System.out.println("there is no such part");
                return false;
        }
    }

    public boolean haveMoney(int i) {
        return this.cash > carsToBuy.get(i).value*1.025;
    }

    public boolean checkString(String choice){
        try {
            int i = Integer.parseInt(choice);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public void buyCar(String choice){
        int i = Integer.parseInt(choice);
        if(haveMoney(i-1)) {
            System.out.println("you sure you want to buy this car? if so type 'yes', or anything else if not");
            System.out.println(carsToBuy.get(i-1));
            String wantBuy = scan.next();

            if (wantBuy.equals("yes")) {
                this.cash -= carsToBuy.get(i - 1).value*1.025;
                myCars.add(carsToBuy.get(i - 1));
                carsToBuy.remove(i - 1);
                Car newCar = new Car();
                this.carsToBuy.add(newCar);
                Client newClient = new Client();
                this.clients.add(newClient);
                this.score +=1;
                this.mainMenu();
            } else {
                this.buyCarMenu();
            }

        }else {
            System.out.println("YOU DONT HAVE ENOUGH MONEY");
            this.buyCarMenu();
        }
    }

    public void CarstoSell(int i) {
        List<Car> carsToSell = new LinkedList<>();
        for (int x=0; x <2; x++){
            for (int y = 0; y < this.myCars.size(); y++){
                if (this.clients.get(i-1).wantedBrand[x].equals(this.myCars.get(y).brand)){
                    carsToSell.add(this.myCars.get(y));
                }
            }
        }
        if (carsToSell.size() < 1){
            System.out.println("there is no car you can sell to him");
            this.seeClientsMenu();
        } else {
            for (int q =0; q<carsToSell.size(); q++) {
                System.out.println(q+1 + ". " + carsToSell.get(q));
            }
            System.out.println("choose car to sell or write 'back'");
            String chooseCar = scan.next();
            if (this.checkString(chooseCar)) {
                int choosen = Integer.parseInt(chooseCar);
                carsToSell.get(choosen - 1).sellCar(this, this.clients.get(i - 1));
            } else if (chooseCar.equals("back")){
                this.mainMenu();
            } else {
                System.out.println("dont know what to do. type again");
                this.seeClientsMenu();
            }
        }
    }

    public void mainMenu() {
        System.out.println("MAIN MENU:");
        System.out.println("1. Buy Car");
        System.out.println("2. Your Cars");
        System.out.println("3. Clients");
        System.out.println("4. Buy Advertisment");
        System.out.println("5. EXIT");
        System.out.println("Your Cash/Needed Cash : " + Math.round(this.cash*100d)/100d + "/" + Def_Cash * 2);
        System.out.println("Your Score (lower is better): " + this.score);

        String choice = scan.next();

        switch (choice) {
            case "1":
                this.buyCarMenu();
                break;
            case "2":
                this.yourCarsMenu();
                break;
            case "3":
                this.seeClientsMenu();
                break;
            case "4":
                this.buyAddMenu();
                break;
            case "5":
                System.out.println("you sure to exit? type 'exit' if so, or anything else to go back");
                String yes = scan.next();
                if (yes.equals("exit")) {
                    break;
                } else {
                    this.mainMenu();
                }
                break;
            default:
                System.out.println("nothing found bro, choose again");
                System.out.println();
                this.mainMenu();
        }
        if (this.cash > this.Def_Cash * 2) {
            System.out.println("congrat you won with score: " + this.score);
            System.out.println("you can continue playing or exit if you want");
        }
    }

    public void buyCarMenu() {
        for (int i = 0; i < carsToBuy.size(); i++){
            System.out.println(i+1 + ". " + carsToBuy.get(i));
        }
        System.out.println();
        System.out.println("Choose number to buy car, or type 'back' to return to previous menu" );

        String choice = scan.next();

        switch (choice) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
            case "11":
            case "12":
                this.buyCar(choice);
                break;
            case "back":
                this.mainMenu();
                break;
            default:
                System.out.println("wrong expression, type again");
                buyCarMenu();
        }
    }

    public void yourCarsMenu(){
        if (myCars.size()<1){
            System.out.println("You dont own any cars");
            System.out.println();
            this.mainMenu();
        }else {
            for (int i = 0; i < myCars.size(); i++) {
                System.out.println(i + 1 + ". " + myCars.get(i));
            }
        }

        System.out.println();
        System.out.println("remember you have to pay 2% tax and wash car for 0.5% value");
        System.out.println("choose car to repair, or write 'back' to return to previous menu");

        String chooseCar = scan.next();

        if (checkString(chooseCar)){
            int i = Integer.parseInt(chooseCar);

            if (i < this.myCars.size()+1 && i > 0) {
                System.out.println("you choose this car to repair");
                System.out.println(myCars.get(i - 1));
                System.out.println();
                System.out.println("type what do you want to repair");

                String element = scan.next();

                if (elementExist(element)) {
                    this.myCars.get(i - 1).chooseMechanic(element, this);
                } else {
                    System.out.println("there is no such car");
                    this.yourCarsMenu();
                }

            } else {
                System.out.println("wrong number. choose again");
                this.yourCarsMenu();
            }

        } else if (chooseCar.equals("back")) {
            this.mainMenu();
        } else {
            System.out.println("dont know what to do. try again");
            this.yourCarsMenu();
        }
    }

    public  void seeClientsMenu(){
        System.out.println("YOU SELLING WITH 10% margin from value");
        for (int i = 0; i < clients.size(); i++){
            System.out.println(i+1 + ". " + clients.get(i));
        }
        System.out.println("choose client to check if you have cars to sell to him");
        System.out.println("or write 'back' to return to previous menu" );

        String choice = scan.next();
        if (checkString(choice)) {
            int i = Integer.parseInt(choice);
            System.out.println("you have chosen this Client");
            System.out.println(this.clients.get(i-1));
            System.out.println("and you can sell him this cars:");
            this.CarstoSell(i);
        } else if (choice.equals("back")){
            this.mainMenu();
        } else {
            System.out.println("dont know what to do. type again");
            this.seeClientsMenu();
        }
    }

    public void buyAddMenu() {
        System.out.println("1. Newspaper Add: 15000$");
        System.out.println("2. Online Add: 10000$");
        System.out.println();
        System.out.println("type number what add you want to buy, or back to go to previous menu");

        String choice = scan.next();
        switch (choice) {
            case "1":
                if (haveMoney(15000.0)) {
                    System.out.println("you bought Newspaper add");
                    int randomNum = ThreadLocalRandom.current().nextInt(2, 6);
                    for (int i = 0; i < randomNum; i++) {
                        Client newClient = new Client();
                        this.clients.add(newClient);
                        this.score +=1;
                    }
                } else {
                    System.out.println("you dont have money");
                }
                this.mainMenu();
                break;
            case "2":
                if (haveMoney(10000.0)) {
                    System.out.println("you bought online add");
                    Client newClient = new Client();
                    this.clients.add(newClient);
                    this.score +=1;
                } else {
                    System.out.println("you dont have money");
                }
                this.mainMenu();
                break;
            case "back":
                this.mainMenu();
            default:
                System.out.println("dont know what to do. type again");
                this.buyAddMenu();
        }
    }


    @Override
    public boolean haveMoney() {
        return false;
    }
}
