package com.cm6123.wormhole;

import java.util.ArrayList;
import java.util.List;

public class WormholeGame {
    private List<Players> players;
    private int PlayerIndex;

    public WormholeGame(String... name){
        players = new ArrayList<>();
        for (String names : name) {
            Players player = new Players(names);
            players.add(player);
        }
        PlayerIndex = 0;

    }

    protected Players getPlayer(){

        return players.get(PlayerIndex);
    }

    public String toString(){
        return getPlayer().getName() +" you are on square 1";
    }

    public static void main(String[] args) {
        WormholeGame wg = new WormholeGame();
        wg.getPlayer();
        wg.toString();
    }

}
