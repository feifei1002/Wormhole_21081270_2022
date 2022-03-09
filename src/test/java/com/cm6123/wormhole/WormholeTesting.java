package com.cm6123.wormhole;

import com.cm6123.wormhole.dice.Dice;
import com.cm6123.wormhole.game.Board;
import com.cm6123.wormhole.game.Players;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    public void ShouldBeAbleToMoveToSquare8When3And4AreRolled(){
        Dice aDice1;
        aDice1 = mock(Dice.class);
        when(aDice1.roll()).thenReturn(3);

        Dice aDice2;
        aDice2 = mock(Dice.class);
        when(aDice2.roll()).thenReturn(4);

        Players p1 = new Players("Fei");

        int p1Position = p1.getPosition();
        int dice1Roll = aDice1.roll();
        int dice2Roll = aDice2.roll();
        assertEquals(8,dice1Roll+dice2Roll+p1Position);
    }
}
