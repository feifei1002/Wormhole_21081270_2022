package com.cm6123.wormhole.game;

public class Size4Board {

    private int [][] size4Board = {{1,2,3,4},
                                   {5,6,7,8},
                                   {9,10,11,12},
                                   {13,14,15,16}};
    private static final int SIZE = 4;

    public String getBoard(){
        StringBuilder sb = new StringBuilder();
        for(int i=size4Board.length-1; i>=0;i--){   //create the board from bottom up
            for (int j=0; j< size4Board.length; j++){
                if(i%2!=0){ //check the odd rows (1-4),(9-12)
                    sb.append(size4Board[i][size4Board.length-1-j]+" ");
                }
                else{ // even rows
                    sb.append(size4Board[i][j]+" ");
                }
            }
            sb.append("\n");
        }
        return getBoard();
    }

}
