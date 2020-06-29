package com.company;

public abstract class Elements {
    public String elements(boolean check){
        if (!check){
            return "need repair";
        } else {return "ok";}
    }

    public boolean repair(boolean element){
        if (!element) {
            return true;
        } else {
            System.out.println("it doesnt need repair");
            return false;
        }
    }
}
