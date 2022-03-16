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
     * uses to create the actual board.
     */
   public void createBoard() {
       //create the board from bottom up
        for (int i = boardSize.length - 1; i >= 0; i--){
            for (int j = 0; j < boardSize.length; j++){
                if (i % 2 != 0) { //check the odd rows
                    System.out.print(boardSize[i][boardSize.length - 1 - j] + " ");
                } else { // even rows
                    System.out.print(boardSize[i][j] + " ");
                } // end of else
            } // end of for loop for columns
            System.out.println();
        } // end of for loop for rows
    } // end of getBoard() method

    /**
     * return the size of the board to uses in the WormholeGame class.
     * @return the size of the board.
     */
    public int getSIZE() {
        return size;
    }

}
