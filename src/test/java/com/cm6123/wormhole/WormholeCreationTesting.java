package com.cm6123.wormhole;

import com.cm6123.wormhole.dice.Dice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WormholeCreationTesting {

    @Test
    public void ShouldBeAbleToCreateASize5Board(){
        Board size5Board = new Board(5);
        assertEquals(5,size5Board.getBoardSize());
    }

    @Test
    public void ShouldBeAbleToGetPlayerNames(){
        Players p1 = new Players("Fei");
        assertEquals("Fei", p1.getName());
    }

    @Test
    public void PlayersShouldBeOnSquare1(){
        Players p1 = new Players("Fei");
        assertEquals(1, p1.getPosition());
    }

//    @Test
//    public void ShouldBeAbleToGetMaximumOf6Players(){
//        Players players = new Players();
//        players.getNoOfPlayers();
//        assertEquals();
//    }

//    @Test
//    public void ShouldBeAbleToMoveToSquare7When3And4AreRolled(){
//        Dice aDice = new Dice();
//        Board aBoard = aDice.roll();
//    }
}
