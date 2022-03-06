package com.cm6123.wormhole;

import java.util.ArrayList;
import java.util.Scanner;

public class WormholeGame {

    public static void main(String[] args) {

        System.out.println("Welcome to Wormhole!");
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the width dimension that you want to play the game (5-10)");
        int BoardSize = sc.nextInt();

        System.out.println("Please enter the number of player (2-6)");
        int NoOfPlayer = sc.nextInt();
        boolean WithinMaxMin = false;

        ArrayList<Players> players = new ArrayList<>();
        if(WithinMaxMin){
            if (NoOfPlayer >= 2 || NoOfPlayer <= 6) {
                for (int i = 0; i < NoOfPlayer; i++) {
                    System.out.println("Please enter player name");
                    String name = sc.next();
                    Players playerName = new Players(name);
                    players.add(playerName);
                }
            }
        }
        else if (NoOfPlayer < 2) {
            System.out.println("Sorry, the minimum players for this game is 2 players.");
        }
        else if (NoOfPlayer > 6) {
            System.out.println("Sorry, the maximum players for this game is 6 players.");
        }
    }
}
