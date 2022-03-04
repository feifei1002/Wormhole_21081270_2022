package com.cm6123.wormhole;

import java.util.Scanner;

public class Players {
    private String name;


    public Players(String name){
        this.name = name;
    }

    public Players(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of player 1");
        String name = sc.nextLine();
        Players player = new Players(name);
        player.getName();
    }

    public String getName(){
        return name;
    }

    public static void main(String[] args) {
        Players p1 = new Players();
        p1.getName();
    }
}
