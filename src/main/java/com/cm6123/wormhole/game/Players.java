package com.cm6123.wormhole.game;

import com.cm6123.wormhole.dice.Dice;

public class Players {
    private final String name;
    private int position;
    Dice aDice1;
    Dice aDice2;
    int CurrentPosition;


    public Players(String PlayerName){
        name = PlayerName;
        this.position = 1;
    }

    public String getName(){
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int CurrentPosition(){
        int aDice1Roll = aDice1.roll();
        int aDice2Roll = aDice2.roll();
        CurrentPosition = aDice1Roll+aDice2Roll+position;
        return CurrentPosition;
    }

    public boolean getWinner(){
        if(CurrentPosition>=9){
            return true;
        }
        return false;
    }
}

//import com.cm6123.wormhole.dice.Dice;
//
//public class Players{
//    private String name;
//    private static Dice dice;
//
//    public Players(String name){
//        this.name = name;
//        dice = new Dice(6);
//    }
//
//    public int playersTakeTurn(){
//        int roll = dice.roll();
//        System.out.println(name+" rolled a "+roll);
//        return roll;
//    }
//
//    public String getName(){
//        return name;
//    }
//}
