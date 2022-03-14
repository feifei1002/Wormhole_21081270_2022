package com.cm6123.wormhole.game;

import java.util.Map;

public class Board {

    private final int[][] BoardSize;
    private final int SIZE;
    private Map<Players, Integer> players;

    public Board(int size) {
        SIZE = size;
        BoardSize = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                BoardSize[i][j] = i * SIZE + j + 1;
            } // end of for loop for columns
        } // end of for loop for rows
    } // end of constructor

    public void createBoard() {
        for (int i = BoardSize.length - 1; i >= 0; i--) {   //create the board from bottom up
            for (int j = 0; j < BoardSize.length; j++) {
                if (i % 2 != 0) { //check the odd rows
                    System.out.print(BoardSize[i][BoardSize.length - 1 - j] + " ");
                } // end if
                else { // even rows
                    System.out.print(BoardSize[i][j] + " ");
                } // end of else
            } // end of for loop for columns
            System.out.println();
        } // end of for loop for rows
    } // end of getBoard() method

    public int getSIZE() {
        return SIZE;
    }

}