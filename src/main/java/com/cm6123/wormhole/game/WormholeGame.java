package com.cm6123.wormhole.game;


import java.util.*;

public class WormholeGame {
    private List<Players> players;
    private Map<Players, Integer> playerPosition;
    private final int[][] gameBoard;

    public WormholeGame(Board size) {
        int SIZE = size.getSIZE();
        gameBoard = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                gameBoard[i][j] = i * SIZE + j + 1;
            }
        }
    }

    public void addPlayer(Players player) {
        players = new ArrayList<>();
        playerPosition = new HashMap<>();
        players.add(player);
        playerPosition.put(player, 1);
    } //end of addPlayer method

    public Players getCurrentPlayer() {
        int playerIndex = 0;
        Players CurrentPlayer = players.get(playerIndex % players.size());
        playerIndex++;
        return CurrentPlayer;
    } //end of getCurrentPlayer method


    public int move(int newLocation) {
        Players CurrentPlayer = getCurrentPlayer();
        int PlayerNewLocation = playerPosition.get(CurrentPlayer) + newLocation;
        playerPosition.put(CurrentPlayer, PlayerNewLocation);
        return PlayerNewLocation;
    } //end of move method


    public int winner() {
        Players CurrentPlayer = getCurrentPlayer();
        int PlayerPosition = playerPosition.get(CurrentPlayer);
        int BoardSize = gameBoard.length * gameBoard.length;
        if (PlayerPosition >= BoardSize) {
            playerPosition.put(CurrentPlayer, BoardSize);
            return BoardSize;
        }
        return PlayerPosition;
    }
}