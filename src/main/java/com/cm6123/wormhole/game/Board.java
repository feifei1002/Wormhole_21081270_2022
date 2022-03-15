package com.cm6123.wormhole.game;


public class Board {

    private final int[][] BoardSize;
    private final int Size;


    public Board(int size) {
        Size = size;
        BoardSize = new int[Size][Size];
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                BoardSize[i][j] = i * Size + j + 1;
            } // end of for loop for columns
        } // end of for loop for rows
    } // end of constructor


   public void createBoard() {
       //create the board from bottom up
        for (int i = BoardSize.length - 1; i >= 0; i--){
            for (int j = 0; j < BoardSize.length; j++){
                if (i % 2 != 0) { //check the odd rows
                    System.out.print(BoardSize[i][BoardSize.length - 1 - j] + " ");
                } else { // even rows
                    System.out.print(BoardSize[i][j] + " ");
                } // end of else
            } // end of for loop for columns
            System.out.println();
        } // end of for loop for rows
    } // end of getBoard() method


    public int getSIZE() {
        return Size;
    }

}