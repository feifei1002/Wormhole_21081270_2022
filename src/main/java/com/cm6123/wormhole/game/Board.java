package com.cm6123.wormhole.game;

public class Board {
    private final int BoardSize;
    private int [][] size3Board = {{7,8,9},{6,5,4},{1,2,3}};
    private int [][] size4Board = {{16,15, 14, 13,},{9,10,11,12},{8,7,6,5},{1,2,3,4}};



    public Board(int size){
        BoardSize = size;
    }

    public int getBoardSize3(){
        final int[][] size3 = size3Board;
        return BoardSize;

    }

    public int getBoardSize4(){
        final int[][] size4 = size4Board;
//        for(int i=0;i<size4Board.length;i++){
//            for(int j=0;j<size4Board.length;j++){
//                System.out.print(size4Board[i][j]+" ");
//            }
//            System.out.println(" ");
//        }
        return BoardSize;
    }

    public int getBoardSize5(){
        final int[][] size4Board = this.size4Board;
//        for(int i=0;i<size4Board.length;i++){
//            for(int j=0;j<size4Board.length;j++){
//                System.out.print(size4Board[i][j]+" ");
//            }
//            System.out.println(" ");
//        }
        return BoardSize;
    }


}

