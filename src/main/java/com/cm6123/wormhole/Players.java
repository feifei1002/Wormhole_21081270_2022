package com.cm6123.wormhole;

import java.util.Scanner;

public class Players {
    private String name;

    public Players(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of player 1");
        name = sc.nextLine();
    }

    public Players(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
