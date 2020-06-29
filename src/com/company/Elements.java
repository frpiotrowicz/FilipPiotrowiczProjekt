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

    public int elementsToInt(String element) {
        if (element.equals("brakes")){
            return 1;
        } else if (element.equals("suspension")) {
            return 2;
        } else if (element.equals("engine")){
            return 3;
        } else if (element.equals("body")){
            return 4;
        } else if (element.equals("transmission")){
            return 5;
        } else {
            return 6;
        }
    }
}
