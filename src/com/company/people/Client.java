package com.company.people;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Client extends Human{

    Random random = new Random();

    public String[] wantedBrand = new String[2];


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

    private static String[] names = new String[]{
            "Filip",
            "Marek",
            "Dominika",
            "Maciej",
            "Anna",
            "Paweł",
            "Ola",
            "Czesiek",
            "Daria",
            "Jakub",
            "Monika",
            "Karol",
            "Czesia",
            "Kacper",
            "Karolina"
    };

    public Client() {
        this.name = names[random.nextInt(names.length)];
        this.cash = Math.round(ThreadLocalRandom.current().nextDouble(2000.0, 150000)*10d)/10d;
        this.wantedBrand[0] = carBrands[random.nextInt(carBrands.length)];
        this.wantedBrand[1] = carBrands[random.nextInt(carBrands.length)];
    }

    @Override
    public String toString() {
        return "client{" +
                "name=" + this.name +
                ", cash=" + this. cash +
                ", wantedBrand=" + Arrays.toString(wantedBrand) +
                '}';
    }

}
