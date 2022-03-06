package com.cm6123.wormhole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WormholeGame {

    public static void main(String []args){
        System.out.println("Welcome to Wormhole!");
        Scanner sc = new Scanner(System.in);
        int NoOfPlayer;
        System.out.println("Please enter the number of player (2-6)");
        NoOfPlayer = sc.nextInt();
        sc.nextLine();
        ArrayList<Players> players = new ArrayList<>();

        while(NoOfPlayer>=2 || NoOfPlayer>6){
            String name = sc.nextLine();
            Players playerName = new Players(name);
            players.add(playerName);
            for(int i =0; i< NoOfPlayer; i++){
                System.out.printf("Please enter player %d's name", players.get(0-7));
//                String name = sc.nextLine();
//                Players playerName = new Players(name);
//                players.add(playerName);
            }
        }
//        List<Players> players = new ArrayList<>();
//        for(int i =0; i< NoOfPlayer; i++){
//            System.out.printf("Please enter player %d's name", players.get(0-7));
//            Players playerName = new Players();
//            players.add(playerName);
//        }

        Boards board = new Boards(players);
//        boolean finished;

    }
//    private List<Players> players;
//    private int PlayerIndex;
//
//    public WormholeGame(String... name){
//        players = new ArrayList<>();
//        for (String names : name) {
//            Players player = new Players(names);
//            players.add(player);
//        }
//        PlayerIndex = 0;
//
//    }
//
//    protected Players getPlayer(){
//
//        return players.get(PlayerIndex);
//    }
//
//    public String toString(){
//        return getPlayer().getName() +" you are on square 1";
//    }
//

}
