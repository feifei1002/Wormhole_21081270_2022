package com.cm6123.wormhole;

import java.util.HashMap;
import java.util.List;

public class Boards {

    private int size3Board[][];
    private HashMap< Players,Integer>PlayersPosition = new HashMap<Players, Integer>(6);

    public Boards(List<Players> players){
//    public Boards(){
        size3Board = new int[3][3];
        for(int i=0; i< size3Board.length; i++){
            for(int j=0; j< size3Board.length; j++){
                size3Board[i][j] = i+j;
            }
        }

//        for(Players player : players){
//            PlayersPosition.put(player,1);
//
//        }
    }

    public boolean movePlayerPosition(Players player, int position){
        int CurrentPosition = PlayersPosition.get(player);
        CurrentPosition += position;
        PlayersPosition.put(player, position);
        return false;
    }

}
