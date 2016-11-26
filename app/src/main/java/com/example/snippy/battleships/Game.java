package com.example.snippy.battleships;

/**
 * Created by Snippy on 2016-11-23.
 */

public class Game {

    private Player p1, p2;
    private Player currentPlayer = p1;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private void nextPlayer() {
        currentPlayer = (currentPlayer == p1) ? p2 : p1;
    }

    public Game() {

    }


}
