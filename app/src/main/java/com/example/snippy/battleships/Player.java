package com.example.snippy.battleships;

import java.util.ArrayList;

/**
 * Created by Snippy on 2016-11-23.
 */

interface GameStateProvider {
    Player.EnemyState[][] getCurrentState();
}

public class Player implements GameStateProvider {
    enum State {empty, ship, hit}

    enum EnemyState {undiscovered, empty, hit}

//    private State[][] grid;
    private EnemyState[][] target;

    ArrayList<Ship> fleet;

    public Player(/*State[][] grid,*/EnemyState[][] target, ArrayList<Ship> fleet) {
        for (EnemyState[] row : target) {
            for (EnemyState x : row) {
                x = EnemyState.undiscovered;
            }
        }
        /*for (State[] row : grid) {
            for (State x : row) {
                x = State.empty;
            }
        }*/

//        this.grid = grid;
        this.target = target;
        this.fleet = fleet;
    }

    public void updatePlayer() {
        ArrayList<Ship> toDelete = new ArrayList<>();
        for (Ship ship : fleet) {
            if(!ship.isAlive()) {
                toDelete.add(ship);
            }
        }
        fleet.removeAll(toDelete);
    }

    public boolean hasFleetLeft() {
        return fleet.size() != 0;
    }

    @Override
    public EnemyState[][] getCurrentState() {
        return target;
    }
}
