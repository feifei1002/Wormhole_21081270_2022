package com.cm6123.wormhole;

import java.util.ArrayList;
import java.util.Scanner;

public class Players {
    private String name;
    private int position;


//    public Players(String AName){
//        name = AName;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter the name of player");
//        name = sc.nextLine();
//        this.position = 1;
//    }

    public Players(String name){
        this.name = name;
        this.position = 1;
    }

//    public Players(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter the name of player");
//        name = sc.nextLine();
//    }
    public String getName(){
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position){
        this.position = position;
    }
}
