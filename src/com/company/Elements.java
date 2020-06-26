package com.company;

public abstract class Elements {
    public String elements(boolean check){
        if (!check){
            return "need repair";
        } else {return "ok";}
    }
}
