package com.example.snippy.battleships;

import java.util.ArrayList;

import static com.example.snippy.battleships.Player.State;

/**
 * Created by Snippy on 2016-11-24.
 */

public class Ship {
    private ArrayList<IntPair> segments;
    private State[][] grid;

    public Ship(ArrayList<IntPair> segments) {
        this.segments = segments;
    }

    public Ship(int x, int y, int length, boolean isVertical, State[][] grid) {
        this.grid = grid;
        segments = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            segments.add(new IntPair(x, y));
            if (isVertical) {
                y++;
            } else {
                x++;
            }
        }
    }
    private boolean hasSegmentsLeft() {
        return segments.size() != 0;
    }

    private void refreshSegments() {
        ArrayList<IntPair> toDelete = new ArrayList<>();
        for (IntPair i: segments) {
            if (grid[i.x][i.y] == State.hit) {
                toDelete.add(i);
            }
        }
        segments.removeAll(toDelete);
    }

    boolean isAlive() {
        refreshSegments();
        return hasSegmentsLeft();
    }
}