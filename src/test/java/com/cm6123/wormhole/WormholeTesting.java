package com.cm6123.wormhole;

import com.cm6123.wormhole.dice.Dice;
import com.cm6123.wormhole.game.Board;
import com.cm6123.wormhole.game.Players;
import com.cm6123.wormhole.game.WormholeGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WormholeTesting {

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
        Players p2 = new Players("Cheng");

        WormholeGame wg = new WormholeGame();
        wg.addPlayer(p1);
        wg.addPlayer(p2);

        Board size4 = new Board(4);
        size4.createBoard();

        //When
        int dice1Roll = aDice1.roll();
        int dice2Roll = aDice2.roll();
        int newPosition = dice1Roll + dice2Roll;

        //Then
        assertEquals(8, wg.move(newPosition));
        assertEquals("Cheng",wg.getCurrentPlayer().getName());

    }
}
