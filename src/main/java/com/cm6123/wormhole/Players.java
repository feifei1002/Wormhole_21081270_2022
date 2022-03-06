package com.cm6123.wormhole;

public class Players {
    private final String name;
    private int position;

    public Players(String name){
        this.name = name;
        this.position = 1;
    }

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
