package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        String[] carBrandsList= new String[]{"Audi", "BMW", "Fiat", "Ford", "Jaguar", "Mazda", "Mercedes", "Opel"};
        Random random = new Random();
        String x = carBrandsList[random.nextInt(carBrandsList.length)];
        String y = carBrandsList[random.nextInt(carBrandsList.length)];
        String z = carBrandsList[random.nextInt(carBrandsList.length)];
        String a = carBrandsList[random.nextInt(carBrandsList.length)];

        System.out.println(x + " " + y + " " +  z + " " + a);



    }
}
