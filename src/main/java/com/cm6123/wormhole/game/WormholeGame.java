package com.cm6123.wormhole.game;


import com.cm6123.wormhole.dice.Dice;

import java.util.*;

public class WormholeGame {

    private final List<Players> players;
    private final Map<Players, Integer> playerPosition;
    private final int[][] gameBoard;
    private int playerIndex;
    private Players winner;
    Dice dice1 = new Dice(6);
    Dice dice2 = new Dice(6);
    int newLocation = dice1.roll()+ dice2.roll();


    public WormholeGame(Board size) { //get board size from Board class to create the board

        //start of game playerIndex=0

        playerIndex=0;


        playerPosition = new HashMap<>();
        this.players = new ArrayList<>();
        int SIZE = size.getSIZE();
        gameBoard = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                gameBoard[i][j] = i * SIZE + j + 1;
            }
        }
    }


    public void addPlayer(Players player) { // get players from Players class and add into the list of playing
        players.add(player);
        playerPosition.put(player, 1); //all players start from position 1 on the board
    } //end of addPlayer method

    public Players getCurrentPlayer(){
        Players CurrentPlayer = players.get(playerIndex);
        return CurrentPlayer;
    }


    public void getNextPlayer() { //make this return void and just adjust the index.

        playerIndex = ((playerIndex+1) % players.size());

    }



    public int move(int newLocation) {
        Players CurrentPlayer = getCurrentPlayer();
        int FinalPosition = gameBoard.length* gameBoard.length;
        this.newLocation = newLocation;
        int PlayerOldLocation = playerPosition.get(CurrentPlayer);
        int PlayerNewLocation = PlayerOldLocation + newLocation;
        if(PlayerNewLocation>=FinalPosition) {
            PlayerNewLocation = FinalPosition;
            playerPosition.put(CurrentPlayer, PlayerNewLocation);
            winner = CurrentPlayer;
        }
        getNextPlayer();
        return PlayerNewLocation;
    } //end of move method



    public Players getWinner(){
        return winner;
    }

}