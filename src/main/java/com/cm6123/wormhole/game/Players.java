package com.cm6123.wormhole.game;

public class Players {
    private final String name;
    private int position;


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

    public void setPosition(int PlayerPosition){
        position = PlayerPosition;
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
