package com.cm6123.wormhole.game;

public class Players {
    private final String name;
    private final int position;


    public Players(String PlayerName){
        name = PlayerName;
        this.position = 1;
    } //end of constructor

    public String getName(){
        return name;
    } //end of getName method


    public int getPosition() {
        return position;
    } //end of getPosition method

} //end of Players class