package com.company.people;

public class Human {
    public String name;
    public double cash;

    public Human(String name, double cash) {
        this.name = name;
        this.cash = cash;
    }
    public Human(String name) {
        this.name = name;
    }
    public Human(){

    }

    public boolean haveMoney(double price) {
        if (this.cash > price){
            return true;
        } else {
            System.out.println("You dont have money!");
            return false;
        }
    }

}
