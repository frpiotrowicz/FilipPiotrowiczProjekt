package com.company.people;

import com.company.Car;
import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Player extends Human {
    private static final int Def_Score = 0;
    private static final double Def_Cash = 100000.0;
    public int score;
    public List<Car> myCars = new LinkedList<>();
    public List<Car> carsToBuy = new LinkedList<>();

    Scanner scan = new Scanner(System.in);

    public Player(String name) {
        super(name);
        this.score = Def_Score;
        this.cash = Def_Cash;
        for (int i = 0; i < 12; i++){
            Car newCar = new Car();
            this.carsToBuy.add(newCar);
        }

    }

    public boolean haveMoney(int i) {
        return this.cash > carsToBuy.get(i).value;
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

    public void mainMenu() {
        System.out.println("1. Buy Car");
        System.out.println("2. Your Cars");
        System.out.println("3. Clients");
        System.out.println("4. Buy Advertisment");
        System.out.println("5. EXIT");
        System.out.println("Your Cash: " + this.cash + "/" + Def_Cash*2);
        System.out.println("Your Score: " + this.score);

        String choice = scan.next();

        if(checkString(choice)) {
            int i = Integer.parseInt(choice);
            switch (i) {
                case 1:
                    this.buyCarMenu();
                    break;
                case 2:
                    this.yourCarsMenu();
                    break;
                case 3:
                    this.seeClientsMenu();
                    break;
                case 4:
                    this.buyAddMenu();
                    break;
                case 5:
                    System.out.println("you sure? type 'yes' if so, or anything else to go back");
                    String yes = scan.next();
                    if (yes.equals("yes")) {
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
        }else {
            System.out.println("WRONG!!! Type number bro.");
            System.out.println();
            this.mainMenu();
        }
    }

    public void buyCarMenu() {
        for (int i = 0; i < carsToBuy.size(); i++){
            System.out.println(i+1 + ". " + carsToBuy.get(i));
        }
        System.out.println();
        System.out.println("Choose number to buy car, or type 'back' to return to previous menu" );

        String choice = scan.next();
        if(checkString(choice)) {
            int i = Integer.parseInt(choice);
            if (i < 1){
                System.out.println("wrong number try again");
                buyCarMenu();
            } else if (i < carsToBuy.size()+1) {
                if(haveMoney(i-1)) {
                    System.out.println("you sure you want to buy this car? if so type 'yes', or anything else if not");
                    System.out.println(carsToBuy.get(i-1));
                    String wantBuy = scan.next();
                    if (wantBuy.equals("yes")) {
                        this.cash -= carsToBuy.get(i - 1).value;
                        myCars.add(carsToBuy.get(i - 1));
                        carsToBuy.remove(i - 1);
                        Car newCar = new Car();
                        this.carsToBuy.add(newCar);
                        this.mainMenu();
                    } else {
                        this.buyCarMenu();
                    }
                }else {
                    System.out.println("YOU DONT HAVE ENOUGH MONEY");
                    this.buyCarMenu();
                }
            } else {
                System.out.println("wrong number try again");
                buyCarMenu();
            }
        } else {
            if (choice.equals("back")){
                this.mainMenu();
            } else {
                System.out.println("dont know what you want. Try again");
                this.buyCarMenu();
            }
        }
    }

    public void yourCarsMenu(){
        if (myCars.size()<1){
            System.out.println("You dont own any cars");
        }else {
            for (int i = 0; i < myCars.size(); i++) {
                System.out.println(i + 1 + ". " + myCars.get(i));
            }
        }
        System.out.println();
        System.out.println("write 'back' to return to previous menu, or choose car to repair" );
    }

    public  void seeClientsMenu(){
        System.out.println("tu beda twoi klienci");
        System.out.println("write 'back' to return to previous menu" );
    }

    public void buyAddMenu(){
        System.out.println("1. Newspaper Add");
        System.out.println("1. Online Add");
    }
}
