package com.cm6123.wormhole.game;


public class Players {
    /**
     * The name of the player.
     */
    private final String name;


    /**
     * Construct the name of the player.
     * @param playerName the player's name.
     */
    public Players(final String playerName) {
        name = playerName;
    } //end of constructor

    /**
     * get the name of the player to play the game.
     * @return the name of the player.
     */
    public String getName() {
        return name;
    } //end of getName method



} //end of Players class
