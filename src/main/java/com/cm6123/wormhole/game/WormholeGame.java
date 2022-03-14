package com.cm6123.wormhole.game;


import com.cm6123.wormhole.dice.Dice;

import java.util.*;

public class WormholeGame {

    private List<Players> players;
    private Map<Players, Integer> playerPosition;
    private final int[][] gameBoard;
    private int PlayerIndex;
    private boolean GameOver;
    private Players winner;
    Dice dice1 = new Dice(6);
    Dice dice2 = new Dice(6);
    int newLocation = dice1.roll()+ dice2.roll();


    public WormholeGame(Board size) { //get board size from Board class to create the board
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
        players = new ArrayList<>();
        playerPosition = new HashMap<>();
        players.add(player);
        playerPosition.put(player, 1); //all players start from position 1 on the board
    } //end of addPlayer method



    public Players getCurrentPlayer() { // check who is the current player
        PlayerIndex = 0;
        Players FirstPlayer = players.get(0);
        if(PlayerIndex>=0) {
            Players CurrentPlayer = players.get((PlayerIndex + 1) % players.size());
            PlayerIndex++;
            return CurrentPlayer;
            }
        return FirstPlayer;
    } //end of getCurrentPlayer method


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
        return PlayerNewLocation;
    } //end of move method

    public Players getWinner(){
        return winner;
    }



    public void play(){
        while(setGameOver(false)){
            int BoardSize = gameBoard.length* gameBoard.length;
            int FinalLocation = move(newLocation);
            if(FinalLocation>=BoardSize){
                getWinner();
            }

        }setGameOver(true);

    }

    public boolean setGameOver(boolean gameOver) {
        GameOver = gameOver;
        return gameOver;
    }
}