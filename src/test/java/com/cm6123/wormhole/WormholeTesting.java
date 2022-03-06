package com.cm6123.wormhole;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WormholeTesting {

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
//    public void ShouldShowErrorMessageWhenMaximumOfPlayersExceed6(){
//        Players player = new Players("Fei");
//        players.getNoOfPlayers();
//        assertEquals();
//    }

//    @Test
//    public void ShouldBeAbleToMoveToSquare7When3And4AreRolled(){
//        Dice aDice = new Dice();
//        Board aBoard = aDice.roll();
//    }
}
