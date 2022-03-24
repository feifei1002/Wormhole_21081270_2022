package com.cm6123.wormhole.game;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class WormholeGame {

    /**
     * A list to store the players that are playing.
     */
    private final List<Players> players;
    /**
     * A map to store the position that each player is on.
     */
    private final Map<Players, Integer> playerPosition;
    /**
     * get the actual board for the game.
     */
    private final int[][] gameBoard;
    /**
     * Uses playerIndex to keep track of the current player and the next player.
     */
    private int playerIndex;
    /**
     * the winner of the entire game.
     */
    private Players winner;
    /**
     * the value of two dices added up together.
     */
    private int newLocation;
    /**
     * the position of positive and negative wormholes.
     */
    private int holePosition;


    //get board size from Board class to create the board

    /**
     * construct the game by getting the size of the board.
     *
     * @param size the size of the board.
     */
    public WormholeGame(final Board size) {

        playerIndex = 0;
        playerPosition = new HashMap<>();
        this.players = new ArrayList<>();
        int boardSize = size.getSIZE();
        gameBoard = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                gameBoard[i][j] = i * boardSize + j + 1;
            }
        }
    }

    /**
     * add the players for the current game into the list.
     *
     * @param player add player into the list.
     */
    public void addPlayer(final Players player) {
        players.add(player);
        playerPosition.put(player, 1); //all players start from position 1 on the board
    } //end of addPlayer method

    /**
     * get the current player that is moving.
     *
     * @return currentPlayer
     */
    public Players getCurrentPlayer() {
        Players currentPlayer = players.get(playerIndex);
        return currentPlayer;
    }

    /**
     * get the next player that will be moving.
     */
    public void getNextPlayer() { //make this return void and just adjust the index.

        playerIndex = ((playerIndex + 1) % players.size());

    }

    /**
     * player move in the game.
     *
     * @param nLocation the value of the dices after rolling
     * @return PlayerNewLocation
     * Player new location after moving.
     */
    public int move(final int nLocation) {
        Players currentPlayer = getCurrentPlayer();
        int finalPosition = gameBoard.length * gameBoard.length;
        newLocation = nLocation;
        int playerOldLocation = playerPosition.get(currentPlayer);
        int playerNewLocation = playerOldLocation + newLocation;
        if (playerNewLocation >= finalPosition) {
            playerNewLocation = finalPosition;
            playerPosition.put(currentPlayer, playerNewLocation);
            hasPlayerWon(currentPlayer);
            winner = currentPlayer;
        } else {
            playerNewLocation = checkWormholes(playerNewLocation);
            playerPosition.put(currentPlayer, playerNewLocation);
            return playerNewLocation;
        }
        return playerNewLocation;
    } //end of move method

    /**
     * to be able to get the player name from the list of player.
     *
     * @return players return the player's list.
     */
    public List<Players> getPlayers() {
        return players;
    }

    /**
     * get the final winner's name of the game.
     *
     * @return winner.
     */
    public Players getWinner() {
        return winner;
    }

    /**
     * check the condition of any player has won yet.
     * @param player
     * @return true when player's position is the winning position
     */
    public boolean hasPlayerWon(final Players player) {
        int playerPos = playerPosition.get(player);
        int winningPosition = gameBoard.length * gameBoard.length;
        return playerPos == winningPosition;
    }

    /**
     * Check for is the game still continue or not.
     * @return boolean
     */
    public boolean isGameOver(){
       return  playerPosition.containsValue(gameBoard.length * gameBoard.length);
          }
    /**
     * list of positive and negative wormholes.
     *
     * @param newPosition the position that the player end up on after moving.
     * @return the new position of the player if they reach a wormhole.
     */
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
