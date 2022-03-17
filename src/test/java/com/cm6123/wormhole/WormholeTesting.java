package com.cm6123.wormhole;

import com.cm6123.wormhole.dice.Dice;
import com.cm6123.wormhole.game.Board;
import com.cm6123.wormhole.game.Players;
import com.cm6123.wormhole.game.WormholeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WormholeTesting {

    //extra test
   @Test
    public void ShouldBeAbleToGetPlayerNames(){
        Players p1 = new Players("Fei");
        assertEquals("Fei", p1.getName());
    }

    @DisplayName("Test 1")
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
        wg.getNextPlayer();

        //Then
        assertEquals(8, wg.move(position));
        assertEquals("Cheng",wg.getCurrentPlayer().getName());

    }

    @DisplayName("Test 2")
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

    @DisplayName("Test 3")
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
        wg.getNextPlayer();

        wg.getCurrentPlayer();
        wg.move(dice1.roll()+dice2.roll());
        wg.getNextPlayer();

        wg.getCurrentPlayer();
        wg.move(dice1.roll()+dice2.roll());
        wg.getNextPlayer();

        wg.getCurrentPlayer();
        wg.move(dice1.roll()+dice2.roll());
        wg.getNextPlayer();

        // Then
        assertEquals("Fei", wg.getCurrentPlayer().getName());
    }

    @DisplayName("Test 4")
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
        wg.getNextPlayer();

        //Then
        assertEquals(20, wg.move(position));
        assertEquals("Cheng", wg.getCurrentPlayer().getName());

    }

    @DisplayName("Test 5")
    @Test
    public void ShouldEndOnSquare8When1And1AreRolledOnASize5BoardWithTwoPositiveWormholes(){
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
        wg.getNextPlayer();

        //Then
        assertEquals(8, wg.move(position));
        assertEquals("Cheng", wg.getCurrentPlayer().getName());

    }

    @DisplayName("Test 6")
    @Test
    public void ShouldEndOnSquare2When6And3AreRolledOnASize5BoardWithANegativeWormhole(){
        //Given
        Dice aDice1;
        aDice1 = mock(Dice.class);
        when(aDice1.roll()).thenReturn(6);

        Dice aDice2;
        aDice2 = mock(Dice.class);
        when(aDice2.roll()).thenReturn(3);


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

        wg.getNextPlayer();

        //Then
        assertEquals(2, wg.move(position));
        assertEquals("Cheng", wg.getCurrentPlayer().getName());

    }

    @DisplayName("Test 7")
    @Test
    public void ShouldEndOnSquare3When6And6AreRolledOnASize5BoardWithANegativeWormhole(){
        //Given
        Dice aDice1;
        aDice1 = mock(Dice.class);
        when(aDice1.roll()).thenReturn(6);

        Dice aDice2;
        aDice2 = mock(Dice.class);
        when(aDice2.roll()).thenReturn(6);


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

        wg.getNextPlayer();

        //Then
        assertEquals(3, wg.move(position));
        assertEquals("Cheng", wg.getCurrentPlayer().getName());

    }

    @DisplayName("Test 8")
    @Test
    public void ShouldBeAbleToDeclareWinnerWhen2PlayersRollDiceOnASize5BoardWithAPositiveWormhole(){
        //Given
        Dice aDice1;
        aDice1 = mock(Dice.class);
        when(aDice1.roll()).thenReturn(2);

        Dice aDice2;
        aDice2 = mock(Dice.class);
        when(aDice2.roll()).thenReturn(3);

        Dice aDice3;
        aDice3 = mock(Dice.class);
        when(aDice3.roll()).thenReturn(1);

        Dice aDice4;
        aDice4 = mock(Dice.class);
        when(aDice4.roll()).thenReturn(1);

        Dice aDice5;
        aDice5 = mock(Dice.class);
        when(aDice5.roll()).thenReturn(6);

        Dice aDice6;
        aDice6 = mock(Dice.class);
        when(aDice6.roll()).thenReturn(6);


        Players p1 = new Players("Fei");
        Players p2 = new Players("Cheng");


        Board size5 = new Board(5);
        size5.createBoard();

        WormholeGame wg = new WormholeGame(size5);
        wg.addPlayer(p1);
        wg.addPlayer(p2);

        //When
        wg.getCurrentPlayer();
        wg.move(aDice1.roll()+aDice2.roll());
        wg.getNextPlayer();

        wg.getCurrentPlayer();
        wg.move(aDice3.roll()+aDice4.roll());
        wg.getNextPlayer();

        wg.getCurrentPlayer();

        //Then
        assertEquals(25,wg.move(aDice5.roll()+aDice6.roll()));
        assertEquals("Fei", wg.getWinner().getName());
    }



}
