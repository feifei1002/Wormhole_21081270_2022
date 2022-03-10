package com.cm6123.wormhole;

import com.cm6123.wormhole.dice.Dice;
import com.cm6123.wormhole.game.Board;
import com.cm6123.wormhole.game.Players;
import com.cm6123.wormhole.game.Size4Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WormholeTesting {

    @Test
    public void ShouldBeAbleToCreateASize5Board(){
        Board size5Board = new Board(5);
        assertEquals(5,size5Board.getBoardSize5());
    }

    @Test
    public void ShouldBeAbleToGetPlayerNames(){
        Players p1 = new Players("Fei");
        assertEquals("Fei", p1.getName());
    }

    @Test
    public void AllPlayersShouldBeOnSquare1(){
        Players p1 = new Players("Fei");
        assertEquals(1, p1.getPosition());
    }

    @Test
    public void ShouldBeAbleToMoveToSquare8When34AreRolledOnASize4Board(){
        //Given
        Dice aDice1;
        aDice1 = mock(Dice.class);
        when(aDice1.roll()).thenReturn(3);

        Dice aDice2;
        aDice2 = mock(Dice.class);
        when(aDice2.roll()).thenReturn(4);

        Players p1 = new Players("Fei");

        Size4Board size4Board = new Size4Board();

        int p1Position = p1.getPosition();

        //When
        int dice1Roll = aDice1.roll();
        int dice2Roll = aDice2.roll();
        int CurrentPosition = p1Position+dice1Roll+dice2Roll;

        //Then
        assertEquals(8, CurrentPosition);
    }

    @Test
    public void ShouldBeAbleToDeclareWinnerWhen56AreRolledOnSize3Board(){
        //Given
        Dice aDice1;
        aDice1 = mock(Dice.class);
        when(aDice1.roll()).thenReturn(5);

        Dice aDice2;
        aDice2 = mock(Dice.class);
        when(aDice2.roll()).thenReturn(6);

        Players p1 = new Players("Fei");

        Size4Board size4 = new Size4Board();
        size4.getBoard();

        int p1Position = p1.getPosition();

        //When
        int dice1Roll = aDice1.roll();
        int dice2Roll = aDice2.roll();
        int CurrentPosition = p1Position+dice1Roll+dice2Roll;

        //Then
        assertEquals(12,CurrentPosition);
        assertEquals(p1.getWinner(), p1.CurrentPosition());
    }

}
