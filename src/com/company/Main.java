package com.company;

import com.company.people.Player;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Wanna play?");
        System.out.print("Enter your name:  ");
        String name = scan.nextLine();

        Player player = new Player(name);
        System.out.println("hi " + name + ", type number for what you want to do");
        player.mainMenu();

    }
}
