//
//package com.cm6123.wormhole.game;
//
//import com.cm6123.wormhole.game.Players;
//import com.cm6123.wormhole.game.Size3Board;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class WormholeGame {
//
//    public static void main(String[] args) {
//
//        ArrayList<Players> players = new ArrayList<>();
//
//        System.out.println("Welcome to Wormhole!");
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Please enter the width dimension that you want to play the game (5-10)");
//        int BoardSize = sc.nextInt();
//
////        ArrayList<Integer> boards = new ArrayList<>();
//        if(BoardSize >= 3 && BoardSize <=10){
//            switch(BoardSize){
//                case 3:
//                    System.out.println("Thank you! Your board has 9 squares.");
//                    break;
//                case 4:
//                    System.out.println("Thank you! Your board has 16 squares.");
//                    break;
//                case 5:
//                    System.out.println("Thank you! Your board has 25 squares.");
//                    break;
//                case 6:
//                    System.out.println("Thank you! Your board has 36 squares.");
//                    break;
//                case 7:
//                    System.out.println("Thank you! Your board has 49 squares.");
//                    break;
//                case 8:
//                    System.out.println("Thank you! Your board has 64 squares.");
//                    break;
//                case 9:
//                    System.out.println("Thank you! Your board has 81 squares.");
//                    break;
//                case 10:
//                    System.out.println("Thank you! Your board has 100 squares.");
//                    break;
//                default:
//                    System.out.println("Sorry, please enter the correct board size");
//                    return;
//            }
//        }
//        else if (BoardSize < 5 || BoardSize >10) {
//            System.out.println("Sorry, please enter the correct board size");
//        }
//
//        System.out.println("Please enter the number of player (2-6)");
//        int NoOfPlayer = sc.nextInt();
////        ArrayList<Players> players = new ArrayList<>();
//        if (NoOfPlayer >= 2 && NoOfPlayer <= 6) {
//            for (int i = 0; i < NoOfPlayer; i++) {
//                    System.out.println("Please enter player name");
//                    String name = sc.next();
//                    Players playerName = new Players(name);
//                    players.add(playerName);
//            }
//        }
//
//        else if (NoOfPlayer < 2) {
//            System.out.println("Sorry, the minimum players for this game is 2 players.");
//        }
//        else if (NoOfPlayer > 6) {
//            System.out.println("Sorry, the maximum players for this game is 6 players.");
//        }
//
//        Size3Board board = new Size3Board(players);
//
//        boolean GameContinue = true;
//        int playersTurn = 0;
//        while(GameContinue){
//            Players currentPlayer = players.get(playersTurn);
//            int roll = currentPlayer.playersTakeTurn();
//
//            board.movePlayer(currentPlayer,roll);
//            System.out.println(board);
//
//            if(GameContinue = false){
//                System.out.println(currentPlayer + "wins");
//            }
//            playersTurn++;
//            if(playersTurn == NoOfPlayer){
//                playersTurn = 0;
//            }
//        }
//
//    }
//}
