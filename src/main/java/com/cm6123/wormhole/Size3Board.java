package com.cm6123.wormhole;

import java.util.HashMap;
import java.util.List;

public class Size3Board {

    private final int size3Board[][];
    private final int rows = 3;
    private final int columns = 3;
    private final HashMap<Players, Integer> PlayersPosition = new HashMap<Players, Integer>(6);

    public Size3Board(List<Players> players) {
        size3Board = new int[3][3];
        for (int i = 0; i < size3Board.length; i++) {
            for (int j = 0; j < size3Board.length; j++) {
                size3Board[i][j] = i + j;
            }
        }

    }

    public String create() {
        StringBuilder sb = new StringBuilder();
        boolean rightToLeft = true;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < columns; j++) {
                sb.append(size3Board[rows][columns] + "\t");

            }
        }
        return sb.toString();
    }
}
