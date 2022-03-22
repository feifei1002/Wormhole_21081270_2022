package com.cm6123.wormhole.app;

import com.cm6123.wormhole.dice.Dice;
import com.cm6123.wormhole.game.Board;
import com.cm6123.wormhole.game.Players;
import com.cm6123.wormhole.game.WormholeGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public final class Application {
    /**
     * Create a logger for the class.
     */
    private static Logger logger = LoggerFactory.getLogger(Application.class);


    private Application() {
    }

    /**
     * main entry point.
     * If args provided, result is displayed and program exists.
     * Otherwise, user is prompted for
     * input.
     *
     * @param args command line args.
     */
    public static void main(final String[] args) {


        logger.info("Application Started with args:{}", String.join(",", args));

        System.out.println("Hello World.  Welcome to Wormhole.");
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the width dimension that you want to play the game (5-10)");

            int boardSize = sc.nextInt();
            Board gameBoard = new Board(boardSize);

            if (boardSize >= 3 && boardSize <= 10) {
                switch (boardSize) {
                    case 3:
                        System.out.println("Thank you! Your board has 9 squares.");
                        break;
                    case 4:
                        System.out.println("Thank you! Your board has 16 squares.");
                        break;
                    case 5:
                        System.out.println("Thank you! Your board has 25 squares.");
                        break;
                    case 6:
                        System.out.println("Thank you! Your board has 36 squares.");
                        break;
                    case 7:
                        System.out.println("Thank you! Your board has 49 squares.");
                        break;
                    case 8:
                        System.out.println("Thank you! Your board has 64 squares.");
                        break;
                    case 9:
                        System.out.println("Thank you! Your board has 81 squares.");
                        break;
                    case 10:
                        System.out.println("Thank you! Your board has 100 squares.");
                        break;
                    default:
                        return;
                }
            }else{
                System.out.println("Sorry, please enter the correct board size");
                return;
            }
        logger.info("No user input was entered");

            WormholeGame wg = new WormholeGame(gameBoard);

        System.out.println("Please enter the number of player (2-6)");
        int noOfPlayer = sc.nextInt();
        if(noOfPlayer >= 2 && noOfPlayer <= 6){
            for (int i = 0; i<noOfPlayer; i++){
                System.out.println("Please enter player "+(i+1)+"'s name");
                String name = sc.next();
                Players player = new Players(name);
                wg.addPlayer(player);
            }
        }else {
            System.out.println("Sorry, you didn't enter the correct number of player.");
        }
        System.out.println("Let's play!");

        int steps = 0;
        logger.info("This is not running");



        while(!wg.isGameOver()) {
            for (int i = 0; i < wg.getPlayers().size(); i++) {
                System.out.println(wg.getPlayers().get(i).getName() + " - do you want to roll the dice or should I do it for you?");
                System.out.println("Type 'Y' to roll yourself or 'N' to let me do it");
                String diceType = sc.next();
                if (diceType.equals("Y")) {
                    System.out.println("Please enter the value on your first dice");
                    int dice1Roll = sc.nextInt();

                    if (dice1Roll <= 0 || dice1Roll > 6) {
                        System.out.println("Your number is out of bound, please try again");
                        return;
                    }

                    System.out.println("Please enter the value on your second dice");
                    int dice2Roll = sc.nextInt();

                    if (dice2Roll <= 0 || dice2Roll > 6) {
                        System.out.println("Your number is out of bound, please try again");
                        return;
                    }
                    System.out.println("Your first dice rolled a " + dice1Roll + " and your second dice rolled a " + dice2Roll);
                    steps = dice1Roll + dice2Roll;

                } else if (diceType.equals("N")) {
                    Dice dice1 = new Dice(6);
                    Dice dice2 = new Dice(6);
                    int dice1Roll = dice1.roll();
                    int dice2Roll = dice2.roll();
                    System.out.println("Your first dice rolled a " + dice1Roll + " and your second dice rolled a " + dice2Roll);
                    steps = dice1Roll + dice2Roll;
                } else {
                    System.out.println("Please only enter 'Y' or 'N'!");
                }


                System.out.println(wg.getPlayers().get(i).getName() + " is on square " + wg.move(steps) + "!");
                System.out.println();

                wg.getCurrentPlayer();
            }
        }

        logger.info("Application closing");


    }


}
