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
    public void ShouldBeAbleToMoveToSquare8When3And4AreRolledOnASize4Board(){
        //Given
        Dice aDice1;
        aDice1 = mock(Dice.class);
        when(aDice1.roll()).thenReturn(3);

        Dice aDice2;
        aDice2 = mock(Dice.class);
        when(aDice2.roll()).thenReturn(4);

        Players p1 = new Players("Fei");
        Players p2 = new Players("Cheng");

        Board size4 = new Board(4);
        size4.createBoard();

        WormholeGame wg = new WormholeGame(size4);
        wg.addPlayer(p1);
        wg.addPlayer(p2);

        //When
        int dice1Roll = aDice1.roll();
        int dice2Roll = aDice2.roll();
        int position = dice1Roll+dice2Roll;

        //Then
        assertEquals(8, wg.move(position));
        assertEquals("Cheng",wg.getCurrentPlayer().getName());

    }

    @Test
    public void ShouldBeAbleToDeclareWinnerWhen5And6AreRolledOnSize3Board(){
        //Given
        Dice aDice1;
        aDice1 = mock(Dice.class);
        when(aDice1.roll()).thenReturn(5);

        Dice aDice2;
        aDice2 = mock(Dice.class);
        when(aDice2.roll()).thenReturn(6);

        Players p1 = new Players("Fei");
        Players p2 = new Players("Cheng");

        Board size3 = new Board(3);
        size3.createBoard();

        WormholeGame wg = new WormholeGame(size3);
        wg.addPlayer(p1);
        wg.addPlayer(p2);

        //When
        int dice1Roll = aDice1.roll();
        int dice2Roll = aDice2.roll();
        int newPosition = dice1Roll + dice2Roll;
//        wg.play();

        //Then
        assertEquals(9, wg.move(newPosition));
        assertEquals("Fei", wg.getWinner().getName());
    }

    @Test
    public void ShouldReturnBackToPlayer1WhenAllThePlayersHaveRolled(){
       //Given
        Dice dice1 = new Dice(6);
        Dice dice2 = new Dice(6);

        Players p1 = new Players("Fei");
        Players p2 = new Players("Cheng");
        Players p3 = new Players("Steven");
        Players p4 = new Players("Sihyun");

        Board size5 = new Board(5);
        size5.createBoard();

        WormholeGame wg = new WormholeGame(size5);
        wg.addPlayer(p1);
        wg.addPlayer(p2);
        wg.addPlayer(p3);
        wg.addPlayer(p4);

        // When
        wg.getCurrentPlayer();
        wg.move(dice1.roll()+dice2.roll());

        wg.getCurrentPlayer();
        wg.move(dice1.roll()+dice2.roll());

        wg.getCurrentPlayer();
        wg.move(dice1.roll()+dice2.roll());

        wg.getCurrentPlayer();
        wg.move(dice1.roll()+dice2.roll());

        // Then
        assertEquals("Fei", wg.getCurrentPlayer().getName());
    }

    @Test
    public void ShouldEndOnSquare20When6And1AreRolledOnASize5BoardWithAPositiveWormhole(){
       //Given
        Dice aDice1;
        aDice1 = mock(Dice.class);
        when(aDice1.roll()).thenReturn(4);

        Dice aDice2;
        aDice2 = mock(Dice.class);
        when(aDice2.roll()).thenReturn(1);


        Players p1 = new Players("Fei");
        Players p2 = new Players("Cheng");


        Board size5 = new Board(5);
        size5.createBoard();

        WormholeGame wg = new WormholeGame(size5);
        wg.addPlayer(p1);
        wg.addPlayer(p2);

        //When
        int dice1Roll = aDice1.roll();
        int dice2Roll = aDice2.roll();
        int position = dice1Roll+dice2Roll;

        //Then
        assertEquals(20, wg.move(position));
        assertEquals("Cheng", wg.getCurrentPlayer().getName());

    }

    @Test
    public void ShouldEndOnSquare10When5And4AreRolledOnASize5BoardWithTwoPositiveWormholes(){
        //Given
        Dice aDice1;
        aDice1 = mock(Dice.class);
        when(aDice1.roll()).thenReturn(1);

        Dice aDice2;
        aDice2 = mock(Dice.class);
        when(aDice2.roll()).thenReturn(1);


        Players p1 = new Players("Fei");
        Players p2 = new Players("Cheng");


        Board size5 = new Board(5);
        size5.createBoard();

        WormholeGame wg = new WormholeGame(size5);
        wg.addPlayer(p1);
        wg.addPlayer(p2);

        //When
        int dice1Roll = aDice1.roll();
        int dice2Roll = aDice2.roll();
        int position = dice1Roll+dice2Roll;

        //Then
        assertEquals(10, wg.move(position));
        assertEquals("Cheng", wg.getCurrentPlayer().getName());

    }
}
