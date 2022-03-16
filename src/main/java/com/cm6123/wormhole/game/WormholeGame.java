package com.cm6123.wormhole.game;


import com.cm6123.wormhole.dice.Dice;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class WormholeGame {

    private final List<Players> players;
    private final Map<Players, Integer> playerPosition;
    private final int[][] gameBoard;
    private int playerIndex;
    private Players winner;
    private final Dice dice1 = new Dice(6);
    private final Dice dice2 = new Dice(6);
    int newLocation = dice1.roll() + dice2.roll();
    private int holePosition;
    private int negHolePosition;


    //get board size from Board class to create the board
    public WormholeGame(final Board size) {

        playerIndex = 0;
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

    // get players from Players class and add into the list of playing
    public void addPlayer(final Players player) {
        players.add(player);
        playerPosition.put(player, 1); //all players start from position 1 on the board
    } //end of addPlayer method

    public Players getCurrentPlayer() {
        Players CurrentPlayer = players.get(playerIndex);
        return CurrentPlayer;
    }


    public void getNextPlayer() { //make this return void and just adjust the index.

        playerIndex = ((playerIndex + 1) % players.size());

    }


        public int move(final int newLocation) {
        Players CurrentPlayer = getCurrentPlayer();
        int FinalPosition = gameBoard.length* gameBoard.length;
        this.newLocation = newLocation;
        int PlayerOldLocation = playerPosition.get(CurrentPlayer);
        int PlayerNewLocation = PlayerOldLocation + newLocation;
        getNextPlayer();
        if(PlayerNewLocation >= FinalPosition) {
            PlayerNewLocation = FinalPosition;
            playerPosition.put(CurrentPlayer, PlayerNewLocation);
            winner = CurrentPlayer;
        } else {
            PlayerNewLocation = checkWormholes(PlayerNewLocation);
            playerPosition.put(CurrentPlayer, PlayerNewLocation);
            return PlayerNewLocation;
            }
        return PlayerNewLocation;
    } //end of move method


    public Players getWinner() {
        return winner;
    }

    public int checkWormholes(final int newPosition) {
        this.holePosition = newPosition;
        if (holePosition == 3) {
            holePosition = 8;
        }
        if (holePosition == 6) {
            holePosition = 20;
        }
        if (holePosition == 10) {
            holePosition = 2;
        }
        if (holePosition == 13) {
            holePosition = 3;
        }
        return holePosition;

    }


}