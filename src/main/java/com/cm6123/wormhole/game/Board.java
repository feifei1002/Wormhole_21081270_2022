package com.cm6123.wormhole.game;


public class Board {
    /**
     * An 2D array to store the board.
     */
    private final int[][] boardSize;
    /**
     * The size of the board.
     */
    private final int size;

    /**
     * the constructor of the board.
     * @param board the size of board that will be uses to play the game
     */
    public Board(final int board) {
        size = board;
        boardSize = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boardSize[i][j] = i * size + j + 1;
            } // end of for loop for columns
        } // end of for loop for rows
    } // end of constructor

    /**
     * return the size of the board to uses in the WormholeGame class.
     * @return the size of the board.
     */
    public int getSIZE() {
        return size;
    }

}
