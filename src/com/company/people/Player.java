package com.company.people;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Player extends Human {
    private static final int Def_Score = 0;
    private static final double Def_Cash = 10000.0;
    public int score;

    Scanner scan = new Scanner(System.in);

    public Player(String name) {
        super(name);
        this.score = Def_Score;
        this.cash = Def_Cash;
    }

    public void mainMenu() {
        System.out.println("1. Buy Car");
        System.out.println("2. Your Cars");
        System.out.println("3. Clients");
        System.out.println("4. Buy Advertisment");
        System.out.println("5. EXIT");
        System.out.println("Your Cash: " + this.cash + "/" + this.cash*2);
        System.out.println("Your Score: " + this.score);

        String choice = scan.next();

        boolean canCompile;
        try {
            int i = Integer.parseInt(choice);
            canCompile = true;
        }
        catch (Exception e) {
            canCompile = false;
        }

        if(canCompile) {
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
        System.out.println("tu bedzie lista samochodow");
        System.out.println("type 'back' to return to previous menu" );
        String back = scan.next();
        while (!back.equals("back")){
            System.out.println("i just dont know what to do with myself");
            System.out.println();
            System.out.println("type 'back'to return to previous menu" );
            back = scan.next();
        }
        this.mainMenu();
    }

    public void yourCarsMenu(){
        System.out.println("tu beda twoje auta");
        System.out.println("write 'back' to return to previous menu" );
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
