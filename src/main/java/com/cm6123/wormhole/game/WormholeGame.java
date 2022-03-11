package com.cm6123.wormhole.game;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WormholeGame {
    private List<Players> players;
    private Map<Players, Integer> playerPosition;

    public void addPlayer(Players player){
        players = new ArrayList<>();
        playerPosition = new HashMap<>();
        players.add(player);
        playerPosition.put(player,1);
    } //end of addPlayer method

    public Players getCurrentPlayer(){
        int playerIndex = 0;
            Players CurrentPlayer = players.get(playerIndex%players.size());
            playerIndex++;
        return CurrentPlayer;
    } //end of getCurrentPlayer method

    public int move( int newLocation){
        Players CurrentPlayer = getCurrentPlayer();
        int PlayerNewLocation = playerPosition.get(CurrentPlayer) + newLocation;
        playerPosition.put(CurrentPlayer,PlayerNewLocation);
        return PlayerNewLocation;
    } //end of move method

}// end of WormholeGame class