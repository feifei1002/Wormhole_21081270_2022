package com.cm6123.wormhole;

import com.cm6123.wormhole.dice.Dice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WormholeCreationTesting {

    @Test
    public void ShouldBeAbleToCreateASize3Board(){
        Board size3Board = new Board();
        size3Board.create();
        assertEquals(3,size3Board.length());
    }

    @Test
    public void ShouldBeAbleToGetPlayer1(){
        WormholeGame game = new WormholeGame("Fei");
        Players player1 = game.getPlayer();
        assertEquals("Fei", player1.getName());
    }

    @Test
    public void Player1ShouldBeOnSquare1(){
        WormholeGame game = new WormholeGame("Fei");
        assertEquals("Fei you are on square 1", game.toString());
    }

//    @Test
//    public void ShouldBeAbleToMoveToSquare7When3And4AreRolled(){
//        Dice aDice = new Dice();
//        Board aBoard = aDice.roll();
//    }
}
